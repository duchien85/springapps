package com.studerb.hr.employee;

import org.springframework.stereotype.Repository;

import com.studerb.hr.dao.AbstractHibernateDao;

@Repository("employeeDao")
public class HibEmployeeDao extends AbstractHibernateDao<Employee> implements EmployeeDao {

    private final String TABLE_NAME = "EMPLOYEES";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

}
