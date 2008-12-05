package com.studerb.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.studerb.dao.DaoInterface;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

public abstract class AbstractHibernateDao<T> implements DaoInterface<T> {

	protected final Logger logger;
	protected Class<T> persistentClass;
	protected String tableName;
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	@Autowired
	protected SessionFactory sessionFactory;

	public AbstractHibernateDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.logger = Logger.getLogger(this.persistentClass);
	}

	@Override
	public void clear() {
		this.logger.debug("clearing cache");
		getCurrentSession().clear();
	}

	@Override
	public Long save(T entity) {
		// set created field
		this.logger.debug("saving: " + entity);
		return (Long) getCurrentSession().save(entity);
	}

	@Override
	public void delete(T entity) {
		this.logger.debug("deleting entity: " + entity);
		getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Serializable id) {
		this.logger.debug("deleting entity: " + id);
		T entity = (T) getCurrentSession().load(this.persistentClass, id);
		getCurrentSession().delete(entity);
	}

	@Override
	public int deleteAll() {
		this.logger.debug("Deleting all from table: " + getTableName());
		int count = simpleJdbcTemplate.update("delete from " + getTableName());
		this.logger.info("Deleted All {" + count + "} from " + getTableName());
		return count;
	}

	@Override
	public void flush() {
		this.logger.debug("flushing cache");
		getCurrentSession().flush();
	}

	@Override
	public List<T> getAll() {
		this.logger.debug("getting all " + getTableName());
		Query q = getCurrentSession().createQuery("from " + this.persistentClass.getName());
		return q.list();
	}

	@Override
	public List<T> getAllByOrder(String orderBy, String orderDir) {
		this.logger.debug("getting all " + getTableName() + " by order: " + orderBy + " / " + orderDir);
		Criteria c = getCurrentSession().createCriteria(persistentClass);
		if (orderDir.equalsIgnoreCase("asc")) {
			c.addOrder(Order.asc(orderBy));
		}
		else if (orderDir.equalsIgnoreCase("desc")) {
			c.addOrder(Order.desc(orderBy));
		}
		else {
			throw new IllegalArgumentException("Bad sort order: " + orderBy);
		}
		return c.list();
	}

	@Override
	public int getCount() {
		this.logger.debug("getting count of " + getTableName());
		return this.simpleJdbcTemplate.queryForInt("Select count(*) from " + getTableName());
	}

	@Override
	public T get(Serializable id) {
		this.logger.debug("reading " + getTableName() + " - " + id);
		return (T) getCurrentSession().get(this.persistentClass, id);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.logger.debug("Saving/Updating " + entity);
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		this.logger.debug("updating " + entity);
		getCurrentSession().update(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities) {
		logger.debug("Saving/Updating all " + entities.size() + " " + persistentClass.getSimpleName());
		Iterator<T> iterator = entities.iterator();
		while (iterator.hasNext()) {
			getCurrentSession().saveOrUpdate(iterator.next());
		}
	}

	@Override
	public DataPage<T> getPage(DataPageInfo info) {
		Criteria criteria = getCurrentSession().createCriteria(persistentClass);
		criteria.setMaxResults(info.getPageSize());
		criteria.setFirstResult(info.getCurrentRecord());

		if (info.isSortDesc()) {
			criteria.addOrder(Property.forName(info.getSort()).desc());
		}
		else {
			criteria.addOrder(Property.forName(info.getSort()).asc());
		}

		List<T> data = criteria.list();
		// don't show a datapage with no records
		if (data.isEmpty() && info.getCurrentPage() != 1) {
			info.prev();
			return getPage(info);
		}

		// get the row counts
		Criteria sizeCriteria = getCurrentSession().createCriteria(persistentClass);
		sizeCriteria.setProjection(Projections.rowCount());
		Integer total = (Integer) sizeCriteria.uniqueResult();
		logger.debug("Obtained dataPage: " + info.toString());
		return new DataPage<T>(data, total, info);
	}

	@Override
	public T load(Serializable id) {
		logger.debug("Loading " + persistentClass.getSimpleName() + " with id: " + id);
		return (T) getCurrentSession().load(this.persistentClass, id);
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public abstract String getTableName();
}
