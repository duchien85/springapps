package com.studerb.hr.model;

import java.util.Calendar;

import javax.xml.bind.annotation.*;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
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
public class JobHistory {
    private final FastDateFormat fdf = DateFormatUtils.ISO_DATE_FORMAT;
    private Long employeeId;
    private Calendar endDate;
    private Calendar startDate;
    private Employee employee;
    private Department department;
    private Job job;
    private Link link;
    private String jobId;
    private Long departmentId;

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        if (this.employee != null) {
            this.employeeId = this.employee.getId();
        }
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
        if (this.department != null) {
            this.departmentId = this.department.getId();
        }
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
        if (this.job != null) {
            this.jobId = job.getId();
        }
    }

    @XmlAttribute(name = "employee_id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @XmlAttribute(name = "start_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = DateUtils.truncate(startDate, Calendar.DAY_OF_MONTH);
    }

    @XmlElement(name = "end_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = DateUtils.truncate(endDate, Calendar.DAY_OF_MONTH);
    }

    public Link getLink() {
        return this.link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @XmlElement(name = "job_id", required = true)
    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @XmlElement(name = "department_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.departmentId == null) ? 0 : this.departmentId.hashCode());
        result = prime * result + ((this.employeeId == null) ? 0 : this.employeeId.hashCode());
        result = prime * result + ((this.endDate == null) ? 0 : this.endDate.hashCode());
        result = prime * result + ((this.jobId == null) ? 0 : this.jobId.hashCode());
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
        if (this.departmentId == null) {
            if (other.departmentId != null)
                return false;
        }
        else if (!this.departmentId.equals(other.departmentId))
            return false;
        if (this.employeeId == null) {
            if (other.employeeId != null)
                return false;
        }
        else if (!this.employeeId.equals(other.employeeId))
            return false;
        if (this.startDate == null) {
            if (other.startDate != null)
                return false;
        }
        else if (!DateUtils.isSameDay(this.startDate, other.startDate))
            return false;
        if (this.endDate == null) {
            if (other.endDate != null)
                return false;
        }
        else if (!DateUtils.isSameDay(this.endDate, other.endDate))
            return false;
        if (this.jobId == null) {
            if (other.jobId != null)
                return false;
        }
        else if (!this.jobId.equals(other.jobId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JobHistory [departmentId=").append(this.departmentId).append(", employeeId=").append(this.employeeId).append(", endDate=").append(
                this.fdf.format(this.endDate)).append(", jobId=").append(this.jobId).append(", startDate=").append(this.fdf.format(this.startDate)).append("]");
        return builder.toString();
    }

}
