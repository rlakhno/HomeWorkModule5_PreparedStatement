package org.example;

public class MaxProjectsClient {


    private  String client_name;
    private  int project_count;

    public MaxProjectsClient(String client_name, int project_count) {
        this.client_name = client_name;
        this.project_count = project_count;
    }

    public MaxProjectsClient() {
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getProject_count() {
        return project_count;
    }

    public void setProject_count(int project_count) {
        this.project_count = project_count;
    }
}
