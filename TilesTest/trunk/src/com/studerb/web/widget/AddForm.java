package com.studerb.web.widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.studerb.model.Widget;
import com.studerb.model.WidgetValidator;
import com.studerb.service.interfaces.WidgetService;

@Controller
@RequestMapping("/widget/add")
@SessionAttributes("widget")
public class AddForm {

	@Autowired
	WidgetService widgetService;

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Widget widget, BindingResult result, SessionStatus status, Model model) {
		new WidgetValidator().validate(widget, result);
		if (result.hasErrors()) {
			return "widget/add";
		}
		else if (widgetService.isNameUsed(widget.getWidgetName())) {
			result.rejectValue("widgetName", "duplicate");
			return "widget/add";
		}
		widgetService.save(widget);
		status.setComplete();
		model.addAttribute("flashScope.message", "Successfully added widget: " + widget.getWidgetName());
		return "redirect:/widget/list.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public Widget setupForm() {
		return new Widget();
	}
}