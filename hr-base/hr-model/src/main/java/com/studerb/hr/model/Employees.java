package com.studerb.hr.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

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
 *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "employees")
@XmlType(name = "EmployeesType", propOrder = { "employees" })
public class Employees {

    private List<Employee> employees;
    private Integer count;

    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        return employees;
    }

    @XmlAttribute
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer getCount() {
        if (count == null) {
            count = employees.size();
        }
        return count;
    }

    public void setCount(Integer c) {
        count = c;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employees == null) ? 0 : employees.hashCode());
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
        if (employees == null) {
            if (other.employees != null)
                return false;
        }
        else if (!employees.equals(other.employees))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employees [employees=").append(employees).append("]");
        return builder.toString();
    }
}
