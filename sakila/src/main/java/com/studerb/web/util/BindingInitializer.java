package com.studerb.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * Shared WebBindingInitializer for custom editors.
 * 
 * <p>
 * Alternatively, such init-binder code may be put into
 * {@link org.springframework.web.bind.annotation.InitBinder} annotated methods
 * on the controller classes themselves.
 */
public class BindingInitializer implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false, 10));
		binder.registerCustomEditor(DateTime.class, new DateTimeEditor(format, false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

}
