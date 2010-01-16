package com.studerb.hr.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.hr.dao.EmployeeDao;
import com.studerb.hr.model.Employee;

@Service("hibEmployeeService")
public class HibEmployeeService implements EmployeeService {
    private static final Logger logger = Logger.getLogger(HibEmployeeService.class);

    @Autowired
    protected EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        logger.debug("fetching all employees");
        return employeeDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(Long id) {
        logger.debug("Fetching Employee with id: " + id);
        return employeeDao.get(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long saveEmployee(Employee employee) {
        logger.debug("adding new employee: " + employee);
        return employeeDao.save(employee);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEmployee(Employee employee) {
        logger.debug("updating employee: " + employee);
        employeeDao.update(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public int getEmployeeCount() {
        return employeeDao.getCount();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDao.delete(id);
    }
}
