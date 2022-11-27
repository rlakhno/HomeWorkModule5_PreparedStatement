package Populate.PopulateProjectWorker;

public class ProjectWorker {

    private int id;
    int worker_id;
    int project_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    @Override
    public String toString() {
        return "ProjectWorker{" +
                "id=" + id +
                ", worker_id=" + worker_id +
                ", project_id=" + project_id +
                '}';
    }
}

