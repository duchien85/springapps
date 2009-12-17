package com.studerb.widget;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;
import com.studerb.widget.WidgetDao;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class WidgetDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	WidgetDao widgetDao;

	@Before
	public void setUp() throws Exception {
		deleteFromTables(widgetDao.getTableName());
	}

	@After
	public void tearDown() throws Exception {
		deleteFromTables(widgetDao.getTableName());
	}

	@Test
	public void testCreate() {
		Widget widget = Widget.createRandomWidget();
		Assert.assertTrue(widget.getId() == null);
		assertEquals(countRowsInTable(widgetDao.getTableName()), 0);
		widgetDao.save(widget);
		widgetDao.flush();
		widgetDao.clear();

		logger.debug("got id: " + widget.getId());
		int count = widgetDao.getAll().size();
		logger.debug("Got size of: " + count);

		List<Widget> widgets = widgetDao.getAll();
		for (Widget w : widgets) {
			logger.debug(w);
		}

		logger.debug("Getting Count via dao: " + widgetDao.getCount());
		assertTrue(widget.getId() != null);

		int rows = countRowsInTable(widgetDao.getTableName());
		assertEquals(rows, 1);
	}

	@Test
	public void testDelete() {
		Widget widget = Widget.createRandomWidget();
		assertEquals(countRowsInTable("widget"), 0);
		widgetDao.save(widget);
		widgetDao.flush();
		assertTrue(widget.getId() != null);
		assertEquals(countRowsInTable("widget"), 1);
		widgetDao.delete(widget);
		widgetDao.flush();
		assertEquals(countRowsInTable("widget"), 0);
	}

	@Test
	public void testDeleteAll() {
		final int COUNT = 10;
		List<Widget> widgets = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets.add(w);
			Long id = widgetDao.save(w);
			assertNotNull(id);
		}
		widgetDao.flush();
		assertEquals(countRowsInTable("widget"), COUNT);

		widgetDao.deleteAll();
		widgetDao.flush();
		assertEquals(countRowsInTable("widget"), 0);
	}

	@Test
	public void testDeleteById() {
		Widget widget = Widget.createRandomWidget();
		assertEquals(countRowsInTable("widget"), 0);
		widgetDao.save(widget);
		widgetDao.flush();
		assertTrue(widget.getId() != null);
		assertEquals(countRowsInTable("widget"), 1);
		widgetDao.delete(widget.getId());
		widgetDao.flush();
		assertEquals(countRowsInTable("widget"), 0);
	}

	@Test
	public void testGet() {
		Widget w = Widget.createRandomWidget();
		Long id = widgetDao.save(w);
		widgetDao.flush();
		widgetDao.clear();
		Widget fetched = widgetDao.get(id);
		assertEquals(fetched, w);
		assertTrue(fetched != w);
	}

	@Test
	public void testGetAll() {
		final int COUNT = 10;
		List<Widget> widgets = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets.add(w);
			Long id = widgetDao.save(w);
			assertNotNull(id);
		}
		widgetDao.flush();
		assertEquals(countRowsInTable("widget"), COUNT);

		List<Widget> fetchedWidgets = widgetDao.getAll();
		widgetDao.flush();
		assertEquals(fetchedWidgets.size(), COUNT);
	}

	@Test
	public void testGetAllByOrder() {
		Widget widget0 = Widget.createRandomWidget();
		Widget widget1 = Widget.createRandomWidget();
		Widget widget2 = Widget.createRandomWidget();

		widget0.setPrice(new BigDecimal(10.00));
		widgetDao.save(widget0);

		widget1.setPrice(new BigDecimal(25.00));
		widgetDao.save(widget1);

		widget2.setPrice(new BigDecimal(0.75));
		widgetDao.save(widget2);
		widgetDao.flush();

		List<Widget> widgets = widgetDao.getAllByOrder("price", "asc");
		assertEquals(widgets.size(), 3);

		assertEquals(widgets.get(0), widget2);
		assertEquals(widgets.get(1), widget0);
		assertEquals(widgets.get(2), widget1);
	}

	@Test
	public void testGetCountAndSaveUpdateAll() {
		final int COUNT = 10;
		List<Widget> widgets = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			widgets.add(w);
			assertNull(w.getId());
		}
		widgetDao.saveOrUpdateAll(widgets);
		for (Widget w : widgets) {
			assertNotNull(w.getId());
		}
		widgetDao.flush();
		assertEquals(countRowsInTable("widget"), COUNT);
		int count = widgetDao.getCount();
		assertEquals(countRowsInTable("widget"), count);

		widgetDao.deleteAll();
		count = widgetDao.getCount();
		assertEquals(0, count);
	}

	@Test
	public void testGetDatePage() {
		int COUNT = 52;
		List<Widget> widgets = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget w = Widget.createRandomWidget();
			// avoid duplicate names
			w.setWidgetName(w.getWidgetName() + "_" + String.valueOf(i));
			widgets.add(w);
		}
		widgetDao.saveOrUpdateAll(widgets);
		widgetDao.flush();
		widgetDao.clear();

		assertEquals(countRowsInTable("widget"), COUNT);

		// default: size=10, sort=id, desc=false
		DataPageInfo info = new DataPageInfo();
		assertTrue(info.getTotalRecords() == 0);
		assertTrue(info.getPageSize() == 10);
		DataPage<Widget> widgetDp = widgetDao.getPage(info);
		assertEquals(widgetDp.getData().size(), 10);
		assertEquals(info.getTotalRecords(), COUNT);

		Widget first = widgetDp.getData().get(0);
		logger.debug("first: " + first.toString());

		// getting 11-20
		info.next();
		// getting 21-30
		info.next();
		widgetDp = widgetDao.getPage(info);
		assertEquals(widgetDp.getData().size(), 10);

		// getting 31-40
		info.next();
		// getting 41-50
		info.next();
		// getting 51-52
		info.next();
		widgetDp = widgetDao.getPage(info);
		assertEquals(widgetDp.getData().size(), 2);

		// getting 61-70 --> should go back to 51-52
		info.next();
		widgetDp = widgetDao.getPage(info);
		assertEquals(widgetDp.getData().size(), 2);

	}

	@Test
	public void testIsNameUsed() {
		Widget widget1 = Widget.createRandomWidget();
		widgetDao.save(widget1);
		widgetDao.flush();
		widgetDao.clear();
		assertTrue(widgetDao.isNameUsed(widget1.getWidgetName()));
		assertFalse(widgetDao.isNameUsed(RandomStringUtils.randomAlphabetic(20)));
	}

	@Test
	public void testLastUpdate() {
		Widget widget = Widget.createRandomWidget();
		assertNull(widget.getLastUpdate());
		widgetDao.save(widget);
		widgetDao.flush();
		widgetDao.clear();
		widget = widgetDao.get(widget.getId());
		assertNotNull(widget.getLastUpdate());
	}

	@Test(expected = Exception.class)
	public void testNonUniqueName() {
		Widget widget1 = Widget.createRandomWidget();
		Widget widget2 = Widget.createRandomWidget();
		widget2.setWidgetName(widget1.getWidgetName());
		widgetDao.save(widget1);
		widgetDao.save(widget2);
	}

	@Test
	public void testSaveOrUpdate() {
		Widget w = Widget.createRandomWidget();
		assertNull(w.getId());
		widgetDao.saveOrUpdate(w);
		widgetDao.flush();
		widgetDao.clear();
		Long id = w.getId();
		assertNotNull(id);

		BigDecimal newPrice = new BigDecimal("25.50");
		w.setPrice(newPrice);
		widgetDao.saveOrUpdate(w);
		widgetDao.flush();
		widgetDao.clear();

		Widget fetched = widgetDao.get(id);
		assertTrue(fetched.getPrice().equals(newPrice));
	}
}
