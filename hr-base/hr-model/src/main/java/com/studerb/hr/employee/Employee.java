package com.studerb.hr.employee;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement()
public class Employee {

    private static final long serialVersionUID = 8744214730693860142L;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private DateTime hireDate;
    private Job job;
    private BigDecimal salary;
    private BigDecimal commission;
    private Employee manager;
    private Department department;

    Set<JobHistory> jobHistory = new LinkedHashSet<JobHistory>();

    public Employee() {}

    public Employee(Long id) {
        this.id = id;
    }

    @XmlAttribute
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

    @XmlElement
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
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

    @XmlElement
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement
    public DateTime getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(DateTime hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @XmlElement
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @XmlElement
    public BigDecimal getCommission() {
        return this.commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.commission == null) ? 0 : this.commission.hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
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
        if (this.commission == null) {
            if (other.commission != null)
                return false;
        }
        else if (!this.commission.equals(other.commission))
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
        if (this.lastName == null) {
            if (other.lastName != null)
                return false;
        }
        else if (!this.lastName.equals(other.lastName))
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
        builder.append("Employee [email=");
        builder.append(this.email);
        builder.append(", firstName=");
        builder.append(this.firstName);
        builder.append(", id=");
        builder.append(this.id);
        builder.append(", lastName=");
        builder.append(this.lastName);
        builder.append(", phoneNumber=");
        builder.append(this.phoneNumber);
        builder.append("]");
        return builder.toString();
    }
}
