

/**
@author Kolby Lalonde 
UCID: 30115568
Tutorial Section: T06
@version 1.0 March, 29, 2022
@since 1.0 March, 29, 2022
**/

package edu.ucalgary.ensf409;

import java.sql.*;

// Commands (Kolby) //
// javac -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/DataStorage.java
// java -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/DataStorage
// /usr/local/mysql/bin/mysql -u root -p

public class DataStorage {

    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;

    private String [][] dailyClientNeedsTable = new String [4][6]; // 4 row by 6 columns
    private String [][] avaliableFoodTable;
    
    public DataStorage(String url){

        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = "student";
        this.PASSWORD = "ensf";
    }


    //Method to create a connection to the database, no arguments, no return value  
    public void initializeConnection(){
        try{
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }              
    }
    
    // Url getter
    String getDburl(){
        return this.DBURL;
    }

    // Username getter
    String getUsername(){
        return this.USERNAME;
    }
    
    // Password getter
    String getPassword(){
        return this.PASSWORD;
    }

    // Method to set all daily needs in a member variable
    public void setDailyClientNeedsTable(String tableName){     

        StringBuffer needs = new StringBuffer();

        try{
            String query = "SELECT * FROM " + tableName;
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);

            int i = 0;
            while (results.next()){       
                this.dailyClientNeedsTable[i][0] = results.getString("Client");
                this.dailyClientNeedsTable[i][1] = results.getString("WholeGrains");
                this.dailyClientNeedsTable[i][2] = results.getString("FruitVeggies");
                this.dailyClientNeedsTable[i][3] = results.getString("Protein");
                this.dailyClientNeedsTable[i][4] = results.getString("Other");
                this.dailyClientNeedsTable[i][5] = results.getString("Calories");
                i++;
            }
        } 
        catch(SQLException e){
            e.printStackTrace();
        }           
    }

    // Daily needs table gettter
    public String[][] getDailyClientNeedsTable(){
        return this.dailyClientNeedsTable;
    }

    // Method to find the number of food items in data base
    public int numberOfFoodItems(String tableName){

        StringBuffer food = new StringBuffer();
        int i = 0;

        try{
            String query = "SELECT * FROM " + tableName;
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);
            while (results.next()){       
                i++;
            }
        } 
        catch(SQLException e){
            e.printStackTrace();
        }           
        return i;

    }

    // Method to set avaliable food table
    public void setAvaliableFoodTable(String tableName, int total){     

        StringBuffer needs = new StringBuffer();
        this.avaliableFoodTable = new String [total][6];

        try{
            String query = "SELECT * FROM " + tableName;
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);

            int i = 0;
            while (results.next()){       
                this.avaliableFoodTable[i][0] = results.getString("Name");
                this.avaliableFoodTable[i][1] = results.getString("GrainContent");
                this.avaliableFoodTable[i][2] = results.getString("FVContent");
                this.avaliableFoodTable[i][3] = results.getString("ProContent");
                this.avaliableFoodTable[i][4] = results.getString("Other");
                this.avaliableFoodTable[i][5] = results.getString("Calories");
                i++;
            }
        } 
        catch(SQLException e){
            e.printStackTrace();
        }           
    }

    // Avaliable food table gettter
    public String[][] getAvaliableFoodTable(){
        return this.avaliableFoodTable;
    }

    // Method to return all daily needs in a String
    public String selectAllNeeds(String tableName){     

        StringBuffer needs = new StringBuffer();

        try{
            String query = "SELECT * FROM " + tableName;
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);

            while (results.next()){       
                needs.append(results.getString("Client") + ", " + results.getString("WholeGrains") + ", "); 
                needs.append(results.getString("FruitVeggies") + ", " + results.getString("Protein") + ", "); 
                needs.append(results.getString("Other") + ", " + results.getString("Calories")); 
                needs.append('\n');  
            }
        } 
        catch(SQLException e){
            e.printStackTrace();
        }           
        return needs.toString().trim();
    }

    // Method to return all avaliable food in a String
    public String selectAllFood(String tableName){     

        StringBuffer food = new StringBuffer();

        try{
            String query = "SELECT * FROM " + tableName;
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);

            while (results.next()){       
                food.append(results.getString("Name") + ", " + results.getString("GrainContent") + ", "); 
                food.append(results.getString("FVContent") + ", " + results.getString("ProContent") + ", "); 
                food.append(results.getString("Other") + ", " + results.getString("Calories"));
                food.append('\n'); 
            }
        } 
        catch(SQLException e){
            e.printStackTrace();
        }           
        return food.toString().trim();
    }
    
    // Method to close database connection
    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }              
    }

    public static void main(String[] args) {

        //Creating the datastorage class through path "jdbc:mysql://localhost/FOOD_INVENTORY"
        DataStorage myJDBC = new DataStorage("jdbc:mysql://localhost/FOOD_INVENTORY");
        
        // initializeConnection to the database
        myJDBC.initializeConnection();

        // testing database extraction
        System.out.println("------------------------------");
        System.out.println("***Printing list of DAILY_ClIENT_NEEDS directly from DB:***");
        System.out.println(myJDBC.selectAllNeeds("DAILY_ClIENT_NEEDS"));
        System.out.println("------------------------------");
        System.out.println("***Printing list of AVAILABLE_FOOD directly from DB:***");
        System.out.println(myJDBC.selectAllFood("AVAILABLE_FOOD"));
        
        // testing setting the daily needs table
        System.out.println("------------------------------");
        System.out.println("***Setting and showing the daily client needs table:***");
        myJDBC.setDailyClientNeedsTable("DAILY_ClIENT_NEEDS");
        String [][] table1 = myJDBC.getDailyClientNeedsTable();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                System.out.println(table1[i][j]);
            }
        }

        // testing setting the avalible foods table
        System.out.println("------------------------------");
        System.out.println("***Setting and showing the avaliable foods table:***");

        System.out.println("Number of food items = " + myJDBC.numberOfFoodItems("AVAILABLE_FOOD"));

        myJDBC.setAvaliableFoodTable("AVAILABLE_FOOD", myJDBC.numberOfFoodItems("AVAILABLE_FOOD"));
        String [][] table2 = myJDBC.getAvaliableFoodTable();
        for(int i = 0; i < myJDBC.numberOfFoodItems("AVAILABLE_FOOD"); i++){
            String line = "";
            for(int j = 0; j < 6; j++){
                
                line += table2[i][j] + ", ";
            }
            System.out.println(line);
        }

        // Closing connection to database
        System.out.println("------------------------------");
        System.out.println("***End of tests.***"); 
        myJDBC.close();
                
    }
}