package com.paradigm.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.paradigm.model.Book;
import com.paradigm.web.util.DataPage;
import com.paradigm.web.util.DataPageInfo;
import com.paradigm.web.util.BookSearchModel;

public interface BookService {

	/**
	 * delete the book
	 * 
	 * @param book
	 */

	public void delete(Book book);

	/**
	 * delete book using id
	 * 
	 * @param id
	 */

	public void delete(Long id);

	/**
	 * delete all the books
	 * 
	 * @param book
	 * @return number of books deleted
	 */
	int deleteAll(Collection<Book> books);

	/**
	 * Delete collection of books using the id
	 * 
	 * @param bookIds
	 * @return number of books deleted
	 */
	int deleteAll(List<Long> bookIds);

	/**
	 * fetch the book
	 * 
	 * @param id
	 * @return
	 */
	Book get(Long id);

	/**
	 * Save or update the book
	 * 
	 * @param book
	 */
	Long save(Book book);

	void saveOrUpdateAll(Collection<Book> books);

	/**
	 * @return list of all books
	 */
	List<Book> getAll();

	DataPage<Book> getDatePage(DataPageInfo info);

	/**
	 * Update a book
	 * 
	 * @param w
	 */
	void update(Book w);

	/**
	 * Delete all books from persistence
	 * 
	 * @return count of rows deleted
	 */
	int deleteAllObjects();

	boolean isNameUsed(String name);

	List<Book> search(BookSearchModel bookSearchModel);

	DataPage<Book> searchDataPage(BookSearchModel bookSM, DataPageInfo dpi);

}
