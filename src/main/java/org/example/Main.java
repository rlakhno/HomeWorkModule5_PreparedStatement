package org.example;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {


        System.out.println("\n--- Longest Project ---\n\n ID MONTH ");
        List<LongestProject> longestProject = new DatabaseQueryService().findLongestProjects();

/*

        System.out.println("\n--- Max Projects Client ---\n\nCount  Name ");
        List<MaxProjectsClient>maxProjectsClients = new DatabaseQueryService().findMaxProjectClient();
*/


/*

        System.out.println("\n--- Max Salary Worker ---\n\nMaxSalary  Name ");
        List<MaxSalaryWorker> maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
*/

/*

        System.out.println("\n--- Youngest - Eldest Worker ---\n\n TYPE     NAME   BIRTHDAY ");
        List<YoungestEldestWorker> youngestEldestWorker = new DatabaseQueryService().findYoungestEldestWorker();
*/


/*

        System.out.println("\n--- Project Prices ---\n\nPROJECT#  PRICE ");
        List<ProjectPrices> projectPrices = new DatabaseQueryService().printProjectPrices();
*/


    }

}