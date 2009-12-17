package com.studerb.hr.dao;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @param <T>
 *            class type of object Crud and bulk operations
 */
public interface DaoInterface<T> {

	void saveOrUpdateAll(Collection<T> entities);

	// cache control operations
	void clear();

	// crud operations
	Long save(T entity);

	void delete(T entity);

	void delete(Serializable id);

	int deleteAll();

	void flush();

	List<T> getAll();

	//DataPage<T> getPage(DataPageInfo info);

	//List<T> getJmesa(TableFacade tableFacade);

	List<T> getAllByOrder(String orderBy, String orderDir);

	int getCount();

	T get(Serializable id);

	void saveOrUpdate(T entity);

	void update(T entity);

	String getTableName();

	T load(Serializable id);
}
