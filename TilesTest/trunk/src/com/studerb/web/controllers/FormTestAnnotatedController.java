package com.studerb.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formTest.htm")
public class FormTestAnnotatedController {

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(/*
								 * @ModelAttribute("pet") Pet pet, BindingResult
								 * result, SessionStatus status
								 */) {
		/*
		 * new PetValidator().validate(pet, result); if (result.hasErrors()) {
		 * return "petForm"; } else { this.clinic.storePet(pet);
		 * status.setComplete(); return "redirect:owner.do?ownerId=" +
		 * pet.getOwner().getId(); }
		 */
		return "redirect:/welcome.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap model) {
		System.out.println("Got input param: ");
		return "formTest";
	}

}
