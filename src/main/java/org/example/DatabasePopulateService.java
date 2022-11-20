package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabasePopulateService {

    public static void main(String[] args) throws SQLException, IOException {

        Connection conn;
        Statement statement;

        conn = Database.getInstance().getConnection();
        System.out.println("connection is open ... " + conn);
        statement = conn.createStatement();

        Path sqlScriptPath = Paths.get("./src/SQL/populate_db.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);

        for(String script: sqlScript){
            statement.executeUpdate(script);
        }

        statement.close();
        conn.close();
        System.out.println("connection is closed ...   ");
    }

}
