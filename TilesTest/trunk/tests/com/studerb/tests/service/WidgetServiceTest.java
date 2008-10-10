package com.studerb.tests.service;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.service.interfaces.WidgetService;

@ContextConfiguration(locations = { "classpath:/test-context.xml" })
public class WidgetServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static Logger logger = Logger.getLogger(WidgetServiceTest.class);
	@Autowired
	WidgetService widgetService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("AfterClass");
	}

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

}
