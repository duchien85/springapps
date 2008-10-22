package com.studerb.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class WidgetValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Widget.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Widget widget = (Widget) object;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "widgetName", "required");

	}

}
