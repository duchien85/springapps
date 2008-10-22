package com.studerb.web.controllers.widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;

@Controller
@RequestMapping("/widget/add")
@SessionAttributes(types = Widget.class)
public class AddForm {

	@Autowired
	WidgetService widgetService;

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap model) {
		model.addAttribute(new Widget());
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
