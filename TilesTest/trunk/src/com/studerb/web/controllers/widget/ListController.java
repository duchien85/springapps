package com.studerb.web.controllers.widget;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
	Logger logger = Logger.getLogger(ListController.class);

	@RequestMapping("/widgets/list.htm")
	public String setupForm(ModelMap model) {
		logger.debug("Got input param: ");
		return "widget/list";
	}

}
