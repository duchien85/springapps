package com.studerb.hr.service;

import java.util.List;

import com.studerb.hr.exception.EntityNotExistException;
import com.studerb.hr.model.Employee;

/**
 * Interface for the Employee class. All of these methods are guaranteed to be
 * called in a single transaction
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
     * @throws EntityNotExistException
     *             when employee with given id does not exist
     */
    Employee updateEmployee(Employee employee) throws EntityNotExistException;

    /**
     * @return count of current employees in persistence
     */
    int getEmployeeCount();

    /**
     * @param id
     *            employee to delete
     * @throws EntityNotExistException
     *             if employee with id does not exist
     */
    void deleteEmployee(Long id) throws EntityNotExistException;

    /**
     * Flush and clear the underlying context. If there is no 'ORM' type context
     * by the specific implementation, just no op and return
     */
    void flushAndClear();
}
