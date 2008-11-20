package com.paradigm.tests.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.paradigm.dao.BookDao;
import com.paradigm.model.Book;
import com.paradigm.web.util.BookSearchModel;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class BookDaoSearchTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	BookDao bookDao;

	BookSearchModel wsm;

	@Before
	public void setUp() throws Exception {
		deleteFromTables("book");
		wsm = new BookSearchModel();
	}

	@After
	public void tearDown() throws Exception {
		deleteFromTables("book");
		wsm = null;
	}

	@Test
	public void testSearchName() {
		Book book1 = Book.createRandomBook();
		Book book2 = Book.createRandomBook();
		bookDao.save(book1);
		bookDao.save(book2);
		bookDao.flush();
		bookDao.clear();

		List<Book> books = bookDao.search(wsm);
		assertEquals(books.size(), 2);
		bookDao.clear();

		wsm.setName("abcd");
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 0);

		wsm.setName(book1.getBookName());
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 1);

		wsm.setName(book2.getBookName());
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 1);
	}

	@Test
	public void testSearchNameAnywhereICase() {
		Book book1 = Book.createRandomBook();
		book1.setBookName("aaabbbccc");
		Book book2 = Book.createRandomBook();
		book2.setBookName("bbb");
		Book book3 = Book.createRandomBook();
		book3.setBookName("AAABBBCCCD");
		Book book4 = Book.createRandomBook();
		book4.setBookName("CD");

		bookDao.save(book1);
		bookDao.save(book2);
		bookDao.save(book3);
		bookDao.save(book4);
		bookDao.flush();
		bookDao.clear();

		wsm.setName("bbb");
		List<Book> books = bookDao.search(wsm);
		assertEquals(books.size(), 3);
		bookDao.clear();

		wsm.setName("aaa");
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 2);

		wsm.setName("Z");
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 0);

		wsm.setName("C");
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 3);

		wsm.setName("");
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 4);
	}

	@Test
	public void testSearchByCool() {
		Book book1 = Book.createRandomBook();
		book1.setCool(Boolean.TRUE);
		Book book2 = Book.createRandomBook();
		book2.setCool(Boolean.FALSE);
		bookDao.save(book1);
		bookDao.save(book2);
		bookDao.flush();
		bookDao.clear();

		List<Book> books = bookDao.search(wsm);
		assertEquals(books.size(), 2);
		bookDao.clear();

		wsm.setCool(Boolean.TRUE);
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 1);

		wsm.setCool(Boolean.FALSE);
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 1);
	}

	@Test
	public void testSearchByPrice() {
		Book book1 = Book.createRandomBook();
		book1.setPrice(new BigDecimal("1.00"));
		Book book2 = Book.createRandomBook();
		book2.setPrice(new BigDecimal("10.00"));
		Book book3 = Book.createRandomBook();
		book3.setPrice(new BigDecimal("100.00"));
		Book book4 = Book.createRandomBook();
		book4.setPrice(new BigDecimal("1000.00"));
		bookDao.save(book1);
		bookDao.save(book2);
		bookDao.save(book3);
		bookDao.save(book4);
		bookDao.flush();
		bookDao.clear();

		List<Book> books = bookDao.search(wsm);
		assertEquals(books.size(), 4);
		bookDao.clear();

		wsm.setBeginPrice(new BigDecimal("10000.00"));
		wsm.setEndPrice(null);
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 0);

		wsm.setBeginPrice(null);
		wsm.setEndPrice(new BigDecimal("0.50"));
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 0);

		wsm.setBeginPrice(new BigDecimal("50.00"));
		wsm.setEndPrice(new BigDecimal("999.00"));
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 1);

		wsm.setBeginPrice(new BigDecimal("00.99"));
		wsm.setEndPrice(new BigDecimal("1.01"));
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 1);

		wsm.setBeginPrice(new BigDecimal("00.50"));
		wsm.setEndPrice(new BigDecimal("100.00"));
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 2);

		wsm.setBeginPrice(new BigDecimal("00.01"));
		wsm.setEndPrice(new BigDecimal("1000000.00"));
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 4);

		wsm.setBeginPrice(new BigDecimal("01.00"));
		wsm.setEndPrice(new BigDecimal("1000.01"));
		books = bookDao.search(wsm);
		bookDao.clear();
		assertEquals(books.size(), 3);
	}
}
