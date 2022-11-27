package Prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DB_JDBC_CONNECTION_URL = "dbUrl";
    public static final String CONNECTION_FOR_METHOD = "jdbc:h2:./test";

    public static final String FIND_MAX_PROJECTS_CLIENT = "findMaxProjectsClient";
    public static final String PRINT_PROJECT_PRICES = "printProjectPrices";
    public static final String FIND_LONGEST_PROJECT = "findLongestProject";
    public static final String FIND_YOUNGEST_ELDEST_WORKERS = "findYoungestEldestWorkers";
    public static final String INIT_DB_SQL_FILE_PATH= "initDbSql";
    public static final String POPULATE_DB_SQL_PATH = "populateDbSql";
    public static final String FIND_MAX_SALARY_WORKER = "findMaxSalaryWorker";
    public static final String DEFAULT_PREFS_FILENAME = "Prefs.json";
    public static final String INSERT_INTO_WORKER ="INSERT INTO worker(name,birthday,level,salary) VALUES (?,?,?,?)";
    public static final String INSERT_INTO_CLIENT = "INSERT INTO client (client_name) VALUES (?)";
    public static final String INSERT_INTO_PROJECT ="INSERT INTO project (client_id, start_date, finish_date) VALUES (?,?,?)";
    public static final String INSERT_INTO_PROJECT_WORKER = "INSERT INTO project_worker (worker_id, project_id) VALUES (?,?)";

    private Map<String, Object> prefs = new HashMap<>();
    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs (String filename){
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(filename)));
            TypeToken<?> typeToken = TypeToken.getParameterized(Map.class,
                    String.class, Object.class);
            prefs=new Gson().fromJson(json, typeToken.getType());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public String getString(String key){
        return getPref(key).toString();
    }
    public Object getPref(String key){
        return prefs.get(key);
    }
}