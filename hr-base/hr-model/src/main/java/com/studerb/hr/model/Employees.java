package com.studerb.hr.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Employees complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Employees">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employee" type="{hr-model}Employee" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "employees")
@XmlType(name = "Employees", propOrder = { "employees" })
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
