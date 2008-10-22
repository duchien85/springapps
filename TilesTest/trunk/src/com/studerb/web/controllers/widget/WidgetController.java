package com.studerb.web.controllers.widget;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WidgetController {
	Logger logger = Logger.getLogger(WidgetController.class);

	@RequestMapping(value = "/widget/list", method = RequestMethod.GET)
	public void list(ModelMap model) {
		model.addAttribute("message", "Your in List");
	}

	@RequestMapping(value = "/widget/delete", method = RequestMethod.GET)
	public void delete(ModelMap model) {
		model.addAttribute("message", "Your in Delete");
	}

}
