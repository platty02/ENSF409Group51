

/**
@author Kolby Lalonde 
UCID: 30115568
@version 1.3 April, 12, 2022
@since 1.0 March, 29, 2022
**/

package edu.ucalgary.ensf409;

import java.sql.*;

// Data Storage Class Commands //
// javac -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/DataStorage.java
// java -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/DataStorage

// Data Storage Class Description //
/*
    The DataStorage Class is used to connect and extract data from and sql database.
This class has been desgined to read in two string tables for the daily client needs
and the available foods tables.
*/

public class DataStorage {

    // Data Storage Member Variables
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    private Connection dbConnect;
    private ResultSet results;

    // String tables for extracting database values
    private String [][] dailyClientNeedsTable = new String [4][7]; // Size of table not dependant on database
    private String [][] avaliableFoodTable;            // Size dependant on number of database items
    
    // Constructor
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
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD); // creating connection
        } catch (SQLException e) {
            e.printStackTrace();                        // Error catching
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

    // Method to set all daily needs in a string table member variable
    public void setDailyClientNeedsTable(String tableName){     

        StringBuffer needs = new StringBuffer();

        try{
            String query = "SELECT * FROM " + tableName;        // Creating the query command
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);               // Executing the query

            int i = 0;
            while (results.next()){               // Iterating through results and extracting all values into client needs table
                this.dailyClientNeedsTable[i][0] = results.getString("ClientID");     
                this.dailyClientNeedsTable[i][1] = results.getString("Client");
                this.dailyClientNeedsTable[i][2] = results.getString("WholeGrains");
                this.dailyClientNeedsTable[i][3] = results.getString("FruitVeggies");
                this.dailyClientNeedsTable[i][4] = results.getString("Protein");
                this.dailyClientNeedsTable[i][5] = results.getString("Other");
                this.dailyClientNeedsTable[i][6] = results.getString("Calories");
                i++;
            }
        } 
        catch(SQLException e){
            e.printStackTrace();        // Error checking
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
            String query = "SELECT * FROM " + tableName;        // Creating the query command
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);               // Executing the query
            while (results.next()){                  // Loop to find the number of items in data base
                i++;
            }
        } 
        catch(SQLException e){
            e.printStackTrace();     // Error checking
        }           
        return i;
    }

    // Method to set avaliable food table
    public void setAvaliableFoodTable(String tableName, int total){     

        StringBuffer needs = new StringBuffer();
        this.avaliableFoodTable = new String [total][7]; // Creating the food table with correct size of items

        try{
            String query = "SELECT * FROM " + tableName;        // Creating the query command
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery(query);              // Executing the query

            int i = 0;
            while (results.next()){          // Iterating through results and extracting all values into food table
                this.avaliableFoodTable[i][0] = results.getString("ItemID");      
                this.avaliableFoodTable[i][1] = results.getString("Name");
                this.avaliableFoodTable[i][2] = results.getString("GrainContent");
                this.avaliableFoodTable[i][3] = results.getString("FVContent");
                this.avaliableFoodTable[i][4] = results.getString("ProContent");
                this.avaliableFoodTable[i][5] = results.getString("Other");
                this.avaliableFoodTable[i][6] = results.getString("Calories");
                i++;
            }
        } 
        catch(SQLException e){
            e.printStackTrace();        // Error checking
        }           
    }

    // Avaliable food table gettter
    public String[][] getAvaliableFoodTable(){
        return this.avaliableFoodTable;
    }

    // Method to delete an Item from the database after it has been used in a hamper order
    public void delete(String ItemID){

        initializeConnection();             // Initailizing database connection

        try {
            String query = "DELETE FROM AVAILABLE_FOOD WHERE ItemID = ?"; // Creating the query command
            PreparedStatement myStmt = dbConnect.prepareStatement(query); // Executing the query

            myStmt.setString(1, ItemID);
                        
            int rowCount = myStmt.executeUpdate();   // Excuting the deletion
            
            myStmt.close();

        } catch (SQLException ex) {     
            ex.printStackTrace();       // Error checking
        }  

        close();    // Closing database connection         

    }    
    
    // Method to close database connection
    public void close() {
        try {
            results.close();     // Closing Connection
            dbConnect.close();   // Closing ResultSet
        } catch (SQLException e) {
            e.printStackTrace();    // Error checking
        }              
    } 
}
