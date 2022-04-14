

/**
@author Kolby Lalonde 
UCID: 30115568
@version 1.1 April, 13, 2022
@since 1.0 March, 13, 2022
**/

package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.*;

// javac -cp .:edu/ucalgary/ensf409/hamcrest-core-1.3.jar:edu/ucalgary/ensf409/junit-4.13.2.jar edu/ucalgary/ensf409/DataStorageTest.java
// java -cp .:edu/ucalgary/ensf409/hamcrest-core-1.3.jar:edu/ucalgary/ensf409/junit-4.13.2.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.DataStorageTest

// javac -cp .:edu/ucalgary/ensf409/junit-4.13.2.jar:edu/ucalgary/ensf409/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23 edu/ucalgary/ensf409/DataStorageTest.java
// java -cp .:edu/ucalgary/ensf409/junit-4.13.2.jar:edu/ucalgary/ensf409/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23 org.junit.runner.JUnitCore edu/ucalgary/ensf409/DataStorageTest

public class DataStorageTest {

    @Test
    public void testDataStorageConstructorValidInput() throws Exception {

        // Set exception to false
        boolean exceptionThrown = false;

        try{    
            //settup availible food.
            DataStorage data = new DataStorage("jdbc:mysql://localhost/FOOD_INVENTORY");
            data.initializeConnection();
            data.close();
        }
        catch(Exception e){
            exceptionThrown = true;
        }

        //Should not throw any exception
        assertEquals("DataStorage constructor failed to make connection to ", false, exceptionThrown);

    }

    @Test
    public void testDataStorageSettersGettersValidInput() throws Exception {

        // Set exception to false
        boolean exceptionThrown = false;

        try{    
            //settup availible food.
            DataStorage data = new DataStorage("jdbc:mysql://localhost/FOOD_INVENTORY");
            data.initializeConnection();
            data.setAvaliableFoodTable("AVAILABLE_FOOD", data.numberOfFoodItems("AVAILABLE_FOOD") );
            data.setDailyClientNeedsTable("DAILY_ClIENT_NEEDS");

            // Getting tables
            String [][] myFoods = data.getAvaliableFoodTable();
            String [][] myClientsNeeds = data.getDailyClientNeedsTable();
            data.close();
        }
        catch(Exception e){
            exceptionThrown = true;
        }

        //Should return filled string tables
        assertNotNull("DataStorage did not return a food table", myFoods);
        assertNotNull("DataStorage did not return a clients needs table", myClientsNeeds);

    }

}