package com.studerb.hr.model;

import java.util.HashSet;
import java.util.Set;

public class Region {

    private Long id;
    private String name;
    private Link link;
    Set<Country> countries = new HashSet<Country>();

    public Region() {}

    public Region(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Set<Country> getCountries() {
        return this.countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Region [id=");
        builder.append(this.id);
        builder.append(", name=");
        builder.append(this.name);
        builder.append("]");
        return builder.toString();
    }

}
