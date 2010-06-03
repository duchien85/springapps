package com.saic.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "BatPerson")
@XmlType(name = "BatPersonType", propOrder = { "guid", "firstName", "lastName" })
public class BatPerson implements Comparable<BatPerson> {
    String guid;
    String firstName;
    String lastName;

    public BatPerson() {}

    public BatPerson(String guid) {
        this.guid = guid;
    }

    @XmlElement(required = true)
    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlElement(required = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(required = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BatPerson [firstName=").append(this.firstName).append(", guid=").append(this.guid).append(", lastName=").append(this.lastName).append(
                "]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        result = prime * result + ((this.guid == null) ? 0 : this.guid.hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BatPerson other = (BatPerson) obj;
        if (this.firstName == null) {
            if (other.firstName != null)
                return false;
        }
        else if (!this.firstName.equals(other.firstName))
            return false;
        if (this.guid == null) {
            if (other.guid != null)
                return false;
        }
        else if (!this.guid.equals(other.guid))
            return false;
        if (this.lastName == null) {
            if (other.lastName != null)
                return false;
        }
        else if (!this.lastName.equals(other.lastName))
            return false;
        return true;
    }

    @Override
    public int compareTo(BatPerson o) {
        return this.guid.compareToIgnoreCase(o.getGuid());
    }
}
