package com.paradigm.web.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.paradigm.model.Book;
import com.paradigm.model.validator.BookValidator;
import com.paradigm.service.interfaces.BookService;

@Controller
@RequestMapping("/book/edit")
@SessionAttributes("book")
public class EditForm {

	@Autowired
	BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam("bookId") Long bookId, Model model) {
		Book book = bookService.get(bookId);
		model.addAttribute(book);
		return "book/edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Book book, BindingResult result, SessionStatus status, Model model) {
		new BookValidator().validate(book, result);
		if (result.hasErrors()) {
			return "book/edit";
		}
		bookService.update(book);
		status.setComplete();
		model.addAttribute("flashScope.message", "Successfully updated the book");
		return "redirect:/book/list.htm";
	}
}
