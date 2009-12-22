package com.studerb.hr.employee;

import java.util.Calendar;

public class JobHistory {
	private Long employeeId;
	private Calendar endDate;
	private Calendar startDate;
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

	public Calendar getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
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

	@Override public int hashCode() {
		int result = this.employeeId != null ? this.employeeId.hashCode() : 0;
		result = 31 * result + (this.startDate != null ? this.startDate.hashCode() : 0);
		result = 31 * result + (this.endDate != null ? this.endDate.hashCode() : 0);
		return result;
	}
}
