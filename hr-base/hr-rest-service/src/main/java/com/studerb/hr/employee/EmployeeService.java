package com.studerb.hr.employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();

    public Employee get(Long id);

    public Long save(Employee employee);
}
