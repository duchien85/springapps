package com.studerb.web.controllers.widget;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;

@Controller
@RequestMapping("/widget/*")
public class WidgetController {

	@Autowired
	WidgetService widgetService;

	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model) {
		List<Widget> widgets = widgetService.getAll();
		model.addAttribute("widgets", widgets);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String delete(@RequestParam("widgetId") Long widgetId, Model model) {
		widgetService.delete(widgetId);
		model.addAttribute("message", "Deleted widget successfully");
		return "redirect:/widget/list.htm";
	}

}
