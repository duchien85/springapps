package com.studerb.hr.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * Java class for LocationType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="LocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="street_address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postal_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state_province" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
@XmlRootElement
@XmlType(name = "Location", propOrder = { "streetAddress", "postalCode", "city", "stateProvince", "countryId" })
public class Location {
    @XmlAttribute
    @XmlSchemaType(name = "positiveInteger")
    private Long id;
    @XmlElement(name = "street_address", required = true, nillable = true)
    private String streetAddress;
    @XmlElement(name = "postal_code", required = true, nillable = true)
    private String postalCode;
    @XmlElement(required = true)
    private String city;
    @XmlElement(name = "state_province", required = true, nillable = true)
    private String stateProvince;
    private Country country;
    private Link link;

    public Location() {}

    public Location(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return this.stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @XmlElement(name = "country_id", required = true, nillable = true)
    public String getCountryId() {
        return (this.country == null ? null : this.country.getId());
    }

    public void setCountryId(String countryId) {
        if (!StringUtils.isBlank(countryId)) {
            this.country = new Country(countryId);
        }
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
        result = prime * result + ((getCountryId() == null) ? 0 : getCountryId().hashCode());
        result = prime * result + ((this.postalCode == null) ? 0 : this.postalCode.hashCode());
        result = prime * result + ((this.stateProvince == null) ? 0 : this.stateProvince.hashCode());
        result = prime * result + ((this.streetAddress == null) ? 0 : this.streetAddress.hashCode());
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
        Location other = (Location) obj;
        if (this.city == null) {
            if (other.city != null)
                return false;
        }
        else if (!this.city.equals(other.city))
            return false;
        if (getCountryId() == null) {
            if (other.getCountryId() != null)
                return false;
        }
        else if (!getCountryId().equals(other.getCountryId()))
            return false;
        if (this.postalCode == null) {
            if (other.postalCode != null)
                return false;
        }
        else if (!this.postalCode.equals(other.postalCode))
            return false;
        if (this.stateProvince == null) {
            if (other.stateProvince != null)
                return false;
        }
        else if (!this.stateProvince.equals(other.stateProvince))
            return false;
        if (this.streetAddress == null) {
            if (other.streetAddress != null)
                return false;
        }
        else if (!this.streetAddress.equals(other.streetAddress))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Location [city=");
        builder.append(this.city);
        builder.append(", id=");
        builder.append(this.id);
        builder.append(", postalCode=");
        builder.append(this.postalCode);
        builder.append(", stateProvince=");
        builder.append(this.stateProvince);
        builder.append(", streetAddress=");
        builder.append(this.streetAddress);
        builder.append(", countryId=");
        builder.append(getCountryId());
        builder.append("]");
        return builder.toString();
    }

}
