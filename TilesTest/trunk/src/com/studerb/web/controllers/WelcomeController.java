package com.studerb.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public void welcome(ModelMap map) {
		map.addAttribute("message", "Hello World!");
	}

}
