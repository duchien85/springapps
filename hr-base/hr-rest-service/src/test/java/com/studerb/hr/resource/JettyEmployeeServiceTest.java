package com.studerb.hr.resource;

import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.apache.commons.httpclient.HttpClient;
import org.junit.Test;

public class JettyEmployeeServiceTest {

    @Test
    public void getText() throws Exception {
        URI uri = new URI("http://localhost:8080/hr-rest-service/rest");
        HttpClient httpClient;
        assertTrue(true);
    }
}
