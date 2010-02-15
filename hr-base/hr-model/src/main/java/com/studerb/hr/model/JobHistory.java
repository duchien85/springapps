package com.studerb.hr.model;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;

/**
 * <p>
 * Java class for Job_History complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Job_History">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="end_date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="job_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="department_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *       &lt;attribute name="employee_id" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="start_date" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
@XmlRootElement(name = "job_history")
@XmlType(name = "JobHistory", propOrder = { "endDate", "jobId", "departmentId" })
public class JobHistory implements Comparable<JobHistory> {
    private final FastDateFormat fdf = DateFormatUtils.ISO_DATE_FORMAT;
    private Calendar endDate;
    private Calendar startDate;
    private Employee employee;
    private Department department;
    private Job job;
    private Link link;

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @XmlAttribute(name = "employee_id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getEmployeeId() {
        return (this.employee == null ? null : this.employee.getId());
    }

    public void setEmployeeId(Long employeeId) {
        if (employeeId != null) {
            this.employee = new Employee(employeeId);
        }
    }

    @XmlAttribute(name = "start_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = ModelUtils.standardizeCalendar(startDate);
    }

    @XmlElement(name = "end_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = ModelUtils.standardizeCalendar(endDate);
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @XmlElement(name = "job_id", required = true)
    public String getJobId() {
        return (this.job == null ? null : this.job.getId());
    }

    public void setJobId(String jobId) {
        if (jobId != null) {
            this.job = new Job(jobId);
        }
    }

    @XmlElement(name = "department_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getDepartmentId() {
        return (this.department == null ? null : this.department.getId());
    }

    public void setDepartmentId(Long departmentId) {
        if (departmentId != null) {
            this.department = new Department(departmentId);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.department == null) ? 0 : (this.department.getId() == null ? 0 : this.department.getId().hashCode()));
        result = prime * result + ((this.employee == null) ? 0 : (this.employee.getId() == null ? 0 : this.employee.getId().hashCode()));
        result = prime * result + ((this.endDate == null) ? 0 : this.endDate.hashCode());
        result = prime * result + ((this.job == null) ? 0 : (this.job.getId() == null ? 0 : this.job.getId().hashCode()));
        result = prime * result + ((this.startDate == null) ? 0 : this.startDate.hashCode());
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
        JobHistory other = (JobHistory) obj;
        if (this.department == null) {
            if (other.department != null)
                return false;
        }
        else if (!this.department.getId().equals(other.department.getId()))
            return false;
        if (this.employee == null) {
            if (other.employee != null)
                return false;
        }
        else if (!this.employee.getId().equals(other.employee.getId()))
            return false;
        if (this.endDate == null) {
            if (other.endDate != null)
                return false;
        }
        else if (!this.endDate.equals(other.endDate))
            return false;
        if (this.job == null) {
            if (other.job != null)
                return false;
        }
        else if (!this.job.getId().equals(other.job.getId()))
            return false;
        if (this.startDate == null) {
            if (other.startDate != null)
                return false;
        }
        else if (!this.startDate.equals(other.startDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JobHistory [departmentId()=").append(getDepartmentId()).append(", employeeId=").append(getEmployeeId()).append(", endDate=").append(
                (this.endDate == null ? "null" : this.fdf.format(this.endDate))).append(", jobId=").append(getJobId()).append(", startDate=").append(
                this.startDate == null ? "null" : this.fdf.format(this.startDate)).append("]");
        return builder.toString();
    }

    @Override
    public int compareTo(JobHistory o) {
        return this.startDate.compareTo(o.getStartDate());
    }
}
