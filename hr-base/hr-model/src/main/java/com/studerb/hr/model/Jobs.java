package com.studerb.hr.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Jobs complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Jobs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="job" type="{hr-model}Job" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "jobs")
@XmlType(name = "Jobs", propOrder = { "jobs" })
public class Jobs {

    private List<Job> jobs;

    @XmlElement(name = "job")
    public List<Job> getJobs() {
        if (this.jobs == null) {
            this.jobs = new ArrayList<Job>();
        }
        return this.jobs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.jobs == null) ? 0 : this.jobs.hashCode());
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
        Jobs other = (Jobs) obj;
        if (this.jobs == null) {
            if (other.jobs != null)
                return false;
        }
        else if (!this.jobs.equals(other.jobs))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Jobs [jobs=").append(this.jobs).append("]");
        return builder.toString();
    }
}
