//package com.studerb.film;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//@ContextConfiguration(locations = { "classpath:test-context.xml" })
//public class FilmDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
//
//    @Autowired
//    FilmDao filmDao;
//
//    @Before
//    public void setUp() throws Exception {
//        deleteFromTables("film_actor");
//        deleteFromTables(filmDao.getTableName());
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        deleteFromTables("film_actor");
//        deleteFromTables(filmDao.getTableName());
//    }
//
//    @Test
//    public void testGetFilms() {
//        Assert.assertTrue(true);
//    }
//
// }
