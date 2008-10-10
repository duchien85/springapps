package com.studerb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public abstract class AbstractHibernateDao<T> implements DaoInterface<T> {

	protected final Logger logger;
	protected Class<T> persistentClass;
	protected String tableName;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	@Autowired
	protected SessionFactory sessionFactory;

	public AbstractHibernateDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.logger = Logger.getLogger(this.persistentClass);
	}

	@Override
	public void batchInsert(List<T> entities) {
		this.logger.debug("Batch persisting " + entities.size() + " entities of type: " + this.persistentClass.getSimpleName());
		for (T entity : entities) {
			getCurrentSession().persist(entity);
		}
	}

	@Override
	public void clear() {
		this.logger.debug("clearing cache");
		getCurrentSession().clear();
	}

	@Override
	public Long create(T entity) {
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
		Query q = getCurrentSession().createQuery("delete from " + this.tableName);
		int count = q.executeUpdate();
		this.logger.info("Deleted All {" + count + "} from " + this.tableName);
		return count;
	}

	/**
	 * Delete all entities whose lastUpdated field is before the passed datetime
	 * parameter
	 * 
	 * @param before
	 *            instance in time entity was lastUpdated
	 */
	@Override
	public int deleteAllBefore(DateTime before) {
		String sql = "delete from " + this.tableName + " where LAST_UPDATED < ?";
		return this.simpleJdbcTemplate.update(sql, before);
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
		Query q = getCurrentSession().createQuery("from " + this.persistentClass.getName() + " order by " + orderBy + " " + orderDir);
		return q.list();
	}

	@Override
	public int getCount() {
		this.logger.debug("getting count of " + this.tableName);
		return this.simpleJdbcTemplate.queryForInt("Select count(*) from " + this.tableName);
	}

	@Override
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public T read(Long id) {
		this.logger.debug("reading " + this.tableName + " - " + id);
		return (T) getCurrentSession().get(this.persistentClass, id);
	}

	public void saveOrUpdate(T entity) {
		this.logger.debug("Saving/Updating " + entity);
		getCurrentSession().saveOrUpdate(entity);
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void update(T entity) {
		this.logger.debug("updating " + entity);
		getCurrentSession().update(entity);
	}
}
