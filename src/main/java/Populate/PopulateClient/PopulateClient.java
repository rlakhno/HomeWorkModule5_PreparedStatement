package Populate.PopulateClient;


import Prefs.Prefs;
import dataBase.Database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PopulateClient {

    public static void populateClient(Client client) throws SQLException {
        PreparedStatement ps = null;
        try {

            ps = Database.getInstance().getConnection()
                    .prepareStatement(Prefs.INSERT_INTO_CLIENT);
            ps.setString(1, client.getName());
            ps.execute();

            int[] affectedRecords = ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                ps.close();
                System.out.println("Client added");
                System.out.println("Input client name of EXIT:");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Input client name of exit:");
        while (!scan.hasNext("exit")) {

        String names = scan.nextLine();
        client.setName(names);
        populateClient(client);

        }

    }
}


