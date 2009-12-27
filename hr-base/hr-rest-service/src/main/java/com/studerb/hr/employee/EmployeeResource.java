package com.studerb.hr.employee;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.jersey.spi.resource.Singleton;

@Service
@Singleton
@Path("/employees")
public class EmployeeResource {
    private static final Logger logger = Logger.getLogger(EmployeeResource.class);

    @Autowired
    EmployeeService employeeService;

    @GET
    @Produces("text/plain")
    @Path("/")
    public String getAllEmployees() {
        logger.debug("got request to /employees/");
        logger.debug("employeeService: " + this.employeeService);

        List<Employee> employees = this.employeeService.getAllEmployees();
        StrBuilder bldr = new StrBuilder();
        for (Employee e : employees) {
            bldr.append(e.toString() + SystemUtils.LINE_SEPARATOR);
        }
        logger.debug("Returning: " + bldr.toString());
        return bldr.toString();
    }
    /*
     * @POST
     * 
     * @Produces("text/plain") public String doPost(@FormParam("fileName")
     * String fileName, String fileList) { logger.debug("FileName: " +
     * fileName); logger.debug("body: " + fileList); return "0"; }
     */
}
