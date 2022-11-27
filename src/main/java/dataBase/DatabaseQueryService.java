package dataBase;

import sqlClassMethods.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseQueryService {


    public List<LongestProject> findLongestProjects() throws IOException {
        LongestProject longestProject = new LongestProject();

        List<LongestProject> longestProjectList = new ArrayList<>();

        Path sqlScriptPath = Paths.get("./src/SQL/find_longest_project.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);

        ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();){


            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            PreparedStatement selectLongestProject =
                    conn.prepareStatement(listString);

            resultSet = selectLongestProject.executeQuery();
            while (resultSet.next()) {
                longestProject.setProject_id(resultSet.getInt("project_id"));
                longestProject.setLongest_month(resultSet.getString("longest_month"));
                System.out.format(" %d, %s\n", longestProject
                        .getProject_id(),longestProject.getLongest_month());
                longestProjectList.add(longestProject);

            }
            // Clean-up environment
            selectLongestProject.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }


        return longestProjectList;

    }


    List<MaxProjectsClient> findMaxProjectClient() throws  IOException {

        MaxProjectsClient maxProjectsClient = new MaxProjectsClient();
        Path sqlScriptPath = Paths.get("./src/SQL/find_max_projects_client.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);
        ResultSet resultSet = null;
        List<MaxProjectsClient> maxProjectsClientList =
                new ArrayList<MaxProjectsClient>();
        try(Connection conn = Database.getInstance().getConnection();){

            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            PreparedStatement selectMaxProjectClient =
                    conn.prepareStatement(listString);
            resultSet = selectMaxProjectClient.executeQuery();
            while(resultSet.next()){
                maxProjectsClient.setClient_name(resultSet.getString("client_name"));
                maxProjectsClient.setProject_count(resultSet.getInt("project_count"));
                System.out.format(" %d, %s\n", maxProjectsClient.getProject_count()
                        , maxProjectsClient.getClient_name());
                maxProjectsClientList.add(maxProjectsClient);
            }
            // Clean-up environment
            selectMaxProjectClient.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }

        return maxProjectsClientList;

    }

    List<MaxSalaryWorker> findMaxSalaryWorker() throws  IOException {

        MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();

        Path sqlScriptPath = Paths.get("./src/SQL/find_max_salary_worker.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);

        ResultSet resultSet = null;
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<MaxSalaryWorker>();


        try(Connection conn = Database.getInstance().getConnection();){


            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            PreparedStatement selectMaxSal = conn.prepareStatement(listString);
            resultSet = selectMaxSal.executeQuery();

            while(resultSet.next()){
                maxSalaryWorker.setName(resultSet.getString("name"));
                maxSalaryWorker.setMax_salary(resultSet.getInt("max_salary"));

                System.out.format("%d,   %s\n", maxSalaryWorker.getMax_salary()
                        , maxSalaryWorker.getName());

                maxSalaryWorkerList.add(maxSalaryWorker);

            }

            resultSet.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return maxSalaryWorkerList;

    }

    List<YoungestEldestWorker> findYoungestEldestWorker() throws  IOException {

        YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
        Path sqlScriptPath = Paths.get("./src/SQL/find_youngest_eldest_workers.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);
        List<YoungestEldestWorker> youngestEldestWorkerList =
                new ArrayList<YoungestEldestWorker>();
        ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();){


            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            PreparedStatement selectYoungestEldestWorker =
                    conn.prepareStatement(listString);
            resultSet = selectYoungestEldestWorker.executeQuery();
            while(resultSet.next()){
                youngestEldestWorker.setName(resultSet.getString("name"));
                youngestEldestWorker.setBirthday(resultSet.getString("birthday"));
                youngestEldestWorker.setType(resultSet.getString("type"));

                System.out.format(" %s, %s, %s\n", youngestEldestWorker.getType()
                        , youngestEldestWorker.getName(), youngestEldestWorker.getBirthday());
                youngestEldestWorkerList.add(youngestEldestWorker);

            }
            // Clean-up environment
            resultSet.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }

        return youngestEldestWorkerList;

    }

    List<ProjectPrices> printProjectPrices() throws IOException {

        ProjectPrices projectPrices = new ProjectPrices();
        List<ProjectPrices> projectPricesList =
                new ArrayList<ProjectPrices>();
        Path sqlScriptPath = Paths.get("./src/SQL/print_project_prices.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);
        ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();){


            String listString = sqlScript.stream().map(String::valueOf).collect(Collectors.joining());
            PreparedStatement selectPrintPrices = conn.prepareStatement(listString);
            resultSet = selectPrintPrices.executeQuery();
            while(resultSet.next()){
                projectPrices.setProject_id(resultSet.getInt("project_id"));
                projectPrices.setPrice(resultSet.getInt("price"));
                System.out.format("   %d,     %d\n", projectPrices.getProject_id(), projectPrices.getPrice());
                projectPricesList.add(projectPrices);
            }

            // Clean-up environment
            resultSet.close();
            conn.close();


        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

}
