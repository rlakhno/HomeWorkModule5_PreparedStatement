package Populate.PopulateProject;

import java.util.Date;

public class Project {

    int id;
    int client_id;
    Date start_date;
    Date finish_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", start_date=" + start_date +
                ", finish_date=" + finish_date +
                '}';
    }
}
