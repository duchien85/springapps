package com.studerb.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contact/*")
public class ContactController {
	private Logger logger = Logger.getLogger(ContactController.class);

	@RequestMapping(method = RequestMethod.GET)
	public void defaultGet() {

	}

	@RequestMapping(method = RequestMethod.POST)
	public void postForm() {

	}
}
