package com.studerb.hr.employee;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.studerb.hr.Link;

@XmlRootElement(name = "job")
@XmlType(name = "jobType", propOrder = { "title", "minSalary", "maxSalary" })
public class Job {
    private String id;
    private String title;
    private Long minSalary;
    private Long maxSalary;
    private Link link;

    public Job() {}

    public Job(String id) {
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
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "min_salary")
    @XmlSchemaType(name = "positiveInteger")
    public Long getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    @XmlElement(name = "max_salary")
    @XmlSchemaType(name = "positiveInteger")
    public Long getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
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
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.maxSalary == null) ? 0 : this.maxSalary.hashCode());
        result = prime * result + ((this.minSalary == null) ? 0 : this.minSalary.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Job other = (Job) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.maxSalary == null) {
            if (other.maxSalary != null)
                return false;
        }
        else if (!this.maxSalary.equals(other.maxSalary))
            return false;
        if (this.minSalary == null) {
            if (other.minSalary != null)
                return false;
        }
        else if (!this.minSalary.equals(other.minSalary))
            return false;
        if (this.title == null) {
            if (other.title != null)
                return false;
        }
        else if (!this.title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Job [id=");
        builder.append(this.id);
        builder.append(", jobTitle=");
        builder.append(this.title);
        builder.append(", maxSalary=");
        builder.append(this.maxSalary);
        builder.append(", minSalary=");
        builder.append(this.minSalary);
        builder.append("]");
        return builder.toString();
    }
}
