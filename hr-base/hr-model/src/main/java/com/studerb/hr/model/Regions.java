package com.studerb.hr.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for RegionsType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="RegionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="region" type="{}RegionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
@XmlRootElement(name = "regions")
@XmlType(name = "RegionsType", propOrder = { "regions" })
public class Regions {

    @XmlElement(name = "region")
    List<Region> regions;

    public List<Region> getRegions() {
        if (this.regions == null) {
            this.regions = new ArrayList<Region>();
        }
        return this.regions;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.regions == null) ? 0 : this.regions.hashCode());
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
        Regions other = (Regions) obj;
        if (this.regions == null) {
            if (other.regions != null)
                return false;
        }
        else if (!this.regions.equals(other.regions))
            return false;
        return true;
    }

}
