package Populate.PopulateWorker;


import Prefs.Prefs;
import dataBase.Database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class PopulateWorker {
    public static void populateWorker(Worker worker) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = Database.getInstance().getConnection()
                    .prepareStatement(Prefs.INSERT_INTO_WORKER);
            ps.setString(1, worker.getName());
            ps.setString(2, worker.getBirthday().toString());
            ps.setString(3, worker.getLevel());
            ps.setInt(4, worker.getSalary());
            ps.execute();
            int[] affectedRecords = ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                ps.close();
                System.out.println("Info added");
                System.out.println("Input name worker  or exit");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Worker worker = new Worker();

        System.out.println("Input name worker or exit: ");
        while (!sc.hasNext("exit")) {
            String name = sc.nextLine();
            worker.setName(name);


                System.out.println("Worker birthday --format (yyyy-mm-dd)-- ");

                String birthday = sc.nextLine();
                worker.setBirthday(LocalDate.parse(birthday));
            }

                System.out.println("Worker level: (Trainee, Middle, Senior)");
                String level = sc.next();
                worker.setLevel(level);

                System.out.println("Worker salary: ");
                int salary = sc.nextInt();
                worker.setSalary(salary);

                populateWorker(worker);

        }
    }




