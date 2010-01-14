package com.studerb.hr.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Department complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Department">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="manager_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="location_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "department")
@XmlType(name = "Department", propOrder = { "name", "managerId", "locationId" })
public class Department {

    private Long id;
    private String name;
    private Employee manager;
    private Location location;
    private Link link;

    private Set<Employee> employees = new HashSet<Employee>();

    public Department() {}

    public Department(Long id) {
        this.id = id;
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @XmlElement(name = "manager_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getManagerId() {
        return (manager == null ? null : manager.getId());
    }

    public void setManagerId(Long managerId) {
        if (managerId != null) {
            manager = new Employee(managerId);
        }
    }

    @XmlElement(name = "location_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getLocationId() {
        return (location == null ? null : location.getId());
    }

    public void setLocationId(Long locationId) {
        if (locationId != null) {
            location = new Location(locationId);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLocationId() == null) ? 0 : getLocationId().hashCode());
        result = prime * result + ((getManagerId() == null) ? 0 : getManagerId().hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Department other = (Department) obj;
        if (getLocationId() == null) {
            if (other.getLocationId() != null)
                return false;
        }
        else if (!getLocationId().equals(other.getLocationId()))
            return false;
        if (getManagerId() == null) {
            if (other.getManagerId() != null)
                return false;
        }
        else if (!getManagerId().equals(other.getManagerId()))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Department [id=").append(id).append(", locationId=").append(getLocationId()).append(", managerId=").append(getManagerId()).append(
                ", name=").append(name).append("]");
        return builder.toString();
    }
}
