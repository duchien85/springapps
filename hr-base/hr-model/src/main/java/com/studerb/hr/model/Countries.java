package com.studerb.hr.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CountriesType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CountriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="country" type="{}CountryType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
@XmlRootElement
@XmlType(name = "Countries", propOrder = { "countries" })
public class Countries {

    @XmlElement(name = "country")
    List<Country> countries;

    public List<Country> getCountries() {
        if (this.countries == null) {
            this.countries = new ArrayList<Country>();
        }
        return this.countries;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.countries == null) ? 0 : this.countries.hashCode());
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
        Countries other = (Countries) obj;
        if (this.countries == null) {
            if (other.countries != null)
                return false;
        }
        else if (!this.countries.equals(other.countries))
            return false;
        return true;
    }

}
