package com.studerb.contact.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studerb.contact.ContactService;


@Controller
@RequestMapping("/contact/*.htm")
public class ContactController {
	private static final Logger logger = Logger.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "confirmation.htm", method = RequestMethod.GET)
	public String confirmation(ModelMap model) {
		return "contact/confirmation";
	}

	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public String defaultRequest(Model model, HttpSession session) {
		logger.debug("contact GET - creating new ContactModel");
		model.addAttribute("contactModel", new ContactModel());
		return "contact/form";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "index.htm", method = RequestMethod.POST)
	public String postContactModel(HttpServletRequest request, @ModelAttribute ContactModel contactModel, BindingResult result, ModelMap model) {
		logger.debug("contact POST: " + contactModel);
		// processAttachments(request, command);

		new ContactValidator().validate(contactModel, result);
		if (result.hasErrors()) {
			logger.debug("Binding/Validation Errors - returning contact form page");
			return "contact/form";
		}
		try {
			contactService.sendContactEmail(contactModel);
		}
		catch (Exception e) {
			e.printStackTrace();
			result.reject(ExceptionUtils.getRootCauseMessage(e));
			return "contact/form";
		}
		// this.info.setCurrentRecord(0);

		model.clear();
		model.addAttribute("flashScope.contactModel", contactModel);
		return "redirect:/contact/confirmation.htm";
	}

}
