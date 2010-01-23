package com.studerb.hr.service;

import java.util.List;

import org.dom4j.Document;

import com.studerb.hr.model.Employee;

public interface EmployeeRestService {

    List<Employee> getAllEmployees();

    Document getAllEmployeesXml();
}
