package com.paradigm.web.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paradigm.model.Book;
import com.paradigm.service.interfaces.BookService;
import com.paradigm.web.util.DataPage;
import com.paradigm.web.util.DataPageInfo;

@Controller
@RequestMapping("/book/*.htm")
public class BookController {

	@Autowired
	@Qualifier("bookListInfo")
	private DataPageInfo datePageInfo;

	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model) {
		DataPage<Book> books = bookService.getDatePage(datePageInfo);
		model.addAttribute("books", books);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String delete(@RequestParam("bookId") Long bookId, Model model) {
		bookService.delete(bookId);
		model.addAttribute("flashScope.message", "Deleted book successfully");
		return "redirect:/book/list.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String changePage(@RequestParam String viewName, @RequestParam String changeEvent) {
		this.datePageInfo.changePage(changeEvent);
		return "redirect:/book/list.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String sort(@RequestParam String viewName, @RequestParam String column) {
		this.datePageInfo.changeSort(column);
		return "redirect:/book/list.htm";
	}

}
