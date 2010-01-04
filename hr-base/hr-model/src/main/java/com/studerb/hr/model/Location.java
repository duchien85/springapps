package com.studerb.hr.model;


public class Location {

    private Long id;
    private String streetAddress;
    private String postalCode;
    private String city;
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

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
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
        builder.append("]");
        return builder.toString();
    }

}
