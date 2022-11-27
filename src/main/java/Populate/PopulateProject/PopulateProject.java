package Populate.PopulateProject;

import Prefs.Prefs;
import dataBase.Database;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PopulateProject {
    public static void populateProject(Project project) throws SQLException, IOException {
        PreparedStatement ps = Database.getInstance()
                .getConnection().prepareStatement(Prefs.INSERT_INTO_PROJECT);
        ps.setInt(1, project.getClient_id());
        ps.setDate(2, (Date) project.getStart_date());
        ps.setDate(3, (Date) project.getFinish_date());
        ps.execute();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Project project = new Project();

        System.out.println("client_ID: ");
        int client_id = sc.nextInt();
        project.setClient_id(client_id);

    System.out.println("start_project format(yyyy-mm-dd)");
    String start_project = sc.next();
    project.setStart_date(Date.valueOf(start_project));


        System.out.println("finish+project format(yyyy-mm-dd)");
        String finish_project = sc.next();
        project.setFinish_date(Date.valueOf(finish_project));
        try {
            populateProject(project);
        } catch (SQLException e) {
            throw new RuntimeException("Not found id_client");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
