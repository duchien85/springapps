package com.studerb.hr.employee;

import java.util.HashSet;
import java.util.Set;

import com.studerb.hr.geo.Location;

public class Department {

    private Long id;
    private String name;
    private Employee manager;
    private Location location;
    private Set<Employee> employees = new HashSet<Employee>();

    public Department() {}

    public Department(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Department [id=");
        builder.append(this.id);
        builder.append(", departmentName=");
        builder.append(this.name);
        builder.append("]");
        return builder.toString();
    }

}
