package com.studerb.widget;

import org.joda.time.DateTime;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class WidgetSearchModelValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return WidgetSearchModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		WidgetSearchModel wsm = (WidgetSearchModel) obj;
		validateDates(wsm, errors);

	}

	private void validateDates(WidgetSearchModel wsm, Errors errors) {
		DateTime begin = wsm.getBeginInitialTime();
		DateTime end = wsm.getEndInitialTime();

		if (begin != null && end != null) {
			if (begin.isAfter(end)) {
				errors.rejectValue("beginInitialTime", "beginDateAfterEndDate");
			}
		}
	}

}
