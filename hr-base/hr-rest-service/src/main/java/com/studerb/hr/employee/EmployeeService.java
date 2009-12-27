package com.studerb.hr.employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    Long saveEmployee(Employee employee);

    void updateEmployee(Employee employee);
}
