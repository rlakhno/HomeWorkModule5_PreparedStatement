package org.example;

public class YoungestEldestWorker {

    private String name;
    private String birthday;
    private String type;

    public YoungestEldestWorker(String name, String birthday, String type) {
        this.name = name;
        this.birthday = birthday;
        this.type = type;
    }

    public YoungestEldestWorker() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
