package com.paradigm.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paradigm.dao.BookDao;
import com.paradigm.model.Book;
import com.paradigm.service.interfaces.BookService;
import com.paradigm.web.util.DataPage;
import com.paradigm.web.util.DataPageInfo;
import com.paradigm.web.util.BookSearchModel;

@Service("bookService")
public class DefaultBookService implements BookService {
	Logger logger = Logger.getLogger(DefaultBookService.class);

	@Autowired
	BookDao bookDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.paradigm.service.BookService#delete(com.paradigm.model.Book)
	 */
	@Transactional
	@Override
	public void delete(Book book) {
		logger.debug("Deleting book: " + book.toString());
		bookDao.delete(book);
	}

	@Transactional
	@Override
	public int deleteAll(Collection<Book> books) {
		logger.debug("Deleting all " + books.size() + " books from collection");
		int deleted = 0;
		for (Book w : books) {
			bookDao.delete(w);
			deleted++;
		}
		logger.debug("Successfully deleted: " + deleted + " books");
		return deleted;
	}

	@Transactional
	@Override
	public int deleteAllObjects() {
		logger.debug("Deleting all books from persistence");
		int deleted = bookDao.deleteAll();
		logger.debug("deleted all: " + deleted + " books");
		return deleted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.paradigm.service.BookService#find(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Book get(Long id) {
		logger.debug("Finding book with id: " + id);
		return bookDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.paradigm.service.BookService#saveOrUpdate(com.paradigm.model.Book)
	 */
	@Transactional
	@Override
	public Long save(Book book) {
		logger.debug("Saving book: " + book.toString());
		return bookDao.save(book);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> getAll() {
		List<Book> books = bookDao.getAll();
		logger.debug("fetched " + books.size() + " books");
		return books;
	}

	@Transactional
	@Override
	public void update(Book book) {
		logger.debug("Updating book: " + book.toString());
		bookDao.update(book);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isNameUsed(String name) {
		boolean used = bookDao.isNameUsed(name);
		logger.debug("Book name: " + name + " already used: " + used);
		return used;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		logger.debug("deleting book: " + id);
		bookDao.delete(id);
	}

	@Override
	@Transactional
	public int deleteAll(List<Long> bookIds) {
		Long[] ids = bookIds.toArray(new Long[0]);
		logger.debug("deleting books: " + Arrays.toString(ids));
		int count = 0;
		for (Long id : bookIds) {
			Book w = bookDao.get(id);
			bookDao.delete(w);
			count++;
		}
		return count;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> search(BookSearchModel bookSearchModel) {
		List<Book> books = bookDao.search(bookSearchModel);
		logger.debug("found " + books.size() + " books");
		return books;
	}

	@Override
	@Transactional
	public void saveOrUpdateAll(Collection<Book> books) {
		logger.debug("Saving/updating " + books.size() + " books");
		bookDao.saveOrUpdateAll(books);
	}

	@Override
	@Transactional(readOnly = true)
	public DataPage<Book> getDatePage(DataPageInfo info) {
		logger.debug("getting data page of books -> dpInfo: " + info.toString());
		return bookDao.getPage(info);
	}

	@Override
	@Transactional(readOnly = true)
	public DataPage<Book> searchDataPage(BookSearchModel bookSM, DataPageInfo dpi) {
		DataPage<Book> dataPage = bookDao.searchDataPage(bookSM, dpi);
		logger.debug("found " + dataPage.getData().size() + " books");
		return dataPage;
	}

}
