package com.paradigm.web.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigm.model.Book;
import com.paradigm.service.interfaces.BookService;
import com.paradigm.web.util.BookSearchModel;
import com.sun.jersey.spi.resource.Singleton;

@Service
@Singleton
@Path(value = "/")
public class JerseyWebService {
	private static final Logger logger = Logger.getLogger(JerseyWebService.class);
	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@GET
	@Produces("application/json")
	@Path("/helloworld.htm")
	public String helloWorld() {
		Book book = Book.createRandomBook();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("bookName", book.getBookName());
		jsonObj.put("cool", book.isCool());
		jsonObj.put("price", book.getPrice());
		jsonObj.put("initialTime", book.getInitialTime().toString("yyyy-MM-dd"));
		return jsonObj.toString();
	}

	@GET
	@Produces("text/plain")
	@Path("/getBookNames.htm")
	public String getBookNames(@QueryParam("query") String query) {
		logger.debug("got query: " + query);
		logger.debug("bookService: " + bookService);
		BookSearchModel wsm = new BookSearchModel();
		wsm.setName(query);
		List<Book> books = bookService.search(wsm);

		StrBuilder bldr = new StrBuilder();
		for (Book w : books) {
			bldr.append(w.getBookName() + SystemUtils.LINE_SEPARATOR);
		}
		logger.debug("Returning: " + bldr.toString());
		return bldr.toString();
	}

	/*
	 * @POST
	 * 
	 * @Produces("text/plain") public String doPost(@FormParam("fileName")
	 * String fileName, String fileList) { logger.debug("FileName: " +
	 * fileName); logger.debug("body: " + fileList); return "0"; }
	 */
}
