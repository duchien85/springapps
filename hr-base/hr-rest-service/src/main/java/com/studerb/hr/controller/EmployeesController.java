package com.studerb.hr.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studerb.hr.service.EmployeeService;

@Controller
@RequestMapping("/employees.htm")
public class EmployeesController {
    final static Logger log = Logger.getLogger(EmployeesController.class);

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public void get(ModelMap model) {
        log.debug("Getting Employees HTML Page");
        int count = employeeService.getEmployeeCount();
        model.addAttribute("count", count);
    }
}
