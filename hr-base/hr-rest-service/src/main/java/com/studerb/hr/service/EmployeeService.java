package com.studerb.hr.service;

import java.util.List;

import com.studerb.hr.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    /**
     * @param id
     * @return Employee or null if employee with passed id does not exist
     */
    Employee getEmployee(Long id);

    Long saveEmployee(Employee employee);

    void updateEmployee(Employee employee);
}
