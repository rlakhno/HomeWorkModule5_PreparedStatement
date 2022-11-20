package org.example;

public class LongestProject {

    private int project_id;
    private String longest_month;

    public LongestProject(int project_id, String longest_month) {
        this.project_id = project_id;
        this.longest_month = longest_month;
    }

    public LongestProject() {
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getLongest_month() {
        return longest_month;
    }

    public void setLongest_month(String longest_month) {
        this.longest_month = longest_month;
    }
}
