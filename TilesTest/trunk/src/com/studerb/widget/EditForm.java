package com.studerb.widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.studerb.model.Widget;
import com.studerb.model.WidgetValidator;

@Controller
@RequestMapping("/widget/edit")
@SessionAttributes("widget")
public class EditForm {

	@Autowired
	WidgetService widgetService;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam("widgetId") Long widgetId, Model model) {
		Widget widget = widgetService.get(widgetId);
		model.addAttribute(widget);
		return "widget/edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Widget widget, BindingResult result, SessionStatus status, Model model) {
		new WidgetValidator().validate(widget, result);
		if (result.hasErrors()) {
			return "widget/edit";
		}
		widgetService.update(widget);
		status.setComplete();
		model.addAttribute("flashScope.message", "Successfully updated the widget");
		return "redirect:/widget/list.htm";
	}
}
