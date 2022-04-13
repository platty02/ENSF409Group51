

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

// javac -cp .:edu/ucalgary/ensf409/hamcrest-core-1.3.jar:edu/ucalgary/ensf409/junit-4.13.2.jar edu/ucalgary/ensf409/HamperTest.java
// java -cp .:edu/ucalgary/ensf409/hamcrest-core-1.3.jar:edu/ucalgary/ensf409/junit-4.13.2.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.HamperTest


public class HamperTest {
    
    @Test
	public void testHamperConstructorValidInput() throws Exception {

        // Creating an example Client Daily Needs Table
		String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2500" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1400" } };

        // Creating an example client amount call by user
        int[] clientAmounts = {1,2,3,0};

    
        // Creating Client Type Objects
		AdultMale adultMale = new AdultMale(dailyNeeds);
        AdultFemale adultFemale = new AdultFemale(dailyNeeds);
        ChildOver8 childOver8 = new ChildOver8(dailyNeeds);
        ChildUnder8 childUnder8 = new ChildUnder8(dailyNeeds);

        // Creating Hamper Object
        Hamper myHamper = new Hamper(clientAmounts, adultMale, adultFemale, childOver8, childUnder8);


        // Testing Hamper Constructor returns a hamper object when given valid data
		assertNotNull("Hamper constructor did not properly create a Hamper object when given a valid input.", myHamper);
        
        // Testing Hamper Constructor correctly set each the amount of each type of client with valid data
        assertEquals("The Hamper did not return correct number of Adult Males", 1, myHamper.getNumOfClientsAt(0));
        assertEquals("The Hamper did not return correct number of Adult Females", 2, myHamper.getNumOfClientsAt(1));
        assertEquals("The Hamper did not return correct number of Over 8 Child", 3, myHamper.getNumOfClientsAt(2));
        assertEquals("The Hamper did not return correct number of Under 8 Child", 0, myHamper.getNumOfClientsAt(3));

	}
    
    @Test
	public void testHamperMethodCalculateOptimalHamperValidInputNoDecimals() throws Exception {

        // Creating an example Client Daily Needs Table
		String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2500" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1400" } };

        String[][] availableFood = { { "1", "Strawberry", "20", "30", "30", "20", "12000" }, // G = 2400 FV = 3600 P = 3600 O = 2400
				{ "2", "Beef Burgers", "0", "10", "80", "10", "20000" },                     // G = 0 FV = 2000 P = 16000 O = 2000
				{ "3", "Pizza", "25", "25", "25", "25", "28000" },                           // G = 7000 FV = 7000 P = 7000 O = 7000
				{ "4", "Whole Wheat Bread", "80", "0", "10", "10", "28000" } };              // G = 22400 FV = 0 P = 2800 O = 2800

         // Creating an example client amount call by user
        int[] clientAmounts = {1,0,1,0};

        // Note that this will sum to 6034 grains, 9982 FV, 9324 protien, 7560 other (The Optimal combo must be Items 1 and 3)

        // Creating Client Type Objects
		AdultMale adultMale = new AdultMale(dailyNeeds);
        AdultFemale adultFemale = new AdultFemale(dailyNeeds);
        ChildOver8 childOver8 = new ChildOver8(dailyNeeds);
        ChildUnder8 childUnder8 = new ChildUnder8(dailyNeeds);

        // Creating Hamper Object
        Hamper myHamper = new Hamper(clientAmounts, adultMale, adultFemale, childOver8, childUnder8);

        // Creating AvailibleFood Object
        AvailibleFood availibleFoodObject = new AvailibleFood(availableFood);

        // Call calculateOptimalHamperMethod
        String[] optimal = myHamper.calculateOptimalHamper(availibleFoodObject);

        // Test for expected return
        assertEquals("The Hamper did not return the optimal combination as item 1 is missing", "1", optimal[0]); // Contains Item ID 1 at first index
        assertEquals("The Hamper did not return the optimal combination as item 3 is missing", "3", optimal[1]); // Contains Item ID 3 at second index
        assertEquals("The Hamper did not return the optimal combination as inccorect number of items", 2, optimal.length); // Contians on two items

    }

    @Test
	public void testHamperMethodCalculateOptimalHamperValidInputWithDecimals() throws Exception {

        // Creating an example Client Daily Needs Table
		String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2505" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1404" } };

        String[][] availableFood = { { "1", "Strawberry", "20", "30", "30", "20", "12001" }, // G = 2400.2 FV = 3600.3 P = 3600.3 O = 2400.2
				{ "2", "Beef Burgers", "0", "10", "80", "10", "20000" },                     // G = 0 FV = 2000 P = 16000 O = 2000
                { "3", "Tacos", "25", "25", "25", "25", "18210" },                           // G = 4552.5 FV = 4552.5  P = 4552.5  O = 4552.5
				{ "4", "Pizza", "25", "25", "25", "25", "18213" },                           // G = 4553.25 FV = 4553.25  P = 4553.25  O = 4552.25 
                { "5", "Apples", "25", "25", "25", "25", "18218" },                          // G = 4554.5 FV = 4554.5  P = 4554.5  O = 4554.5 
                { "6", "Fish n Chips", "25", "25", "25", "25", "18219" },                    // G = 4554.75 FV = 4554.75  P = 4554.75  O = 4554.75 
				{ "7", "Whole Wheat Bread", "80", "0", "10", "10", "28000" } };              // G = 22400 FV = 0 P = 2800 O = 2800

         // Creating an example client amount call by user
        int[] clientAmounts = {1,0,0,1};

        // Note that this will sum to 4869.48 grains, 8153.04 FV, 7605.78 protien, 6734.7 other (The Optimal combo must be Items 1 and 5)

        // Creating Client Type Objects
		AdultMale adultMale = new AdultMale(dailyNeeds);
        AdultFemale adultFemale = new AdultFemale(dailyNeeds);
        ChildOver8 childOver8 = new ChildOver8(dailyNeeds);
        ChildUnder8 childUnder8 = new ChildUnder8(dailyNeeds);

        // Creating Hamper Object
        Hamper myHamper = new Hamper(clientAmounts, adultMale, adultFemale, childOver8, childUnder8);

        // Creating AvailibleFood Object
        AvailibleFood availibleFoodObject = new AvailibleFood(availableFood);

        // Call calculateOptimalHamperMethod
        String[] optimal = myHamper.calculateOptimalHamper(availibleFoodObject);

        // Test for expected return
        assertEquals("The Hamper did not return the optimal combination as item 1 is missing", "1", optimal[0]); // Contains Item ID 1 at first index
        assertEquals("The Hamper did not return the optimal combination as item 3 is missing", "4", optimal[1]); // Contains Item ID 4 at second index
        assertEquals("The Hamper did not return the optimal combination as inccorect number of items", 2, optimal.length); // Contians on two items

    }

    @Test
	public void testHamperMethodCalculateOptimalHamperWithInsignificantFood() throws Exception {

        // Creating an example Client Daily Needs Table
		String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2500" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1400" } };

        String[][] availableFood = { { "1", "Strawberry", "20", "30", "30", "20", "12000" }, // G = 2400 FV = 3600 P = 3600 O = 2400
				{ "2", "Beef Burgers", "0", "10", "80", "10", "20000" },                     // G = 0 FV = 2000 P = 16000 O = 2000
				{ "3", "Pizza", "25", "25", "25", "25", "28000" },                           // G = 7000 FV = 7000 P = 7000 O = 7000
				{ "4", "Whole Wheat Bread", "80", "0", "10", "10", "28000" } };              // G = 22400 FV = 0 P = 2800 O = 2800

         // Creating an example client amount call by user
        int[] clientAmounts = {1,5,1,0};

        // Note that this will sum to 17234 grains, 29582 FV, 27524 protien, 28560 other (Shortage FV = 16982, O = 14360 )

        // Creating Client Type Objects
		AdultMale adultMale = new AdultMale(dailyNeeds);
        AdultFemale adultFemale = new AdultFemale(dailyNeeds);
        ChildOver8 childOver8 = new ChildOver8(dailyNeeds);
        ChildUnder8 childUnder8 = new ChildUnder8(dailyNeeds);

        // Creating Hamper Object
        Hamper myHamper = new Hamper(clientAmounts, adultMale, adultFemale, childOver8, childUnder8);

        // Creating AvailibleFood Object
        AvailibleFood availibleFoodObject = new AvailibleFood(availableFood);

        // Call calculateOptimalHamperMethod
        String[] optimal = myHamper.calculateOptimalHamper(availibleFoodObject);

        // Test for expected return
        assertEquals("The Hamper did not indicate the database shortage", "SHORT", optimal[0]); // Contains Shortage indicator
        assertEquals("The Hamper indicated inccorrect shortage for grains", null, optimal[1]); // No shortage of grains
        assertEquals("The Hamper indicated inccorrect shortage for fruits and veggies", "16982", optimal[2]); // Shortage of fruits veggies
        assertEquals("The Hamper indicated inccorrect shortage for protien", null, optimal[3]); // No shortage of protien
        assertEquals("The Hamper indicated inccorrect shortage for other", "14360", optimal[4]); // Shortage of Other

    }

}