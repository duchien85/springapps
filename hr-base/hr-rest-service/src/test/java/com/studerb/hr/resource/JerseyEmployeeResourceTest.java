package com.studerb.hr.resource;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;

import com.studerb.hr.model.Employee;
import com.studerb.hr.model.Employees;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.MediaTypes;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

//@ContextConfiguration(locations = { "classpath:test-context.xml" })
//@TransactionConfiguration(defaultRollback = false)
public class JerseyEmployeeResourceTest extends JerseyTest {
    final static Logger log = Logger.getLogger(JerseyEmployeeResourceTest.class);

    public JerseyEmployeeResourceTest() throws Exception {
        super(new WebAppDescriptor.Builder("com.studerb.hr.resource").contextPath("rest").contextParam(
                "contextConfigLocation", "classpath:test-context.xml").servletClass(SpringServlet.class)
                .contextListenerClass(ContextLoaderListener.class).build());
    }

    @Test
    public void doTestApplicationWadl() {
        WebResource webResource = this.resource();
        String wadl = webResource.path("application.wadl").accept(MediaTypes.WADL).get(String.class);
        log.debug("*******************\n" + wadl + " ***********************\n");
        assertTrue("Method: doTestApplicationWadl \nMessage: Something wrong, the returned "
                + "WADL's length is not > 0", wadl.length() > 0);
    }

    @Test
    public void getEmployeesText() {
        WebResource webResource = this.resource();
        String employeeLines = webResource.path("employees").accept("text/plain").get(String.class);
        List<String> lines = Arrays.asList(employeeLines);
        System.err.println(employeeLines);
    }

    @Test
    public void getEmployeesXml() {
        WebResource webResource = this.resource();
        Employees employees = webResource.path("employees").accept("application/xml").get(Employees.class);
        List<Employee> employeeList = employees.getEmployees();
        for (Employee e : employees.getEmployees()) {
            System.out.println(e);
        }
    }
}
