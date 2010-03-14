package com.studerb.hr.resource;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

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
    @Produces( { MediaType.APPLICATION_XML, MediaType.TEXT_XML })
    public Employees getAllEmployeesXml() {
        Employees employees = new Employees();
        List<Employee> employeeList = employeeService.getAllEmployees();
        employees.getEmployees().addAll(employeeList);
        return employees;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employees getAllEmployeesJson() {
        Employees employees = new Employees();
        List<Employee> employeeList = employeeService.getAllEmployees();
        employees.getEmployees().addAll(employeeList);
        return employees;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createEmployee(@Context UriInfo uriInfo, Employee employee) {
        Long newId = employeeService.saveEmployee(employee);
        log.info("Created new employee - Id =  " + newId);
        URI location = uriInfo.getAbsolutePathBuilder().path(newId.toString()).build();
        return Response.created(location).build();
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

    @DELETE
    @Path("{id}/")
    public Response deleteEmployeeById(@PathParam("id") Long id) {
        log.debug("Getting employee by id: " + id);
        // throws a NotFoundException if employee with 'id' doensn't exist
        employeeService.deleteEmployee(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("{id}/")
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateEmployee(@PathParam("id") Long id, Employee employee) {
        if (!id.equals(employee.getId())) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        employeeService.updateEmployee(employee);
        return Response.noContent().build();
    }
}
