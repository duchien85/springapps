package com.studerb.web.controllers.widget;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;

@Controller
@RequestMapping("/widget/search")
public class SearchForm {
	Logger logger = Logger.getLogger(SearchForm.class);

	@Autowired
	WidgetService widgetService;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		return "widget/search";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@RequestParam(value = "widgetName", required = false) String widgetName, Model model) {
		List<Widget> widgets = widgetService.search(widgetName);
		logger.debug("Got lis tof widgets");
		// flash.set(FLASH_STATUS, "successfully updated new widget");
		model.addAttribute("widgets", widgets);
		logger.debug("returning view: widget/search");
		return "widget/search";
	}

}
