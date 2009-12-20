package com.studerb.hr.employee;

import org.joda.time.DateTime;

public class JobHistory {
    private Long employeeId;
    private DateTime endDate;
    private DateTime startDate;
    private Employee employee;
    private Department department;
    private Job job;

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

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public DateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JobHistory that = (JobHistory) o;
        if (this.employeeId != null ? !this.employeeId.equals(that.employeeId) : that.employeeId != null)
            return false;
        if (this.endDate != null ? !this.endDate.equals(that.endDate) : that.endDate != null)
            return false;
        if (this.startDate != null ? !this.startDate.equals(that.startDate) : that.startDate != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = this.employeeId != null ? this.employeeId.hashCode() : 0;
        result = 31 * result + (this.startDate != null ? this.startDate.hashCode() : 0);
        result = 31 * result + (this.endDate != null ? this.endDate.hashCode() : 0);
        return result;
    }
}
