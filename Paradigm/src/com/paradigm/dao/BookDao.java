package com.paradigm.dao;

import java.util.List;

import com.paradigm.model.Book;
import com.paradigm.web.util.DataPage;
import com.paradigm.web.util.DataPageInfo;
import com.paradigm.web.util.BookSearchModel;

public interface BookDao extends DaoInterface<Book> {
	public Boolean isNameUsed(String name);

	public List<Book> search(BookSearchModel bookSearchModel);

	public DataPage<Book> searchDataPage(BookSearchModel bookSM, DataPageInfo dpi);

}
