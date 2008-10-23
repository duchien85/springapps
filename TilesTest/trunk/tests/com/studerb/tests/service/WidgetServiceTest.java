package com.studerb.tests.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.dao.WidgetDao;
import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;

@ContextConfiguration(locations = { "classpath:/test-context.xml" })
public class WidgetServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static Logger logger = Logger.getLogger(WidgetServiceTest.class);

	@Autowired
	WidgetService widgetService;
	@Autowired
	WidgetDao widgetDao;

	@Before
	public void setUp() throws Exception {
		deleteFromTables("widget");
	}

	@After
	public void tearDown() throws Exception {
		deleteFromTables("widget");
	}

	@Test
	public void testDelete() throws Exception {
		Widget w = Widget.createRandomWidget();
		widgetService.save(w);
		assertTrue(w.getId() != null);
	}

	@Test
	public void testDeleteAllByList() {
		int COUNT = 10;
		List<Widget> widgets1 = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets1.add(w);
		}
		List<Widget> widgets2 = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets2.add(w);
		}

		widgetDao.saveOrUpdateAll(widgets1);
		widgetDao.saveOrUpdateAll(widgets2);
		widgetDao.flush();
		widgetDao.clear();

		assertEquals(COUNT * 2, countRowsInTable("widget"));

		int deleted = widgetService.deleteAll(widgets1);
		assertEquals(deleted, COUNT);
		widgetDao.flush();
		widgetDao.clear();
		assertEquals(COUNT, countRowsInTable("widget"));

		List<Widget> dummy = new ArrayList<Widget>();
		deleted = widgetService.deleteAll(dummy);
		assertEquals(deleted, 0);
		widgetDao.flush();
		widgetDao.clear();
		assertEquals(COUNT, countRowsInTable("widget"));

		deleted = widgetService.deleteAll(widgets2);
		assertEquals(deleted, 10);
		widgetDao.flush();
		widgetDao.clear();
		assertEquals(0, countRowsInTable("widget"));
	}

	@Test
	public void deleteAllRows() {
		int COUNT = 10;
		List<Widget> widgets1 = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets1.add(w);
		}
		List<Widget> widgets2 = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets2.add(w);
		}

		widgetDao.saveOrUpdateAll(widgets1);
		widgetDao.saveOrUpdateAll(widgets2);
		widgetDao.save(Widget.createRandomWidget());
		widgetDao.flush();
		widgetDao.clear();

		int deleted = widgetService.deleteAllObjects();
		assertEquals(deleted, (COUNT * 2) + 1);
		widgetDao.flush();
		widgetDao.clear();
		assertEquals(0, countRowsInTable("widget"));
	}

	@Test
	public void testGet() {
		Widget w = Widget.createRandomWidget();
		try {
			widgetService.save(w);
		}
		catch (Exception e) {}
		assertEquals(countRowsInTable("widget"), 1);
	}

	@Test
	public void testGetAll() {
		int COUNT = 10;
		List<Widget> widgets = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets.add(w);
		}
		widgetDao.saveOrUpdateAll(widgets);
		widgetDao.flush();
		widgetDao.clear();
		List<Widget> fetched = widgetService.getAll();
		assertEquals(fetched.size(), COUNT);
	}

	@Test
	public void testUpdate() {
		Widget w = Widget.createRandomWidget();
		widgetDao.save(w);
		widgetDao.flush();
		widgetDao.clear();
		Boolean opposite = w.isCool() ? false : true;
		w.setCool(opposite);
		widgetService.update(w);
		widgetDao.flush();
		widgetDao.clear();
		Widget fetched = widgetDao.get(w.getId());
		assertEquals(fetched.isCool(), opposite);
	}

	@Test(expected = Exception.class)
	public void testDuplicateName() throws Exception {
		Widget w = Widget.createRandomWidget();
		widgetDao.save(w);
		widgetDao.flush();
		widgetDao.clear();

		Widget w2 = Widget.createRandomWidget();
		w2.setWidgetName(w.getWidgetName());
		widgetService.save(w2);
	}

}
