package com.studerb.hr.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao<T> implements DaoInterface<T> {

    protected final Logger logger;
    protected Class<T> persistentClass;
    protected String tableName;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractHibernateDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.logger = Logger.getLogger(this.persistentClass);
    }

    @Override
    public void clear() {
        this.logger.debug("clearing cache");
        this.getCurrentSession().clear();
    }

    @Override
    public Long save(T entity) {
        this.logger.debug("saving: " + entity);
        return (Long) this.getCurrentSession().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.logger.debug("deleting entity: " + entity);
        this.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void delete(Serializable id) {
        this.logger.debug("deleting entity: " + id);
        T entity = (T) this.getCurrentSession().load(this.persistentClass, id);
        this.getCurrentSession().delete(entity);
    }

    @Override
    public int deleteAll() {
        this.logger.debug("Deleting all from table: " + this.getTableName());
        SQLQuery query = this.getCurrentSession().createSQLQuery("truncate table: " + this.getTableName());
        int count = query.executeUpdate();
        this.logger.info("Truncated table " + this.getTableName());
        return count;
    }

    @Override
    public void flush() {
        this.logger.debug("flushing cache");
        this.getCurrentSession().flush();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        this.logger.debug("getting all " + this.getTableName());
        Query q = this.getCurrentSession().createQuery("from " + this.persistentClass.getName());
        return q.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAllByOrder(String orderBy, String orderDir) {
        this.logger.debug("getting all " + this.getTableName() + " by order: " + orderBy + " / " + orderDir);
        Criteria c = this.getCurrentSession().createCriteria(this.persistentClass);
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
        SQLQuery query = this.getCurrentSession().createSQLQuery("Select count(*) from " + this.getTableName());
        BigDecimal count = (BigDecimal) query.uniqueResult();
        this.logger.debug("count of " + this.getTableName() + " = " + count);
        return count.intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Serializable id) {
        this.logger.debug("reading " + this.getTableName() + " - " + id);
        return (T) this.getCurrentSession().get(this.persistentClass, id);
    }

    @Override
    public void saveOrUpdate(T entity) {
        this.logger.debug("Saving/Updating " + entity);
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        this.logger.debug("updating " + entity);
        this.getCurrentSession().update(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<T> entities) {
        this.logger.debug("Saving/Updating all " + entities.size() + " " + this.persistentClass.getSimpleName());
        Iterator<T> iterator = entities.iterator();
        while (iterator.hasNext()) {
            this.getCurrentSession().saveOrUpdate(iterator.next());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T load(Serializable id) {
        this.logger.debug("Loading " + this.persistentClass.getSimpleName() + " with id: " + id);
        return (T) this.getCurrentSession().load(this.persistentClass, id);
    }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void flushAndClear() {
        this.flush();
        this.clear();
    }

    @Override
    public boolean exists(Serializable id) {
        Query q = getCurrentSession().createQuery(
                "select count(x) from " + this.persistentClass.getSimpleName() + " x where x.id = :id");
        q.setParameter("id", id, Hibernate.LONG);
        Long count = (Long) q.uniqueResult();
        return count.equals(1L);
    }

    @Override
    public abstract String getTableName();
}
