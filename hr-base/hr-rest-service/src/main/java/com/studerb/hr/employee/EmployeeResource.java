package com.studerb.hr.employee;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/customers")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeService;
}
