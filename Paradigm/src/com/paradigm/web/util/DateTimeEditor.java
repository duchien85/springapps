package com.paradigm.web.util;

import java.beans.PropertyEditorSupport;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

public class DateTimeEditor extends PropertyEditorSupport {
	private final Logger logger = Logger.getLogger(DateTimeEditor.class);
	private final String dateFormat;
	private final boolean allowEmpty;

	/**
	 * Create a new DateTimeEditor instance, using the given format for parsing
	 * and rendering. <p/> The "allowEmpty" parameter states if an empty String
	 * should be allowed for parsing, i.e. get interpreted as null value.
	 * Otherwise, an IllegalArgumentException gets thrown.
	 * 
	 * @param dateFormat
	 *            DateFormat to use for parsing and rendering
	 * @param allowEmpty
	 *            if empty strings should be allowed
	 */
	public DateTimeEditor(String dateFormat, boolean allowEmpty) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
	}

	// ------------------------ OVERRIDING METHODS ------------------------

	@Override
	public String getAsText() {
		if (getValue() == null) {
			return ""; // return null if the property is null
		}
		DateTime value = (DateTime) getValue();
		DateTimeFormatter fmt = DateTimeFormat.forPattern(dateFormat);
		logger.debug("converting with format (" + this.dateFormat + ") : " + fmt.print(value));
		return fmt.print(value);
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtils.hasText(text)) {
			if (!allowEmpty) {
				throw new IllegalArgumentException("Cannot format empty DateTime");
			}
			else {
				logger.debug("Allowing empty (true) - setting to null");
				setValue(null);
			}
		}

		else {
			logger.debug("Creating new DateTime with format (" + this.dateFormat + ") from text: " + text);
			DateTime val = DateTimeFormat.forPattern(dateFormat).parseDateTime(text);
			setValue(val);
		}
	}
}
