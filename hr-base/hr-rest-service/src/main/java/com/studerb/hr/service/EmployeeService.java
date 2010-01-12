package com.studerb.hr.service;

import java.util.List;

import com.studerb.hr.model.Employee;

/**
 * @author studerw
 * 
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();

    /**
     * @param id
     * @return Employee or null if employee with passed id does not exist
     */
    Employee getEmployee(Long id);

    /**
     * @param employee
     *            new Employee to save
     * @return id of new employee,
     */
    Long saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    /**
     * @return count of current employees in persistence
     */
    int getEmployeeCount();
}
