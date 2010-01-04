package com.studerb.hr.dao;

import org.springframework.stereotype.Repository;

import com.studerb.hr.model.Employee;

@Repository("employeeDao")
public class HibEmployeeDao extends AbstractHibernateDao<Employee> implements EmployeeDao {

    private final String TABLE_NAME = "EMPLOYEES";

    @Override
    public String getTableName() {
        return this.TABLE_NAME;
    }

}
