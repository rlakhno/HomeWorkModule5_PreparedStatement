package org.example;

public class ProjectPrices {

    private int project_id;
    private int price;

    public ProjectPrices(int project_id, int price) {
        this.project_id = project_id;
        this.price = price;
    }

    public ProjectPrices() {
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
