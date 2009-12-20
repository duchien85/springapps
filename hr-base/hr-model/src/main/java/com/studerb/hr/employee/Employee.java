package com.studerb.hr.employee;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import org.joda.time.DateTime;

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

    public Employee() {};

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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

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
