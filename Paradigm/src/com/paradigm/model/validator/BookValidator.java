package com.paradigm.model.validator;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.paradigm.model.Book;

public class BookValidator implements Validator {
	private final static Logger logger = Logger.getLogger(BookValidator.class);

	@Override
	public boolean supports(Class clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Book book = (Book) object;

		String bookName = book.getBookName();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "required");
		if (errors.hasFieldErrors("bookName")) {
			logger.debug("BookName is null/empty");
		}

		if (bookName != null && bookName.length() > Book.MAX_NAME_LENGTH) {
			logger.debug("BookName: " + bookName + " is too long");
			errors.rejectValue("bookName", "tooLong");
		}

		if (book.getPrice() == null) {
			logger.debug("Book Price: " + book.getPrice() + " is required");
			errors.rejectValue("price", "required");
		}
		else if (book.getPrice().compareTo(new BigDecimal("0")) < 0) {
			logger.debug("Book Price: " + book.getPrice() + " is invalid");
			errors.rejectValue("price", "negative");
		}

		if (book.isCool() == null) {
			logger.debug("book.cool is null");
			errors.rejectValue("cool", "required");
		}

		if (!errors.hasFieldErrors("initialTime") && book.getInitialTime() == null) {
			logger.debug("book initialTime is null");
			errors.rejectValue("initialTime", "required");
		}
	}
}
