package com.studerb.web.controllers.widget;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WidgetController {
	Logger logger = Logger.getLogger(WidgetController.class);

	@RequestMapping("list.htm")
	public String list(ModelMap model) {
		return "widget/list";
	}

}
