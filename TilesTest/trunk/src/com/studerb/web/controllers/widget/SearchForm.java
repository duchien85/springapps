package com.studerb.web.controllers.widget;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;
import com.studerb.web.util.DateTimeEditor;
import com.studerb.web.util.WidgetSearchModel;

@Controller
@RequestMapping("/widget/search")
public class SearchForm {
	Logger logger = Logger.getLogger(SearchForm.class);

	@Autowired
	WidgetService widgetService;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(DateTime.class, new DateTimeEditor(format, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		WidgetSearchModel widgetSearchModel = new WidgetSearchModel();
		model.addAttribute(widgetSearchModel);
		return "widget/search";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("widgetSearchModel") WidgetSearchModel widgetSearchModel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "widget/search";
		}
		List<Widget> widgets = widgetService.search(widgetSearchModel);
		// flash.set(FLASH_STATUS, "successfully updated new widget");
		model.addAttribute("widgets", widgets);
		logger.debug("returning view: widget/search");
		return "widget/search";
	}

}
