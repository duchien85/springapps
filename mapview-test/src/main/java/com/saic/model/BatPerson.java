package com.saic.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import oracle.spatial.geometry.JGeometry;

@XmlRootElement(name = "BatPerson")
@XmlType(name = "BatPersonType", propOrder = { "batGuid", "messageId" })
public class BatPerson implements Comparable<BatPerson> {
    BigDecimal messageId;
    String batGuid;
    String firstName;
    String lastName;
    JGeometry geom;

    public BatPerson() {}

    public BatPerson(String batGuid) {
        this.batGuid = batGuid;
    }

    public BigDecimal getMessageId() {
        return this.messageId;
    }

    @XmlElement(required = false)
    public void setMessageId(BigDecimal messageId) {
        this.messageId = messageId;
    }

    @XmlElement(required = true)
    public String getBatGuid() {
        return this.batGuid;
    }

    public void setBatGuid(String batGuid) {
        this.batGuid = batGuid;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public JGeometry getGeom() {
        return this.geom;
    }

    public void setGeom(JGeometry geom) {
        this.geom = geom;
    }

    @Override
    public int compareTo(BatPerson o) {
        return this.batGuid.compareToIgnoreCase(o.getBatGuid());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.batGuid == null) ? 0 : this.batGuid.hashCode());
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
        if (this.batGuid == null) {
            if (other.batGuid != null)
                return false;
        }
        else if (!this.batGuid.equals(other.batGuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BatPerson [batGuid=").append(this.batGuid).append(", firstName=").append(this.firstName).append(", geom=").append(this.geom).append(
                ", lastName=").append(this.lastName).append(", messageId=").append(this.messageId).append("]");
        return builder.toString();
    }

}
