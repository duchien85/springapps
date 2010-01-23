package com.studerb.hr.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.studerb.hr.model.Employee;
import com.studerb.hr.model.Employees;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

@Service("jerseyEmployeeRestService")
public class JerseyEmployeeRestService implements EmployeeRestService, ServletContextAware {
    final static Logger log = Logger.getLogger(JerseyEmployeeRestService.class);
    String HR_REST_URI;
    Client client;
    ServletContext servletContext;

    @PostConstruct
    protected void init() {
        client = Client.create();
        client.addFilter(new LoggingFilter(System.err));
        client.addFilter(new GZIPContentEncodingFilter());
        HR_REST_URI = servletContext.getInitParameter("hrRestServiceUrl");
        if (StringUtils.isBlank(HR_REST_URI)) {
            throw new RuntimeException("Cannot get URI of HR Rest Service");
        }
        log.debug("HR-Rest-URL: " + HR_REST_URI);
    }

    @Override
    public List<Employee> getAllEmployees() {
        WebResource webResource = client.resource(HR_REST_URI);
        ClientResponse clientResponse = webResource.path("employees").accept(MediaType.APPLICATION_XML).get(
                ClientResponse.class);
        if (!clientResponse.getClientResponseStatus().equals(ClientResponse.Status.OK)) {
            throw new RuntimeException("Unable to get all employees XML");
        }
        Employees employeesType = clientResponse.getEntity(Employees.class);
        List<Employee> fromRest = employeesType.getEmployees();
        return fromRest;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public Document getAllEmployeesXml() {
        WebResource webResource = client.resource(HR_REST_URI);
        ClientResponse clientResponse = webResource.path("employees").accept(MediaType.APPLICATION_XML).get(
                ClientResponse.class);
        if (!clientResponse.getClientResponseStatus().equals(ClientResponse.Status.OK)) {
            throw new RuntimeException("Unable to get all employees XML");
        }
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(clientResponse.getEntityInputStream());
            return document;
        }
        catch (DocumentException e) {
            throw new RuntimeException("Error getting Employees XML", e);
        }
    }
}
