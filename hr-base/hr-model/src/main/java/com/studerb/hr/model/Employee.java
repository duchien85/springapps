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
    private String jobId;
    private Long managerId;
    private Long departmentId;
    Set<JobHistory> jobHistory = new LinkedHashSet<JobHistory>();

    public Employee() {}

    public Employee(Long id) {
        this.id = id;
    }

    @XmlAttribute
    @XmlSchemaType(name = "positiveInteger")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<JobHistory> getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(Set<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
    }

    @XmlElement(name = "first_name", required = true, nillable = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "last_name", required = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "phone_number", required = true, nillable = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement(name = "hire_date", required = true)
    @XmlSchemaType(name = "date")
    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = DateUtils.truncate(hireDate, Calendar.DAY_OF_MONTH);
    }

    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @XmlElement(name = "commission_pct", required = true, nillable = true)
    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
        if (this.job != null) {
            jobId = this.job.getId();
        }
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
        if (manager != null) {
            managerId = this.manager.getId();
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
        if (this.department != null) {
            departmentId = department.getId();
        }
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @XmlElement(name = "job_id", required = true)
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
        if (job == null) {
            job = new Job(jobId);
        }
    }

    @XmlElement(name = "department_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        if (department == null) {
            department = new Department(departmentId);
        }
    }

    @XmlElement(name = "manager_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
        if (manager == null) {
            manager = new Employee(managerId);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((commissionPct == null) ? 0 : commissionPct.hashCode());
        result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
        Employee other = (Employee) obj;
        if (hireDate == null) {
            if (other.commissionPct != null)
                return false;
        }
        else if (!DateUtils.isSameDay(hireDate, other.hireDate))
            return false;
        if (commissionPct == null) {
            if (other.commissionPct != null)
                return false;
        }
        else if (!commissionPct.equals(other.commissionPct))
            return false;
        if (departmentId == null) {
            if (other.departmentId != null)
                return false;
        }
        else if (!departmentId.equals(other.departmentId))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (jobId == null) {
            if (other.jobId != null)
                return false;
        }
        else if (!jobId.equals(other.jobId))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        if (managerId == null) {
            if (other.managerId != null)
                return false;
        }
        else if (!managerId.equals(other.managerId))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        }
        else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        }
        else if (!salary.equals(other.salary))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [commissionPct=").append(commissionPct).append(", departmentId=").append(departmentId).append(", email=").append(email)
                .append(", firstName=").append(firstName).append(", hireDate=").append(fdf.format(hireDate)).append(", id=").append(id).append(", jobId=")
                .append(jobId).append(", lastName=").append(lastName).append(", managerId=").append(managerId).append(", phoneNumber=").append(phoneNumber)
                .append(", salary=").append(salary).append("]");
        return builder.toString();
    }

}
