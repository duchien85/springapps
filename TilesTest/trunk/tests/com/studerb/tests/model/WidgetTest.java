package com.studerb.tests.model;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.studerb.model.Widget;

public class WidgetTest {

	private Widget widget = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		widget = Widget.createRandomWidget();
	}

	@After
	public void tearDown() throws Exception {
		widget = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNameTooLong() {
		widget.setWidgetName(RandomStringUtils.random(51));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPriceBadPrice() {
		widget.setPrice(new BigDecimal("-23.343"));
	}
}
