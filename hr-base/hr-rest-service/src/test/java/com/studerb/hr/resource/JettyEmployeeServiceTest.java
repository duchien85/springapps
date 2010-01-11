package com.studerb.hr.resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JettyEmployeeServiceTest {
    final static Logger log = Logger.getLogger(JettyEmployeeServiceTest.class);

    @Test
    public void getText() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/hr-rest-service/rest");
        String employeeLines = webResource.path("employees").accept("text/plain").get(String.class);
        System.err.println(employeeLines);
    }

}
