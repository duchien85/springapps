package com.studerb.tests.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.dao.ActorDao;
import com.studerb.model.Actor;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class ActorDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	ActorDao actorDao;

	private final String path = SystemUtils.USER_DIR + SystemUtils.FILE_SEPARATOR + "db" + SystemUtils.FILE_SEPARATOR;
	String resource = "file:" + path + "test-actorData.sql";

	@Before
	public void setUp() throws Exception {
		executeSqlScript("file:db\\test-actorData.sql", false);
	}

	@After
	public void tearDown() throws Exception {
	// no op
	}

	@Test
	public void testGetActors() {
		List<Actor> actors = actorDao.getAll();
		assertEquals(actors.size(), 20);
	}

}
