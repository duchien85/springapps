package com.studerb.hr.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.studerb.hr.model.Employee;
import com.studerb.hr.model.Employees;
import com.studerb.hr.service.EmployeeService;
import com.sun.jersey.spi.resource.Singleton;

@Service
@Singleton
@Path("/employees/")
public class EmployeeResource {
    private static final Logger log = Logger.getLogger(EmployeeResource.class);

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllEmployeesText() {
        log.debug("got request to /employees/");
        log.debug("employeeService: " + employeeService);

        List<Employee> employees = employeeService.getAllEmployees();
        StrBuilder bldr = new StrBuilder();
        for (Employee e : employees) {
            bldr.append(e.toString() + SystemUtils.LINE_SEPARATOR);
        }
        return bldr.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Employees getAllEmployeesXml() {
        Employees employees = new Employees();
        List<Employee> employeeList = employeeService.getAllEmployees();
        employees.getEmployees().addAll(employeeList);
        return employees;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}/")
    public Employee getEmployeeById(@PathParam("id") Long id) {
        log.debug("Getting employee by id: " + id);
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return employee;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void createEmployee(Employee employee) {
        Long newId = employeeService.saveEmployee(employee);
        log.info("Created new employee - Id =  " + newId);
    }

}
