package com.paradigm.scripts;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.paradigm.model.Book;
import com.paradigm.service.interfaces.BookService;

public class CreateBooks {
	private static final int COUNT = 500;
	private final static Logger logger = Logger.getLogger(CreateBooks.class);
	static ApplicationContext appContext;
	static BookService bookService;

	public static void main(String[] args) {
		initAppContext();
		bookService.deleteAllObjects();
		createBooks();
	}

	private static void createBooks() {
		List<Book> books = new ArrayList<Book>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Book book = Book.createRandomBook();
			book.setBookName("Book_" + i);
			book.setInitialTime(book.getInitialTime().minusDays(i));
			books.add(book);
		}
		bookService.saveOrUpdateAll(books);
		logger.debug("created: " + COUNT + " new books");

	}

	private static void initAppContext() {
		appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Assert.notNull(appContext);
		bookService = (BookService) appContext.getBean("bookService");
		Assert.notNull(bookService);
	}

}
