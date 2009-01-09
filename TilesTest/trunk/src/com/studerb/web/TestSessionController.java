package com.studerb.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.studerb.model.Widget;

@Controller
@SessionAttributes("widget")
public class TestSessionController {
	private static Logger logger = Logger.getLogger(TestSessionController.class);

	@RequestMapping(value = "/test/index", method = RequestMethod.GET)
	public String get() {
		logger.debug("Test GET");
		return "test/index";
	}

	@ModelAttribute("widget")
	public Widget initWidget(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			logger.debug("initiating widget...");
			Widget widget = new Widget();
			return widget;
		}
		return null;
	}

	@RequestMapping(value = "/test/index", method = RequestMethod.POST)
	public String post(@ModelAttribute Widget widget) {
		logger.debug("Test POST");
		return "redirect:/test/confirmation.htm";
	}
}
