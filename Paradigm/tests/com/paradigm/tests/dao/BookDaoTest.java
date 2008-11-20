package com.paradigm.tests.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.paradigm.dao.BookDao;
import com.paradigm.model.Book;
import com.paradigm.web.util.DataPage;
import com.paradigm.web.util.DataPageInfo;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class BookDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

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
	public void testCreate() {
		Book book = Book.createRandomBook();
		Assert.assertTrue(book.getId() == null);
		assertEquals(countRowsInTable("book"), 0);
		bookDao.save(book);
		bookDao.flush();
		assertTrue(book.getId() != null);
		assertEquals(countRowsInTable("book"), 1);
	}

	@Test
	public void testDelete() {
		Book book = Book.createRandomBook();
		assertEquals(countRowsInTable("book"), 0);
		bookDao.save(book);
		bookDao.flush();
		assertTrue(book.getId() != null);
		assertEquals(countRowsInTable("book"), 1);
		bookDao.delete(book);
		bookDao.flush();
		assertEquals(countRowsInTable("book"), 0);
	}

	@Test
	public void testDeleteById() {
		Book book = Book.createRandomBook();
		assertEquals(countRowsInTable("book"), 0);
		bookDao.save(book);
		bookDao.flush();
		assertTrue(book.getId() != null);
		assertEquals(countRowsInTable("book"), 1);
		bookDao.delete(book.getId());
		bookDao.flush();
		assertEquals(countRowsInTable("book"), 0);
	}

	@Test
	public void testDeleteAll() {
		final int COUNT = 10;
		List<Book> books = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books.add(w);
			Long id = bookDao.save(w);
			assertNotNull(id);
		}
		bookDao.flush();
		assertEquals(countRowsInTable("book"), COUNT);

		bookDao.deleteAll();
		bookDao.flush();
		assertEquals(countRowsInTable("book"), 0);
	}

	@Test
	public void testGetAll() {
		final int COUNT = 10;
		List<Book> books = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books.add(w);
			Long id = bookDao.save(w);
			assertNotNull(id);
		}
		bookDao.flush();
		assertEquals(countRowsInTable("book"), COUNT);

		List<Book> fetchedBooks = bookDao.getAll();
		bookDao.flush();
		assertEquals(fetchedBooks.size(), COUNT);
	}

	@Test
	public void testGetAllByOrder() {
		Book book0 = Book.createRandomBook();
		Book book1 = Book.createRandomBook();
		Book book2 = Book.createRandomBook();

		book0.setPrice(new BigDecimal(10.00));
		bookDao.save(book0);

		book1.setPrice(new BigDecimal(25.00));
		bookDao.save(book1);

		book2.setPrice(new BigDecimal(0.75));
		bookDao.save(book2);
		bookDao.flush();

		List<Book> books = bookDao.getAllByOrder("price", "asc");
		assertEquals(books.size(), 3);

		assertEquals(books.get(0), book2);
		assertEquals(books.get(1), book0);
		assertEquals(books.get(2), book1);
	}

	@Test
	public void testGetCountAndSaveUpdateAll() {
		final int COUNT = 10;
		List<Book> books = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			books.add(w);
			assertNull(w.getId());
		}
		bookDao.saveOrUpdateAll(books);
		for (Book w : books) {
			assertNotNull(w.getId());
		}
		bookDao.flush();
		assertEquals(countRowsInTable("book"), COUNT);
		int count = bookDao.getCount();
		assertEquals(countRowsInTable("book"), count);

		bookDao.deleteAll();
		count = bookDao.getCount();
		assertEquals(0, count);
	}

	@Test
	public void testGet() {
		Book w = Book.createRandomBook();
		Long id = bookDao.save(w);
		bookDao.flush();
		bookDao.clear();
		Book fetched = bookDao.get(id);
		assertEquals(fetched, w);
		assertTrue(fetched != w);
	}

	@Test
	public void testSaveOrUpdate() {
		Book w = Book.createRandomBook();
		assertNull(w.getId());
		bookDao.saveOrUpdate(w);
		bookDao.flush();
		bookDao.clear();
		Long id = w.getId();
		assertNotNull(id);

		BigDecimal newPrice = new BigDecimal("25.50");
		w.setPrice(newPrice);
		bookDao.saveOrUpdate(w);
		bookDao.flush();
		bookDao.clear();

		Book fetched = bookDao.get(id);
		assertTrue(fetched.getPrice().equals(newPrice));
	}

	@Test(expected = Exception.class)
	public void testNonUniqueName() {
		Book book1 = Book.createRandomBook();
		Book book2 = Book.createRandomBook();
		book2.setBookName(book1.getBookName());
		bookDao.save(book1);
		bookDao.save(book2);
	}

	@Test
	public void testIsNameUsed() {
		Book book1 = Book.createRandomBook();
		bookDao.save(book1);
		bookDao.flush();
		bookDao.clear();
		assertTrue(bookDao.isNameUsed(book1.getBookName()));
		assertFalse(bookDao.isNameUsed(RandomStringUtils.randomAlphabetic(20)));
	}

	@Test
	public void testGetDatePage() {
		int COUNT = 52;
		List<Book> books = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book w = Book.createRandomBook();
			// avoid duplicate names
			w.setBookName(w.getBookName() + "_" + String.valueOf(i));
			books.add(w);
		}
		bookDao.saveOrUpdateAll(books);
		bookDao.flush();
		bookDao.clear();

		assertEquals(countRowsInTable("book"), COUNT);

		// default: size=10, sort=id, desc=false
		DataPageInfo info = new DataPageInfo();
		assertTrue(info.getTotalRecords() == 0);
		assertTrue(info.getPageSize() == 10);
		DataPage<Book> bookDp = bookDao.getPage(info);
		assertEquals(bookDp.getData().size(), 10);
		assertEquals(info.getTotalRecords(), COUNT);

		Book first = bookDp.getData().get(0);
		logger.debug("first: " + first.toString());

		// getting 11-20
		info.next();
		// getting 21-30
		info.next();
		bookDp = bookDao.getPage(info);
		assertEquals(bookDp.getData().size(), 10);

		// getting 31-40
		info.next();
		// getting 41-50
		info.next();
		// getting 51-52
		info.next();
		bookDp = bookDao.getPage(info);
		assertEquals(bookDp.getData().size(), 2);

		// getting 61-70 --> should go back to 51-52
		info.next();
		bookDp = bookDao.getPage(info);
		assertEquals(bookDp.getData().size(), 2);

	}
}
