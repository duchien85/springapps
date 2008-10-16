package com.studerb.tests.dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.dao.WidgetDao;
import com.studerb.model.Widget;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class WidgetDaoTest {

	protected static Logger logger = Logger.getLogger(WidgetDaoTest.class);
	@Autowired
	WidgetDao widgetDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("AfterClass");
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	@Transactional
	public void testCreate() {
		Widget widget = Widget.createRandomWidget();
		Assert.assertTrue(widget.getId() == null);
		widgetDao.create(widget);
		Assert.assertTrue(widget.getId() != null);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/*
	 * @Test public void testDeleteAll() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testDeleteAllBefore() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetAll() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetAllByOrder() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetCount() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testRead() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSaveOrUpdate() { fail("Not yet implemented"); }
	 */
	private static final class WidgetRowMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int row) throws SQLException {
			Widget widget = new Widget();
			widget.setId(rs.getLong("id"));
			widget.setWidgetName(rs.getString("name"));
			widget.setCool(rs.getBoolean("cool"));
			widget.setPrice(new BigDecimal(rs.getDouble("price")));
			widget.setInitialTime((DateTime) rs.getObject("time"));
			return widget;
		}
	}
}
