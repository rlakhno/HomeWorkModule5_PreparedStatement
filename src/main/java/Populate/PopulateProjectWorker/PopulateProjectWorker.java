package Populate.PopulateProjectWorker;

import Prefs.Prefs;
import dataBase.Database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PopulateProjectWorker {

    public static void populateProjectWorker(ProjectWorker projectWorker) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = Database.getInstance().getConnection().prepareStatement(Prefs.INSERT_INTO_PROJECT_WORKER);
            ps.setInt(1, projectWorker.getWorker_id());
            ps.setInt(2, projectWorker.getProject_id());
            ps.execute();

            int[] affectedRecords = ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                ps.close();
                System.out.println("info added");
                System.out.println("input worker_id or exit");

            }
        }
    }

    public static void main(String[] args) throws SQLException {
        ProjectWorker projectWorker = new ProjectWorker();
        Scanner sc = new Scanner(System.in);


            System.out.println("input worker_id or exit");
            while (!sc.hasNext("exit")) {
            int worker_id = sc.nextInt();
            projectWorker.setWorker_id(worker_id);


            System.out.println("input project_id or exit");
            int project_id = sc.nextInt();
            projectWorker.setProject_id(project_id);
            populateProjectWorker(projectWorker);

        }
    }
}
