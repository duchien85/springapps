package com.studerb.hr.employee;

public class Job {
    private String id;
    private String title;
    private Long minSalary;
    private Long maxSalary;

    public Job() {}

    public Job(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Job [id=");
        builder.append(this.id);
        builder.append(", jobTitle=");
        builder.append(this.title);
        builder.append(", maxSalary=");
        builder.append(this.maxSalary);
        builder.append(", minSalary=");
        builder.append(this.minSalary);
        builder.append("]");
        return builder.toString();
    }

}
