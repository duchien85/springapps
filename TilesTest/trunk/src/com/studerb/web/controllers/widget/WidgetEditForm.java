package com.studerb.web.controllers.widget;

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
import com.studerb.service.interfaces.WidgetService;

@Controller
@RequestMapping("/widget/edit")
@SessionAttributes(types = Widget.class)
public class WidgetEditForm {

	@Autowired
	WidgetService widgetService;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Widget widget = Widget.createRandomWidget();
		model.addAttribute(widget);
		return "widget/edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Widget widget, BindingResult result, SessionStatus status) {
		/*
		 * new OwnerValidator().validate(owner, result); if (result.hasErrors())
		 * { return "ownerForm"; } else { this.clinic.storeOwner(owner);
		 * status.setComplete(); return "redirect:owner.do?ownerId=" +
		 * owner.getId(); } }
		 */
		status.setComplete();
		return "redirect:/widget/list.htm";
	}
}
