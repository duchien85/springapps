package com.studerb.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	Logger logger = Logger.getLogger(WelcomeController.class);

	@RequestMapping("/welcome.htm")
	public String welcome(ModelMap map) {
		logger.debug("Welcome...");
		map.addAttribute("modelMessage", "Hello World!");
		return "welcome";
	}
}
