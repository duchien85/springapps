package com.studerb.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	Logger logger = Logger.getLogger(WelcomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public void welcome(ModelMap model) {
		logger.debug("Welcome Controller");
		model.addAttribute("modelMessage", "Hello World!");
	}
}
