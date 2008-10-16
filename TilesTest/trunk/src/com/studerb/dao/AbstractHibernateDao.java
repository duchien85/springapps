package com.studerb.dao;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

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
	public int deleteAll() {
		int count = simpleJdbcTemplate.update("delete from " + this.tableName);
		this.logger.info("Deleted All {" + count + "} from " + this.tableName);
		return count;
	}

	@Override
	public void flush() {
		this.logger.debug("flushing cache");
		getCurrentSession().flush();
	}

	@Override
	public List<T> getAll() {
		this.logger.debug("getting all " + this.tableName);
		Query q = getCurrentSession().createQuery("from " + this.persistentClass.getName());
		return q.list();
	}

	@Override
	public List<T> getAllByOrder(String orderBy, String orderDir) {
		this.logger.debug("getting all " + this.tableName + " by order: " + orderBy + " / " + orderDir);
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
		this.logger.debug("getting count of " + this.tableName);
		return this.simpleJdbcTemplate.queryForInt("Select count(*) from " + this.tableName);
	}

	@Override
	public T get(Long id) {
		this.logger.debug("reading " + this.tableName + " - " + id);
		return (T) getCurrentSession().get(this.persistentClass, id);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.logger.debug("Saving/Updating " + entity);
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
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

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
