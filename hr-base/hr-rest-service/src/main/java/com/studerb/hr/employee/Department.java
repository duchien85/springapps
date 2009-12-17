package com.studerb.hr.employee;

import java.util.HashSet;
import java.util.Set;

import com.studerb.hr.geo.Location;

public class Department {

    private Long id;
    private String departmentName;
    private Employee manager;
    private Location location;
    private Set<Employee> employees = new HashSet<Employee>();

    public Department() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Department [id=");
        builder.append(id);
        builder.append(", departmentName=");
        builder.append(departmentName);
        builder.append("]");
        return builder.toString();
    }

}
