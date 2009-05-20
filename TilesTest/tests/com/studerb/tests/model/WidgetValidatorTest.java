package com.studerb.tests.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.BindException;

import com.studerb.model.Widget;
import com.studerb.model.WidgetValidator;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class WidgetValidatorTest {

	private Widget widget;
	private WidgetValidator widgetValidator;
	private BindException errors;

	@Before
	public void setUp() throws Exception {
		widget = Widget.createRandomWidget();
		widgetValidator = new WidgetValidator();
		errors = new BindException(widget, "widget");
		assertFalse(errors.hasErrors());
	}

	@After
	public void tearDown() throws Exception {
		widget = null;
		errors = null;
	}

	@Test
	public void testNullWidgetName() {
		widget.setWidgetName(null);
		widgetValidator.validate(widget, errors);
		assertTrue(errors.hasFieldErrors("widgetName"));
	}

	@Test
	public void testSetWidgetNameTooLong() {
		widget.setWidgetName(RandomStringUtils.random(Widget.MAX_NAME_LENGTH + 5));
		widgetValidator.validate(widget, errors);
		assertTrue(errors.hasFieldErrors("widgetName"));
	}

	@Test
	public void testPriceNull() {
		widget.setPrice(null);
		widgetValidator.validate(widget, errors);
		assertTrue(errors.hasFieldErrors("price"));
	}

	@Test
	public void testPriceNegative() {
		widget.setPrice(new BigDecimal("-23.343"));
		widgetValidator.validate(widget, errors);
		assertTrue(errors.hasFieldErrors("price"));
	}

	@Test
	public void testCoolNull() {
		widget.setCool(null);
		widgetValidator.validate(widget, errors);
		assertTrue(errors.hasFieldErrors("cool"));

	}

	@Test
	public void testInitialTimeNull() {
		widget.setInitialTime(null);
		widgetValidator.validate(widget, errors);
		assertTrue(errors.hasFieldErrors("initialTime"));
	}

	@Test
	public void testGood() {
		widgetValidator.validate(widget, errors);
		assertFalse(errors.hasErrors());
	}
}
