package com.studerb.hr.geo;

public class Country {

    private String id;
    private String countryName;
    private Region region;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String name) {
        this.countryName = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Country [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(countryName);
        builder.append("]");
        return builder.toString();
    }
}
