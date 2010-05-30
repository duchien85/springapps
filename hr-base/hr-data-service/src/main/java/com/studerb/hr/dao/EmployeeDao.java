package com.studerb.hr.dao;

import com.studerb.hr.model.Employee;

public interface EmployeeDao extends DaoInterface<Employee> {

    void delete(Long id);

}
