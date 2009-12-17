package com.studerb.hr.employee;

import java.math.BigDecimal;

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

    // Set<JobHistory> jobHistory = new HashSet<JobHistory>();

    public Employee() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(DateTime hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [email=");
        builder.append(email);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", id=");
        builder.append(id);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", phoneNumber=");
        builder.append(phoneNumber);
        builder.append("]");
        return builder.toString();
    }
}
