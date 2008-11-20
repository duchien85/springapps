package com.paradigm.tests.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.paradigm.dao.BookDao;
import com.paradigm.model.Book;
import com.paradigm.service.interfaces.BookService;

@ContextConfiguration(locations = { "classpath:/test-context.xml" })
public class BookServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static Logger logger = Logger.getLogger(BookServiceTest.class);

	@Autowired
	BookService bookService;
	@Autowired
	BookDao bookDao;

	@Before
	public void setUp() throws Exception {
		deleteFromTables("book");
	}

	@After
	public void tearDown() throws Exception {
		deleteFromTables("book");
	}

	@Test
	public void testDelete() throws Exception {
		Book w = Book.createRandomBook();
		bookDao.save(w);
		assertTrue(w.getId() != null);
		bookDao.flush();
		bookDao.clear();
		assertEquals(1, countRowsInTable("book"));
		bookService.delete(w);
		bookDao.flush();
		bookDao.clear();
		assertEquals(0, countRowsInTable("book"));
	}

	@Test
	public void testDeleteAllById() throws Exception {
		Book w = Book.createRandomBook();
		bookDao.save(w);
		bookDao.flush();
		bookDao.clear();
		assertEquals(1, countRowsInTable("book"));
		bookService.delete(w.getId());
		bookDao.flush();
		bookDao.clear();
		assertEquals(0, countRowsInTable("book"));
	}

	@Test
	public void testDeleteListByIds() {
		int COUNT = 10;
		List<Book> books1 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books1.add(w);
		}
		List<Book> books2 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books2.add(w);
		}

		bookDao.saveOrUpdateAll(books1);
		bookDao.saveOrUpdateAll(books2);
		bookDao.flush();
		bookDao.clear();

		assertEquals(COUNT * 2, countRowsInTable("book"));

		List<Long> ids1 = new ArrayList(books1.size());
		for (Book w : books1) {
			ids1.add(w.getId());
		}

		List<Long> ids2 = new ArrayList(books2.size());
		for (Book w : books2) {
			ids2.add(w.getId());
		}
		int deleted = bookService.deleteAll(ids1);
		assertEquals(deleted, COUNT);
		bookDao.flush();
		bookDao.clear();
		assertEquals(COUNT, countRowsInTable("book"));

		List<Long> dummy = new ArrayList<Long>();
		deleted = bookService.deleteAll(dummy);
		assertEquals(deleted, 0);
		bookDao.flush();
		bookDao.clear();
		assertEquals(COUNT, countRowsInTable("book"));

		deleted = bookService.deleteAll(ids2);
		assertEquals(deleted, 10);
		bookDao.flush();
		bookDao.clear();
		assertEquals(0, countRowsInTable("book"));
	}

	@Test
	public void testDeleteAllByList() {
		int COUNT = 10;
		List<Book> books1 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books1.add(w);
		}
		List<Book> books2 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books2.add(w);
		}

		bookDao.saveOrUpdateAll(books1);
		bookDao.saveOrUpdateAll(books2);
		bookDao.flush();
		bookDao.clear();

		assertEquals(COUNT * 2, countRowsInTable("book"));

		int deleted = bookService.deleteAll(books1);
		assertEquals(deleted, COUNT);
		bookDao.flush();
		bookDao.clear();
		assertEquals(COUNT, countRowsInTable("book"));

		List<Book> dummy = new ArrayList<Book>();
		deleted = bookService.deleteAll(dummy);
		assertEquals(deleted, 0);
		bookDao.flush();
		bookDao.clear();
		assertEquals(COUNT, countRowsInTable("book"));

		deleted = bookService.deleteAll(books2);
		assertEquals(deleted, 10);
		bookDao.flush();
		bookDao.clear();
		assertEquals(0, countRowsInTable("book"));
	}

	@Test
	public void deleteAllRows() {
		int COUNT = 10;
		List<Book> books1 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books1.add(w);
		}
		List<Book> books2 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books2.add(w);
		}

		bookDao.saveOrUpdateAll(books1);
		bookDao.saveOrUpdateAll(books2);
		bookDao.save(Book.createRandomBook());
		bookDao.flush();
		bookDao.clear();

		int deleted = bookService.deleteAllObjects();
		assertEquals(deleted, COUNT * 2 + 1);
		bookDao.flush();
		bookDao.clear();
		assertEquals(0, countRowsInTable("book"));
	}

	@Test
	public void testGet() {
		Book w = Book.createRandomBook();
		try {
			bookService.save(w);
		}
		catch (Exception e) {}
		assertEquals(countRowsInTable("book"), 1);
	}

	@Test
	public void testGetAll() {
		int COUNT = 10;
		List<Book> books = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books.add(w);
		}
		bookDao.saveOrUpdateAll(books);
		bookDao.flush();
		bookDao.clear();
		List<Book> fetched = bookService.getAll();
		assertEquals(fetched.size(), COUNT);
	}

	@Test
	public void testUpdate() {
		Book w = Book.createRandomBook();
		bookDao.save(w);
		bookDao.flush();
		bookDao.clear();
		Boolean opposite = w.isCool() ? false : true;
		w.setCool(opposite);
		bookService.update(w);
		bookDao.flush();
		bookDao.clear();
		Book fetched = bookDao.get(w.getId());
		assertEquals(fetched.isCool(), opposite);
	}

	@Test(expected = Exception.class)
	public void testDuplicateName() throws Exception {
		Book w = Book.createRandomBook();
		bookDao.save(w);
		bookDao.flush();
		bookDao.clear();

		Book w2 = Book.createRandomBook();
		w2.setBookName(w.getBookName());
		bookService.save(w2);
	}

	public void testIsNameUsed() throws Exception {
		Book w1 = Book.createRandomBook();
		bookDao.save(w1);
		bookDao.flush();
		bookDao.clear();

		assertTrue(bookService.isNameUsed(w1.getBookName()));
		assertFalse(bookService.isNameUsed("dummy"));
	}

	@Test
	public void testSaveOrUpdateAll() {
		int COUNT = 10;
		List<Book> books1 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books1.add(w);
		}
		List<Book> books2 = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books2.add(w);
		}

		bookDao.saveOrUpdateAll(books1);
		bookDao.flush();
		bookDao.clear();
		assertEquals(COUNT, countRowsInTable("book"));

		bookDao.saveOrUpdateAll(books2);
		bookDao.flush();
		bookDao.clear();
		assertEquals(COUNT * 2, countRowsInTable("book"));

		for (Book w : books2) {
			w.setCool(!w.isCool());
		}

		bookDao.saveOrUpdateAll(books2);
		bookDao.flush();
		bookDao.clear();
		assertEquals(COUNT * 2, countRowsInTable("book"));
	}

}
