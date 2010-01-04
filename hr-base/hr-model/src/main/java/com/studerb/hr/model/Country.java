package com.studerb.hr.model;


public class Country {

    private String id;
    private String name;
    private Region region;
    private Link link;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
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
        builder.append("Country [id=");
        builder.append(this.id);
        builder.append(", name=");
        builder.append(this.name);
        builder.append("]");
        return builder.toString();
    }
}
