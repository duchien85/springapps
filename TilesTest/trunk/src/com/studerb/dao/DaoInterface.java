package com.studerb.dao;

import java.util.List;

import org.hibernate.Session;
import org.joda.time.DateTime;

/**
 * @param <T>
 *            class type of object Crud and bulk operations
 */
public interface DaoInterface<T> {

	void batchInsert(List<T> entities);

	// cache control operations
	void clear();

	// crud operations
	Long create(T entity);

	void delete(T entity);

	int deleteAll();

	int deleteAllBefore(DateTime before);

	void flush();

	// bulk operations
	List<T> getAll();

	List<T> getAllByOrder(String orderBy, String orderDir);

	int getCount();

	Session getCurrentSession();

	T read(Long id);

	void saveOrUpdate(T entity);

	void setTableName(String tableName);

	void update(T entity);
}
