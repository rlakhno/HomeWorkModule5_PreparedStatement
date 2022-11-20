package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DatabaseInitService {
    public static void main(String[] args) throws SQLException, IOException {

        Statement statement = null;
        // Creating connection
        Connection conn = Database.getInstance().getConnection();
        System.out.println("connection is open ... " + conn);
        statement = conn.createStatement();
        Path sqlScriptPath = Paths.get("./src/SQL/init_db.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);

        for(String script: sqlScript) {
            statement.executeUpdate(script);
        }
        // Clean-up environment
        statement.close();
        conn.close();
        System.out.println("connection is closed ...   ");

    }
}