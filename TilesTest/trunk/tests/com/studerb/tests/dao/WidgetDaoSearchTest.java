package com.studerb.tests.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.model.Widget;
import com.studerb.widget.WidgetDao;
import com.studerb.widget.web.WidgetSearchModel;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class WidgetDaoSearchTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	WidgetDao widgetDao;

	WidgetSearchModel wsm;

	@Before
	public void setUp() throws Exception {
		deleteFromTables("widget");
		wsm = new WidgetSearchModel();
	}

	@After
	public void tearDown() throws Exception {
		deleteFromTables("widget");
		wsm = null;
	}

	@Test
	public void testSearchByCool() {
		Widget widget1 = Widget.createRandomWidget();
		widget1.setCool(Boolean.TRUE);
		Widget widget2 = Widget.createRandomWidget();
		widget2.setCool(Boolean.FALSE);
		widgetDao.save(widget1);
		widgetDao.save(widget2);
		widgetDao.flush();
		widgetDao.clear();

		List<Widget> widgets = widgetDao.search(wsm);
		assertEquals(widgets.size(), 2);
		widgetDao.clear();

		wsm.setCool(Boolean.TRUE);
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 1);

		wsm.setCool(Boolean.FALSE);
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 1);
	}

	@Test
	public void testSearchByPrice() {
		Widget widget1 = Widget.createRandomWidget();
		widget1.setPrice(new BigDecimal("1.00"));
		Widget widget2 = Widget.createRandomWidget();
		widget2.setPrice(new BigDecimal("10.00"));
		Widget widget3 = Widget.createRandomWidget();
		widget3.setPrice(new BigDecimal("100.00"));
		Widget widget4 = Widget.createRandomWidget();
		widget4.setPrice(new BigDecimal("1000.00"));
		widgetDao.save(widget1);
		widgetDao.save(widget2);
		widgetDao.save(widget3);
		widgetDao.save(widget4);
		widgetDao.flush();
		widgetDao.clear();

		List<Widget> widgets = widgetDao.search(wsm);
		assertEquals(widgets.size(), 4);
		widgetDao.clear();

		wsm.setBeginPrice(new BigDecimal("10000.00"));
		wsm.setEndPrice(null);
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 0);

		wsm.setBeginPrice(null);
		wsm.setEndPrice(new BigDecimal("0.50"));
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 0);

		wsm.setBeginPrice(new BigDecimal("50.00"));
		wsm.setEndPrice(new BigDecimal("999.00"));
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 1);

		wsm.setBeginPrice(new BigDecimal("00.99"));
		wsm.setEndPrice(new BigDecimal("1.01"));
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 1);

		wsm.setBeginPrice(new BigDecimal("00.50"));
		wsm.setEndPrice(new BigDecimal("100.00"));
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 2);

		wsm.setBeginPrice(new BigDecimal("00.01"));
		wsm.setEndPrice(new BigDecimal("1000000.00"));
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 4);

		wsm.setBeginPrice(new BigDecimal("01.00"));
		wsm.setEndPrice(new BigDecimal("1000.01"));
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 3);
	}

	@Test
	public void testSearchName() {
		Widget widget1 = Widget.createRandomWidget();
		Widget widget2 = Widget.createRandomWidget();
		widgetDao.save(widget1);
		widgetDao.save(widget2);
		widgetDao.flush();
		widgetDao.clear();

		List<Widget> widgets = widgetDao.search(wsm);
		assertEquals(widgets.size(), 2);
		widgetDao.clear();

		wsm.setName("abcd");
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 0);

		wsm.setName(widget1.getWidgetName());
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 1);

		wsm.setName(widget2.getWidgetName());
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 1);
	}

	@Test
	public void testSearchNameAnywhereICase() {
		Widget widget1 = Widget.createRandomWidget();
		widget1.setWidgetName("aaabbbccc");
		Widget widget2 = Widget.createRandomWidget();
		widget2.setWidgetName("bbb");
		Widget widget3 = Widget.createRandomWidget();
		widget3.setWidgetName("AAABBBCCCD");
		Widget widget4 = Widget.createRandomWidget();
		widget4.setWidgetName("CD");

		widgetDao.save(widget1);
		widgetDao.save(widget2);
		widgetDao.save(widget3);
		widgetDao.save(widget4);
		widgetDao.flush();
		widgetDao.clear();

		wsm.setName("bbb");
		List<Widget> widgets = widgetDao.search(wsm);
		assertEquals(widgets.size(), 3);
		widgetDao.clear();

		wsm.setName("aaa");
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 2);

		wsm.setName("Z");
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 0);

		wsm.setName("C");
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 3);

		wsm.setName("");
		widgets = widgetDao.search(wsm);
		widgetDao.clear();
		assertEquals(widgets.size(), 4);
	}
}
