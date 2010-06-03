package com.saic.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "BatPersons")
@XmlType(name = "BatPersonsType", propOrder = { "batPersons" })
public class BatPersons {

    private List<BatPerson> batPersons;
    private Integer count;

    @XmlElement(name = "BatPerson")
    public List<BatPerson> getBatPersons() {
        if (this.batPersons == null) {
            this.batPersons = new ArrayList<BatPerson>();
        }
        return this.batPersons;
    }

    @XmlAttribute
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer getCount() {
        if (this.count == null) {
            this.count = this.batPersons.size();
        }
        return this.count;
    }

    public void setCount(Integer c) {
        this.count = c;
    }

}
