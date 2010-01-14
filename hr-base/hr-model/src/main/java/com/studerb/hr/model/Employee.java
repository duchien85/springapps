package com.studerb.hr.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

/**
 * <p>
 * Java class for Employee complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Employee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phone_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hire_date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="job_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="salary" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="commission_pct" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="manager_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="department_id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "employee")
@XmlType(name = "Employee", propOrder = { "firstName", "lastName", "email", "phoneNumber", "hireDate", "jobId", "salary", "commissionPct", "managerId",
        "departmentId" })
public class Employee {
    private static final long serialVersionUID = 8744214730693860142L;
    private final FastDateFormat fdf = DateFormatUtils.ISO_DATE_FORMAT;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Calendar hireDate;
    private Job job;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Employee manager;
    private Department department;
    private Link link;
    Set<JobHistory> jobHistory = new LinkedHashSet<JobHistory>();

    public Employee() {}

    public Employee(Long id) {
        this.id = id;
    }

    @XmlAttribute
    @XmlSchemaType(name = "positiveInteger")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<JobHistory> getJobHistory() {
        return this.jobHistory;
    }

    public void setJobHistory(Set<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
    }

    @XmlElement(name = "first_name", required = true, nillable = true)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "last_name", required = true)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "phone_number", required = true, nillable = true)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement(name = "hire_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = DateUtils.truncate(hireDate, Calendar.DAY_OF_MONTH);
    }

    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @XmlElement(name = "commission_pct", required = true, nillable = true)
    public BigDecimal getCommissionPct() {
        return this.commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        if (!StringUtils.isBlank(jobId)) {
            this.job = new Job(jobId);
        }

    }

    @XmlElement(name = "department_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getDepartmentId() {
        return (this.department == null ? null : getDepartment().getId());
    }

    public void setDepartmentId(Long departmentId) {
        if (departmentId != null) {
            this.department = new Department(departmentId);
        }
    }

    @XmlElement(name = "manager_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getManagerId() {
        return (this.manager == null ? null : getManager().getId());
    }

    public void setManagerId(Long managerId) {
        if (managerId != null) {
            this.manager = new Employee(managerId);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.commissionPct == null) ? 0 : this.commissionPct.hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        result = prime * result + ((this.hireDate == null) ? 0 : this.hireDate.hashCode());
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = prime * result + ((getManagerId() == null) ? 0 : getManagerId().hashCode());
        result = prime * result + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());
        result = prime * result + ((this.salary == null) ? 0 : this.salary.hashCode());
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
        Employee other = (Employee) obj;
        if (this.commissionPct == null) {
            if (other.commissionPct != null)
                return false;
        }
        else if (!this.commissionPct.equals(other.commissionPct))
            return false;
        if (getDepartmentId() == null) {
            if (other.getDepartmentId() != null)
                return false;
        }
        else if (!getDepartmentId().equals(other.getDepartmentId()))
            return false;
        if (this.email == null) {
            if (other.email != null)
                return false;
        }
        else if (!this.email.equals(other.email))
            return false;
        if (this.firstName == null) {
            if (other.firstName != null)
                return false;
        }
        else if (!this.firstName.equals(other.firstName))
            return false;
        if (this.hireDate == null) {
            if (other.hireDate != null)
                return false;
        }
        else if (!DateUtils.isSameDay(this.hireDate, other.hireDate))
            return false;
        if (getJobId() == null) {
            if (other.getJobId() != null)
                return false;
        }
        else if (!getJobId().equals(other.getJobId()))
            return false;
        if (this.lastName == null) {
            if (other.lastName != null)
                return false;
        }
        else if (!this.lastName.equals(other.lastName))
            return false;
        if (this.manager == null) {
            if (other.manager != null)
                return false;
        }
        else if (!getManagerId().equals(other.getManagerId()))
            return false;
        if (this.phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        }
        else if (!this.phoneNumber.equals(other.phoneNumber))
            return false;
        if (this.salary == null) {
            if (other.salary != null)
                return false;
        }
        else if (!this.salary.equals(other.salary))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [commissionPct=").append(this.commissionPct).append(", department=").append(getDepartmentId()).append(", email=").append(
                this.email).append(", firstName=").append(this.firstName).append(", hireDate=").append(this.fdf.format(this.hireDate)).append(", id=").append(
                this.id).append(", job=").append(getJobId()).append(", lastName=").append(this.lastName).append(", manager=").append(getManagerId()).append(
                ", phoneNumber=").append(this.phoneNumber).append(", salary=").append(this.salary).append("]");
        return builder.toString();
    }

}
