package com.paradigm.web.controllers.book;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.paradigm.model.Book;
import com.paradigm.service.interfaces.BookService;
import com.paradigm.web.util.DataPage;
import com.paradigm.web.util.DataPageInfo;
import com.paradigm.web.util.DateTimeEditor;
import com.paradigm.web.util.BookSearchModel;
import com.paradigm.web.util.BookSearchModelValidator;

@Controller
@RequestMapping("/book/search/*.htm")
@SessionAttributes("bookSearchModel")
public class SearchForm {
	Logger logger = Logger.getLogger(SearchForm.class);

	@Autowired
	BookService bookService;

	@Autowired
	@Qualifier("bookSearchInfo")
	private DataPageInfo datePageInfo;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(DateTime.class, new DateTimeEditor(format, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String defaultGet(Model model) {
		logger.debug("search GET - creating new BookSearchModel");
		model.addAttribute("bookSearchModel", new BookSearchModel());
		return "book/search";
	}

	@RequestMapping(value = "doSearch", method = RequestMethod.POST)
	public String postSearchModel(@ModelAttribute("bookSearchModel") BookSearchModel bookSearchModel, BindingResult result, Model model) {
		new BookSearchModelValidator().validate(bookSearchModel, result);
		if (result.hasErrors()) {
			logger.debug("Binding/Validation Errors - returning search page");
			return "book/search";
		}
		// add one day to endTime
		if (bookSearchModel.getEndInitialTime() != null) {
			bookSearchModel.setEndInitialTime(bookSearchModel.getEndInitialTime().plusDays(1));
		}
		this.datePageInfo.setCurrentRecord(0);
		return "redirect:/book/search/list.htm";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, HttpSession httpSession) {
		BookSearchModel bookSearchModel = (BookSearchModel) httpSession.getAttribute("bookSearchModel");
		if (bookSearchModel == null) {
			throw new IllegalStateException("BookSearchModel not found within HttpSession");
		}
		logger.debug("BookSearchModel (from session): " + bookSearchModel.toString());

		DataPage<Book> bookDP = bookService.searchDataPage(bookSearchModel, this.datePageInfo);
		if (bookDP.getData().isEmpty()) {
			model.addAttribute("searchResultsMessage", "No results were found matching your criteria");
		}

		logger.debug("Found: " + bookDP.getData().size() + " EPIs to display...");
		model.addAttribute("books", bookDP);
		model.addAttribute("bookSearchModel", bookSearchModel);
		if (bookDP.getData().isEmpty()) {
			model.addAttribute("searchResultsMessage", "There were no book's found using your criteria");
		}
		return "book/search";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bookId") Long bookId, Model model) {
		bookService.delete(bookId);
		model.addAttribute("flashScope.message", "Deleted book successfully");
		return "redirect:/book/search/list.htm";
	}

	@RequestMapping(value = "changePage", method = RequestMethod.GET)
	public String changePage(@RequestParam String viewName, @RequestParam String changeEvent) {
		this.datePageInfo.changePage(changeEvent);
		return "redirect:/book/search/list.htm";
	}

	@RequestMapping(value = "sort", method = RequestMethod.GET)
	public String sort(@RequestParam String viewName, @RequestParam String column) {
		this.datePageInfo.changeSort(column);
		return "redirect:/book/search/list.htm";
	}
}
