package com.studerb.model;

import java.math.BigDecimal;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class WidgetValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Widget.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Widget widget = (Widget) object;

		String widgetName = widget.getWidgetName();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "widgetName", "required");
		if (widgetName != null && widgetName.length() > Widget.MAX_NAME_LENGTH) {
			errors.rejectValue("widgetName", "tooLong");
		}

		if (widget.getPrice() == null || widget.getPrice().compareTo(new BigDecimal("0")) < 0) {
			errors.rejectValue("price", "invalid");
		}

		if (widget.isCool() == null) {
			errors.rejectValue("cool", "required");
		}

		if (widget.getInitialTime() == null) {
			errors.rejectValue("initialTime", "required");
		}
	}
}
