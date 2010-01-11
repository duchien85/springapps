package com.studerb.hr.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.*;
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
@Path("/employees")
public class EmployeeResource {
    private static final Logger logger = Logger.getLogger(EmployeeResource.class);

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @GET
    @Produces("text/plain")
    public String getAllEmployeesText() {
        logger.debug("got request to /employees/");
        logger.debug("employeeService: " + employeeService);

        List<Employee> employees = employeeService.getAllEmployees();
        StrBuilder bldr = new StrBuilder();
        for (Employee e : employees) {
            bldr.append(e.toString() + SystemUtils.LINE_SEPARATOR);
        }
        return bldr.toString();
    }

    @GET
    @Produces("application/xml, text/xml")
    public Employees getAllEmployeesXml() {
        Employees employees = new Employees();
        List<Employee> employeeList = employeeService.getAllEmployees();
        employees.getEmployees().addAll(employeeList);
        return employees;
    }

    @GET
    @Produces("application/xml, text/xml")
    @Path("{id}")
    public Employee getEmployeeById(@PathParam("id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return employee;
    }

    /*
     * @POST
     * 
     * @Produces("text/plain") public String doPost(@FormParam("fileName")
     * String fileName, String fileList) { logger.debug("FileName: " +
     * fileName); logger.debug("body: " + fileList); return "0"; }
     */
}
