package com.studerb.tests.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.dao.ActorDao;
import com.studerb.model.Actor;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class ActorDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	ActorDao actorDao;

	@Autowired
	SessionFactory sessionFactory;

	private final String path = SystemUtils.USER_DIR + SystemUtils.FILE_SEPARATOR + "db" + SystemUtils.FILE_SEPARATOR;
	String resource = "file:" + path + "test-actorData.sql";

	@Before
	public void setUp() throws Exception {
		executeSqlScript("file:db\\test-actorData.sql", false);
	}

	@Test
	public void AddActor() {
		Actor actor = new Actor("Mitch", "SomeLastName");
		int initialCount = countRowsInTable(actorDao.getTableName());
		actorDao.save(actor);
		actorDao.flush();
		actorDao.clear();

		assertNotNull(actor.getId());
		assertEquals(initialCount + 1, countRowsInTable(actorDao.getTableName()));
	}

	// @Test
	@ExpectedException(Throwable.class)
	public void addDoubleFilm() {
		fail("not implmented");
	}

	@Test
	public void testGetAllActors() {
		List<Actor> actors = actorDao.getAll();
		assertEquals(actors.size(), 5);
	}

	@Test
	@NotTransactional
	public void testSessionFactory() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		if (session.isOpen()) {
			logger.debug("Session still open...");
			session.close();
		}
		else {
			logger.debug("Session already closed");
		}
	}

	@Test
	public void testSingleActors() {
		for (int i = 1; i <= 5; ++i) {
			Actor a = actorDao.get(new Long(i));
			assertNotNull(a);
		}

		Actor one = actorDao.get(new Long(1));
		assertEquals(one.getFilms().size(), 10);

		Actor two = actorDao.get(new Long(2));
		assertEquals(two.getFilms().size(), 0);

		Actor three = actorDao.get(new Long(3));
		assertEquals(three.getFilms().size(), 1);
	}

}
