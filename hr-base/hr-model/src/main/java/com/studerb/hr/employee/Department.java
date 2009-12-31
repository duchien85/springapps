package com.studerb.hr.employee;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.studerb.hr.Link;
import com.studerb.hr.geo.Location;

@XmlRootElement(name = "department")
@XmlType(name = "departmentType", propOrder = { "name", "managerId", "locationId" })
public class Department {

    private Long id;
    private String name;
    private Employee manager;
    private Location location;
    private Link link;
    public Long managerId;
    public Long locationId;

    private Set<Employee> employees = new HashSet<Employee>();

    public Department() {}

    public Department(Long id) {
        this.id = id;
    }

    @XmlAttribute
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(required = true)
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
        if (manager != null) {
            this.managerId = this.manager.getId();
        }
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
        if (this.location != null) {
            this.locationId = this.location.getId();
        }
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getManagerId() {
        return this.managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.locationId == null) ? 0 : this.locationId.hashCode());
        result = prime * result + ((this.managerId == null) ? 0 : this.managerId.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
        if (this.locationId == null) {
            if (other.locationId != null)
                return false;
        }
        else if (!this.locationId.equals(other.locationId))
            return false;
        if (this.managerId == null) {
            if (other.managerId != null)
                return false;
        }
        else if (!this.managerId.equals(other.managerId))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Department [id=").append(this.id).append(", locationId=").append(this.locationId).append(", managerId=").append(this.managerId).append(", name=")
                .append(this.name).append("]");
        return builder.toString();
    }
}
