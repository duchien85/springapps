package com.studerb.tests.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.film.FilmDao;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class FilmDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	FilmDao filmDao;

	@Before
	public void setUp() throws Exception {
		deleteFromTables(filmDao.getTableName());
	}

	@After
	public void tearDown() throws Exception {
		deleteFromTables(filmDao.getTableName());
	}

	public void testGetFilms() {

	}

}
