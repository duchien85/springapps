package com.saic.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.saic.model.BatPerson;

@ContextConfiguration( { "classpath:spring/applicationContext.xml" })
public class GeoSearchServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    GeoSearchService geoSearchService;

    @Test
    public void searchEmptyWKT() {
        String multiPoly = "MULTIPOLYGON(((-4.130859375 54.73388671875,0.439453125 54.82177734375,1.142578125 50.38330078125,-4.3505859375 50.51513671875,-4.4384765625 50.64697265625,-4.130859375 54.73388671875)))";
        List<BatPerson> batPersons = this.geoSearchService.searchGuidsByWKT(multiPoly);
        assertTrue("Should not have returned any results", batPersons.isEmpty());
    }

    @Test
    public void searchGoodWkt() {
        String multiPoly = "MULTIPOLYGON(((-117.421875 44.82421875,-104.765625 44.82421875,-104.765625 27.59765625,-117.0703125 28.65234375,-117.421875 44.82421875)))";
        List<BatPerson> batPersons = this.geoSearchService.searchGuidsByWKT(multiPoly);
        assertTrue(batPersons.size() > 100);
    }

    @Test(expected = UncategorizedSQLException.class)
    public void searchWithBadWKT() {
        // missing one of the parentheses
        String multiPoly = "MULTIPOLYGON((-117.421875 44.82421875,-104.765625 44.82421875,-104.765625 27.59765625,-117.0703125 28.65234375,-117.421875 44.82421875)))";
        List<BatPerson> batPersons = this.geoSearchService.searchGuidsByWKT(multiPoly);
        fail("should have thrown exception");
    }

    @Test(expected = UncategorizedSQLException.class)
    public void searchWithNullWKT() {
        List<BatPerson> batPersons = this.geoSearchService.searchGuidsByWKT(null);
        fail("should have thrown exception");
    }

    @Test(expected = UncategorizedSQLException.class)
    public void searchWithBlankWKT() {
        List<BatPerson> batPersons = this.geoSearchService.searchGuidsByWKT("");
        fail("should have thrown exception");
    }

}
