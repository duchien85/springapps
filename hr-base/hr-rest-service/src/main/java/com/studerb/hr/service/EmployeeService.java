package com.studerb.hr.service;

import java.util.List;

import com.studerb.hr.model.Employee;
import com.sun.jersey.api.NotFoundException;

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

    /**
     * @param employee
     * @throws NotFoundException
     *             when employee with given id does not exist
     */
    void updateEmployee(Employee employee) throws NotFoundException;

    /**
     * @return count of current employees in persistence
     */
    int getEmployeeCount();

    /**
     * @param id
     *            employee to delete
     * @throws NotFoundException
     *             if employee with id does not exist
     */
    void deleteEmployee(Long id) throws NotFoundException;

    /**
     * Flush and clear the underlying context. If there is no 'ORM' type context
     * by the specific implementation, just no op and return
     */
    void flushAndClear();
}
