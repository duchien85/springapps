package com.studerb.hr.employee;

import java.io.Serializable;

import org.joda.time.DateTime;

public class JobHistoryPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long employeeId;
    private DateTime startDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JobHistoryPK that = (JobHistoryPK) o;
        if (this.employeeId != null ? !this.employeeId.equals(that.employeeId) : that.employeeId != null)
            return false;
        if (this.startDate != null ? !this.startDate.equals(that.startDate) : that.startDate != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = this.employeeId != null ? this.employeeId.hashCode() : 0;
        result = 31 * result + (this.startDate != null ? this.startDate.hashCode() : 0);
        return result;
    }
}
