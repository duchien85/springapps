package com.studerb.hr.model;

import java.io.Serializable;
import java.util.Calendar;

public class JobHistoryPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long employeeId;
    private Calendar startDate;

    public JobHistoryPK() {}

    public JobHistoryPK(Long employeeId, Calendar startDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
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
