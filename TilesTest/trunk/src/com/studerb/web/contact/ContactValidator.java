package com.studerb.web.contact;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContactValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return ContactValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContactModel contactModel = (ContactModel) target;

		ValidationUtils.rejectIfEmpty(errors, "recipientEmail", "required");
		ValidationUtils.rejectIfEmpty(errors, "subject", "required");
		ValidationUtils.rejectIfEmpty(errors, "message", "required");

		if (!errors.hasFieldErrors("message")) {
			String message = contactModel.getMessage();
			if (message.length() > ContactModel.MESSAGE_MAX_LENGTH) {
				errors.rejectValue("message", "length", new Object[] { new Integer(ContactModel.MESSAGE_MAX_LENGTH) }, "message too long");
			}

		}

	}

}
