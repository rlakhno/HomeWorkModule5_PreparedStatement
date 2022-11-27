package sqlClassMethods;

import java.sql.ResultSet;

public class MaxSalaryWorker {


    private String name;
    private int max_salary;

    public MaxSalaryWorker(String name, int max_salary) {
        this.name = name;
        this.max_salary = max_salary;
    }

    public MaxSalaryWorker() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }
}
