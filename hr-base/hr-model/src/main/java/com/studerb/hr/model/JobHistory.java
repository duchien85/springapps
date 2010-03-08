package com.studerb.hr.model;

import java.util.Calendar;

import javax.xml.bind.annotation.*;

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
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @XmlAttribute(name = "employee_id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getEmployeeId() {
        return (employee == null ? null : employee.getId());
    }

    public void setEmployeeId(Long employeeId) {
        if (employeeId != null) {
            employee = new Employee(employeeId);
        }
    }

    @XmlAttribute(name = "start_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = ModelUtils.standardizeCalendar(startDate);
    }

    @XmlElement(name = "end_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = ModelUtils.standardizeCalendar(endDate);
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @XmlElement(name = "job_id", required = true)
    public String getJobId() {
        return (job == null ? null : job.getId());
    }

    public void setJobId(String jobId) {
        if (jobId != null) {
            job = new Job(jobId);
        }
    }

    @XmlElement(name = "department_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getDepartmentId() {
        return (department == null ? null : department.getId());
    }

    public void setDepartmentId(Long departmentId) {
        if (departmentId != null) {
            department = new Department(departmentId);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((department == null) ? 0 : (department.getId() == null ? 0 : department.getId().hashCode()));
        result = prime * result
                + ((employee == null) ? 0 : (employee.getId() == null ? 0 : employee.getId().hashCode()));
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((job == null) ? 0 : (job.getId() == null ? 0 : job.getId().hashCode()));
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.err.println("******************************************Comparing: " + this + "******************\n"
                + obj);
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JobHistory other = (JobHistory) obj;
        if (department == null) {
            if (other.department != null)
                return false;
        }
        else if (!department.getId().equals(other.department.getId()))
            return false;
        if (employee == null) {
            if (other.employee != null)
                return false;
        }
        else if (!employee.getId().equals(other.employee.getId()))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        }
        else if (!endDate.equals(other.endDate))
            return false;
        if (job == null) {
            if (other.job != null)
                return false;
        }
        else if (!job.getId().equals(other.job.getId()))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        }
        else if (!startDate.equals(other.startDate))
            return false;
        System.err.println("****************************They were equal***********************");
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JobHistory [departmentId()=").append(getDepartmentId()).append(", employeeId=").append(
                getEmployeeId()).append(", endDate=").append((endDate == null ? "null" : fdf.format(endDate))).append(
                ", jobId=").append(getJobId()).append(", startDate=").append(
                startDate == null ? "null" : fdf.format(startDate)).append("]");
        return builder.toString();
    }

    @Override
    public int compareTo(JobHistory o) {
        return startDate.compareTo(o.getStartDate());
    }
}
