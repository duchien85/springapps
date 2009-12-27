package com.studerb.hr.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
public class DefaultEmployeeService implements EmployeeService {
    private static final Logger logger = Logger.getLogger(DefaultEmployeeService.class);

    @Autowired
    protected EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        logger.debug("fetching all employees");
        return this.employeeDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(Long id) {
        logger.debug("Fetching Employee with id: " + id);
        return this.employeeDao.get(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long saveEmployee(Employee employee) {
        logger.debug("adding new employee: " + employee);
        return this.employeeDao.save(employee);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEmployee(Employee employee) {
        logger.debug("updating employee: " + employee);
        this.employeeDao.update(employee);
    }
}
