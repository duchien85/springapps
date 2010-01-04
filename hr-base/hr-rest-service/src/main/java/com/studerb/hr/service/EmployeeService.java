package com.studerb.hr.service;

import java.util.List;

import com.studerb.hr.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    Long saveEmployee(Employee employee);

    void updateEmployee(Employee employee);
}
