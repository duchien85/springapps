package com.studerb.widget;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class WidgetValidator implements Validator {
	private final static Logger logger = Logger.getLogger(WidgetValidator.class);

	@Override
	public boolean supports(Class clazz) {
		return Widget.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Widget widget = (Widget) object;

		String widgetName = widget.getWidgetName();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "widgetName", "required");
		if (errors.hasFieldErrors("widgetName")) {
			logger.debug("WidgetName is null/empty");
		}

		if (widgetName != null && widgetName.length() > Widget.MAX_NAME_LENGTH) {
			logger.debug("WidgetName: " + widgetName + " is too long");
			errors.rejectValue("widgetName", "tooLong");
		}

		if (widget.getPrice() == null) {
			logger.debug("Widget Price: " + widget.getPrice() + " is required");
			errors.rejectValue("price", "required");
		}
		else if (widget.getPrice().compareTo(new BigDecimal("0")) < 0) {
			logger.debug("Widget Price: " + widget.getPrice() + " is invalid");
			errors.rejectValue("price", "negative");
		}

		if (widget.isCool() == null) {
			logger.debug("widget.cool is null");
			errors.rejectValue("cool", "required");
		}

		if (!errors.hasFieldErrors("initialTime") && widget.getInitialTime() == null) {
			logger.debug("widget initialTime is null");
			errors.rejectValue("initialTime", "required");
		}
	}
}
