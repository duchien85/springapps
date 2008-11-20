package com.paradigm.tests.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.BindException;

import com.paradigm.model.Book;
import com.paradigm.model.validator.BookValidator;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class BookValidatorTest {

	private Book book;
	private BookValidator bookValidator;
	private BindException errors;

	@Before
	public void setUp() throws Exception {
		book = Book.createRandomBook();
		bookValidator = new BookValidator();
		errors = new BindException(book, "book");
		assertFalse(errors.hasErrors());
	}

	@After
	public void tearDown() throws Exception {
		book = null;
		errors = null;
	}

	@Test
	public void testNullBookName() {
		book.setBookName(null);
		bookValidator.validate(book, errors);
		assertTrue(errors.hasFieldErrors("bookName"));
	}

	@Test
	public void testSetBookNameTooLong() {
		book.setBookName(RandomStringUtils.random(Book.MAX_NAME_LENGTH + 5));
		bookValidator.validate(book, errors);
		assertTrue(errors.hasFieldErrors("bookName"));
	}

	@Test
	public void testPriceNull() {
		book.setPrice(null);
		bookValidator.validate(book, errors);
		assertTrue(errors.hasFieldErrors("price"));
	}

	@Test
	public void testPriceNegative() {
		book.setPrice(new BigDecimal("-23.343"));
		bookValidator.validate(book, errors);
		assertTrue(errors.hasFieldErrors("price"));
	}

	@Test
	public void testCoolNull() {
		book.setCool(null);
		bookValidator.validate(book, errors);
		assertTrue(errors.hasFieldErrors("cool"));

	}

	@Test
	public void testInitialTimeNull() {
		book.setInitialTime(null);
		bookValidator.validate(book, errors);
		assertTrue(errors.hasFieldErrors("initialTime"));
	}

	@Test
	public void testGood() {
		bookValidator.validate(book, errors);
		assertFalse(errors.hasErrors());
	}
}
