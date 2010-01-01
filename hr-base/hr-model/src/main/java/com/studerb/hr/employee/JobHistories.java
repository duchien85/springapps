package com.studerb.hr.employee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Job_Histories complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Job_Histories">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="job_history" type="{hr-model}Job_History" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "job_histories")
@XmlType(name = "JobHistories", propOrder = { "jobHistories" })
public class JobHistories {

    private List<JobHistory> jobHistories;

    @XmlElement(name = "job_history")
    public List<JobHistory> getJobHistories() {
        if (this.jobHistories == null) {
            this.jobHistories = new ArrayList<JobHistory>();
        }
        return this.jobHistories;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.jobHistories == null) ? 0 : this.jobHistories.hashCode());
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
        JobHistories other = (JobHistories) obj;
        if (this.jobHistories == null) {
            if (other.jobHistories != null)
                return false;
        }
        else if (!this.jobHistories.equals(other.jobHistories))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Jobs [jobs=").append(this.jobHistories).append("]");
        return builder.toString();
    }
}
