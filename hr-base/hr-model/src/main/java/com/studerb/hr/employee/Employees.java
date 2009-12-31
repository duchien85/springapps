package com.studerb.hr.employee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employees")
@XmlType(name = "employeesType", propOrder = { "employees" })
public class Employees {

    private List<Employee> employees;

    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        if (this.employees == null) {
            this.employees = new ArrayList<Employee>();
        }
        return this.employees;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.employees == null) ? 0 : this.employees.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Employees other = (Employees) obj;
        if (this.employees == null) {
            if (other.employees != null)
                return false;
        }
        else if (!this.employees.equals(other.employees))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employees [employees=").append(this.employees).append("]");
        return builder.toString();
    }
}
