package com.studerb.hr.service;

import java.util.*;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.hr.dao.EmployeeDao;
import com.studerb.hr.exception.EntityNotExistException;
import com.studerb.hr.model.Employee;
import com.studerb.hr.model.JobHistory;

@Service("hibEmployeeService")
public class HibEmployeeService implements EmployeeService {
    private static final Logger log = Logger.getLogger(HibEmployeeService.class);
    private static final FastDateFormat fdf = DateFormatUtils.ISO_DATE_FORMAT;

    @Autowired
    protected EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        log.debug("fetching all employees");
        return employeeDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(Long id) {
        log.debug("Fetching Employee with id: " + id);
        return employeeDao.get(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long saveEmployee(Employee employee) {
        log.debug("adding new employee: " + employee);
        return employeeDao.save(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    private Employee _updateEmployee(Employee employee) throws EntityNotExistException {
        log.debug("updating employee: " + employee);
        Long id = employee.getId();
        if (id == null || !employeeDao.exists(id)) {
            throw new EntityNotExistException("Employee with id: " + id + " does  not exist");
        }
        Employee temp = employeeDao.get(id);
        if ((!temp.getJobId().equals(employee.getJobId()))
                || (!temp.getDepartmentId().equals(employee.getDepartmentId()))) {
            JobHistory jobHistory = new JobHistory();
            jobHistory.setJobId(employee.getJobId());
            jobHistory.setDepartmentId(employee.getDepartmentId());
            jobHistory.setEndDate(Calendar.getInstance());
            jobHistory.setEmployee(employee);

            SortedSet<JobHistory> jh = employee.getJobHistory();
            if (jh.size() > 0) {
                Calendar start = jh.last().getEndDate();
                log.debug("End date of last jobHistory: " + fdf.format(start));
                start.add(Calendar.DAY_OF_YEAR, 1);
                log.debug("Setting new job history start date: " + fdf.format(start));
                jobHistory.setStartDate(start);
            }
            else {
                Calendar endDate = employee.getHireDate();
                log.debug("Setting new job history start date: " + fdf.format(endDate));
                jobHistory.setStartDate(endDate);
            }
            log.debug("Adding new Job History: " + jobHistory);
            jh.add(jobHistory);
        }
        Employee merged = employeeDao.merge(employee);
        log.debug("Merged Employee: " + merged);
        return merged;
    }

    @Override
    @Transactional(readOnly = true)
    public int getEmployeeCount() {
        return employeeDao.getCount();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteEmployee(Long id) throws EntityNotExistException {
        if (!employeeDao.exists(id)) {
            throw new EntityNotExistException("Employee with id: " + id + " does  not exist");
        }
        employeeDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEmployee(Employee employee) throws EntityNotExistException {
        if (!employeeDao.exists(employee.getId())) {
            throw new EntityNotExistException("Employee with id: " + employee.getId() + " does  not exist");
        }
        employeeDao.update(employee);
    }

    @Override
    public void flushAndClear() {
        employeeDao.flushAndClear();
    }
}
