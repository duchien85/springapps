package com.studerb.hr.employee;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.studerb.hr.Link;

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
@XmlType(name = "Employee", propOrder = { "firstName", "lastName", "email", "phoneNumber", "hireDate", "jobId", "salary", "commissionPct", "managerId", "departmentId" })
public class Employee {

    private static final long serialVersionUID = 8744214730693860142L;
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
        this.hireDate = hireDate;
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
        if (this.job != null) {
            this.jobId = this.job.getId();
        }
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
        if (manager != null) {
            this.managerId = this.manager.getId();
        }
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
        if (this.department != null) {
            this.departmentId = department.getId();
        }
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

    @XmlElement(name = "manager_id", required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    public Long getManagerId() {
        return this.managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.commissionPct == null) ? 0 : this.commissionPct.hashCode());
        result = prime * result + ((this.departmentId == null) ? 0 : this.departmentId.hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        result = prime * result + ((this.jobId == null) ? 0 : this.jobId.hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = prime * result + ((this.managerId == null) ? 0 : this.managerId.hashCode());
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
        if (this.getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (this.commissionPct == null) {
            if (other.commissionPct != null)
                return false;
        }
        else if (!this.commissionPct.equals(other.commissionPct))
            return false;
        if (this.departmentId == null) {
            if (other.departmentId != null)
                return false;
        }
        else if (!this.departmentId.equals(other.departmentId))
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
        if (this.jobId == null) {
            if (other.jobId != null)
                return false;
        }
        else if (!this.jobId.equals(other.jobId))
            return false;
        if (this.lastName == null) {
            if (other.lastName != null)
                return false;
        }
        else if (!this.lastName.equals(other.lastName))
            return false;
        if (this.managerId == null) {
            if (other.managerId != null)
                return false;
        }
        else if (!this.managerId.equals(other.managerId))
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
        builder.append("Employee [commissionPct=").append(this.commissionPct).append(", departmentId=").append(this.departmentId).append(", email=").append(this.email).append(
                ", firstName=").append(this.firstName).append(", hireDate=").append(this.hireDate.getTime()).append(", id=").append(this.id).append(", jobId=").append(
                this.jobId).append(", lastName=").append(this.lastName).append(", managerId=").append(this.managerId).append(", phoneNumber=").append(this.phoneNumber).append(
                ", salary=").append(this.salary).append("]");
        return builder.toString();
    }

}
