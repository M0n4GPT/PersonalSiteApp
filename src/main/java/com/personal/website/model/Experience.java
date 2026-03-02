package com.personal.website.model;

/**
 * Represents a work-experience or education timeline entry.
 */
public class Experience {

    private String role;
    private String company;
    private String period;
    private String description;

    public Experience() {}

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
