package dataBase;

import org.example.GettingProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {


    private static Database dbIsntance;
    private static Connection conn;


    private Database() {
        // private constructor //
    }

    public static Database getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new Database();
        }
        return dbIsntance;
    }



    public Connection getConnection() throws IOException {



        if (conn == null) {
            try {
                Class.forName(GettingProperties.JDBC_DRIVER);
                String host = GettingProperties.DB_URL;
                String username = GettingProperties.USER;
                String password = GettingProperties.PASS;
                conn = DriverManager.getConnection(host, username, password);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return conn;
    }
    public void executeUpdate(String sql){
        try (Statement st = conn.createStatement()){
            st.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("Table already exists");
        }
    }
}
