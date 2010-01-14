package com.studerb.hr.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "Country", propOrder = { "name", "regionId" })
public class Country {

    private String id;
    private String name;
    private Region region;
    private Link link;

    public Country() {}

    public Country(String id) {
        this.id = id;
    }

    @XmlAttribute(required = true)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(required = true)
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

    @XmlElement(name = "region_id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getRegionId() {
        return (this.region == null ? null : this.region.getId());
    }

    public void setRegionId(Long regionId) {
        if (regionId != null) {
            this.region = new Region(regionId);
        }
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
