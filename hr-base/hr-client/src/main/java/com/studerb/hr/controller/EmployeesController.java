package com.studerb.hr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studerb.hr.model.Employee;
import com.studerb.hr.service.EmployeeRestService;

@Controller
@RequestMapping("/employees.htm")
public class EmployeesController {
    final static Logger log = Logger.getLogger(EmployeesController.class);

    @Resource
    EmployeeRestService jerseyEmployeeRestService;

    @RequestMapping(method = RequestMethod.GET)
    public void get(ModelMap model) {
        List<Employee> employees = jerseyEmployeeRestService.getAllEmployees();
        model.addAttribute("employees", employees);
    }
}
