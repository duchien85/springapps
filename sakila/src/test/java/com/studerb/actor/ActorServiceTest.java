package com.studerb.actor;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class ActorServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ActorService actorService;

    private final String path = SystemUtils.USER_DIR + SystemUtils.FILE_SEPARATOR + "db" + SystemUtils.FILE_SEPARATOR;
    String resource = "classpath:" + path + "test-actorData.sql";

    @Before
    public void setUp() throws Exception {
        executeSqlScript("classpath:db/test-actorData.sql", false);
    }

    @After
    public void tearDown() throws Exception {
    // no op
    }

    @Test
    public void testGetAll() {
        List<Actor> actors = actorService.getAll();
        assertTrue(actors.size() == 5);
    }
}
