package com.studerb.hr.employee;

public class Job {
    private String id;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Job [id=");
        builder.append(id);
        builder.append(", jobTitle=");
        builder.append(jobTitle);
        builder.append(", maxSalary=");
        builder.append(maxSalary);
        builder.append(", minSalary=");
        builder.append(minSalary);
        builder.append("]");
        return builder.toString();
    }

}
