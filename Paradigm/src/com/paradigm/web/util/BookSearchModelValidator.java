package com.paradigm.web.util;

import org.joda.time.DateTime;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookSearchModelValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return BookSearchModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		BookSearchModel wsm = (BookSearchModel) obj;
		validateDates(wsm, errors);

	}

	private void validateDates(BookSearchModel wsm, Errors errors) {
		DateTime begin = wsm.getBeginInitialTime();
		DateTime end = wsm.getEndInitialTime();

		if (begin != null && end != null) {
			if (begin.isAfter(end)) {
				errors.rejectValue("beginInitialTime", "beginDateAfterEndDate");
			}
		}
	}

}
