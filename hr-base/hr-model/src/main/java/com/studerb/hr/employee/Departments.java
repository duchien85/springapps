package com.studerb.hr.employee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "departments")
@XmlType(name = "departmentsType", propOrder = { "departments" })
public class Departments {

    private List<Department> departments;

    @XmlElement(name = "department")
    public List<Department> getDepartments() {
        if (this.departments == null) {
            this.departments = new ArrayList<Department>();
        }
        return this.departments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.departments == null) ? 0 : this.departments.hashCode());
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
        Departments other = (Departments) obj;
        if (this.departments == null) {
            if (other.departments != null)
                return false;
        }
        else if (!this.departments.equals(other.departments))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Departments [departments=").append(this.departments).append("]");
        return builder.toString();
    }
}
