/**
author: James Platt
version: 1.1, April 15th
since: 1.0, April 13th
*/
package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.*;

public class AvailibleFoodandItemTest {

    /*
    Test to see if AvailibleFood's constructor properly intializes the variable when given valid input,
    aswell as see if it properly creates a arrayList of items with the info given.
    */
    @Test
    public void testAvailibleFoodConstructorValidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "6";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
        testDataBase[0] = testItemInfo;

        //testing constructor now.
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        ArrayList<Item> testList = availibleFoodObject.returnList();
        //test if availibleFoodObject == null;
        assertNotNull("AvailibleFood constructor did not properly create an AvailibleFood object when given a valid input.", availibleFoodObject);
        assertNotNull("AvailibleFood did not return a valid arrayList", testList);
        assertEquals("The arrayList was not properly intialized", "banana", testList.get(0).getName());
    }

    /*
    test to see if AvailibleFood's constructor throws a IllegalArgumentException when given invalid input in the
    constructor. The constructor should not accept negative calorie values.
    */
    @Test
    public void testAvailibleFoodConstructorInvalidCalories(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "-2";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
        boolean exceptionThrown = false;
        //testing constructor now.
        try{
            AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        //test to see if AvailibleFoods threw an invalid input exception
        assertEquals("AvailibleFoods constructor did not throw an exception when given a negative value for grain calories", exceptionThrown, true);
    }

    /*
    test to see if AvailibleFood's constructor throws a IllegalArgumentException when given a invalid name in the constructor.
    The constructor should not accept a null value for name.
    */
    @Test
    public void testAvailibleFoodConstructorInvalidName(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = null;
        testItemInfo[2] = "6";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
        boolean exceptionThrown = false;
        //testing constructor now.
        try{
            AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        //test to see if AvailibleFoods threw an invalid input exception
        assertEquals("AvailibleFoods constructor did not throw an exception when given a null value for name.", exceptionThrown, true);
    }

    /*
    Test to see if a valid Item can be added to the AvailibleFood object, and then removed using the itemID.
    */
    @Test
    public void testAvailibleFoodAddItemValidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "0";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "6";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
        testDataBase[0] = testItemInfo;

        //create AvailibleFood object
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        
        //create valid food Item.
        Item expectedItem = new Item("strawberry", "1", 100,100,100,100,100);

        //test adding an object 
        
        availibleFoodObject.addItem(expectedItem);
        Item actualItem = availibleFoodObject.remove("1");
        //test if the objects have the same string id.
        boolean same = actualItem.getID().equals(expectedItem.getID());

        assertEquals("AvailibleFood did not properly add then remove the item with ID 1", true, same );
    }

    /*
    Test to see if AvailibleFoods will add a item, even if the item is not valid. should throw a IllegalArgumentException.
    */
    @Test 
    public void testAvailibileFoodAddItemInvalidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "6";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
        testDataBase[0] = testItemInfo;

        //create AvailibleFood object
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        
        //create valid food Item.
        Item testItem = null;
        boolean exceptionThrown = false;
        //test adding an null object 
        try{
            availibleFoodObject.addItem(testItem);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        //should throw illegal argument exception when given a null item to add.
        assertEquals("AvailabileFood.addItem did not throw an exception when given a null item.", exceptionThrown, true);
    }
    /*
    Test to see if AvailibleFood will remove the correct object using the .remove method, when given a vlaid ID.
    */
    @Test 
    public void testAvailibleFoodRemoveValidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "6";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
        testDataBase[0] = testItemInfo;

        //create AvailibleFood object
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        
        //test remove function here
        Item test = availibleFoodObject.remove("1");
        //test if the objects have the same string id.
        boolean same = test.getID().equals("1");

        //assertEquals("AvailibleFood did not remove and return the item with ID 1.", true, same );
        assertEquals("AvailibleFood.remove() did not remove the item with itemID 1.", true, same);
    }

    /*
    test to see how AvailibleFood reacts when trying to remove a Item with a ID that is not stored in the object.
    Should throw a IllegalArgumentException.
    */
    @Test 
    public void testAvailibleFoodRemoveInvalidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "6";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
        testDataBase[0] = testItemInfo;

        //create AvailibleFood object
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        
        //test remove function here
        boolean exceptionThrown = false;

        try{
            //try to remove an item with a negative item id
            availibleFoodObject.remove("-25");
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertEquals("AvailibleFood.remove did not throw an error when given a itemID that dosen't match any item in AvailibleFood.", exceptionThrown, true);
    }
    /*
    test to see if AvailibleFood properly returns a copy of its Arraylist of Items.
    */
    @Test 
    public void testAvailibleFoodReturnList(){
         //create valid dataTable to test with.
         String[][] testDataBase =  new String[1][];
         String[] testItemInfo = new String[7];
         testItemInfo[0] = "1";
         testItemInfo[1] = "banana";
         testItemInfo[2] = "6";
         testItemInfo[3] = "6";
         testItemInfo[4] = "6";
         testItemInfo[5] = "6";
         testItemInfo[6] = "6";
         testDataBase[0] = testItemInfo;
 
         //create AvailibleFood object
         AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);

         //try returning the arrayList from AvailibleFood.
         ArrayList<Item> testList = availibleFoodObject.returnList();
         //temp item equal to the first item in the array. Should have id of 1.
         Item temp = testList.get(0);

         assertEquals("AvailibleFood.retrunList did not return a list identical to what is stored in AvailibleFood", temp.getID(), "1");
    }
    /*
    Test to make sure that Item's constructor properly sets all member variables when constructed using valid data.
    */
    @Test 
    public void testItemConstructorValidInput(){
        //expected values used to test constructor.
        int expectedGrain = 100;
        int expectedFruit = 100;
        int expectedProtein = 100;
        int expectedOther = 100;
        int expectedCalories = 100;
        String expectedName = "banana";
        String expectedID = "1";

        //creating an item object.
        Item testItem = new Item(expectedName, expectedID, expectedGrain, expectedFruit, expectedProtein,expectedOther,expectedCalories);

        //getting actual values.
        int actualGrain = testItem.getGrainContent();
        int actualFruit = testItem.getFruitContent();
        int actualProtein = testItem.getProteinContent();
        int actualOther = testItem.getOtherContent();
        int actualCalories = testItem.getCalories();
        String acutalName = testItem.getName();
        String actualID = testItem.getID();

        //compare expected values to actual values
        assertEquals("Item.getGrainContent did not return the correct value, which should have been 100", expectedGrain, actualGrain);
        assertEquals("Item.getFruitContent did not return the correct value, which should have been 100", expectedFruit, actualFruit);
        assertEquals("Item.getProteinContent did not return the correct value, which should have been 100", expectedProtein, actualProtein);
        assertEquals("Item.getOther did not return the correct value, which should have been 100", expectedOther, actualOther);
        assertEquals("Item.getCalories did not return the correct value, which should have been 100", expectedCalories, actualCalories);
        assertEquals("Item.getName did not return the correct value, which should have been banna", expectedName, acutalName);
        assertEquals("Item.getID did not return the correct value, which should have been 1", expectedID, actualID);
    }
    /*
    Test to see if Item throws a IllegalArgumentException when given a negative value for one of the calories, and if it throws a 
    exception when given null for the name of the item. IllegalArgumentExceptions should be thrown in these cases.
    */
    @Test 
    public void testItemConstructorInvalidInput(){
        //expected values used to test constructor.
        int expectedGrain = 100;
        int expectedFruit = 100;
        int expectedProtein = -100;
        int expectedOther = 100;
        int expectedCalories = 100;
        String expectedName = "banana";
        String expectedID = "1";
        boolean exceptionThrownINT = false;
        boolean exceptionThrownSTRING = false;
        //try to create an Item object with an illegal Protein value.
        try{   
            Item testItem = new Item(expectedName, expectedID, expectedGrain, expectedFruit, expectedProtein,expectedOther,expectedCalories);
        }
        catch(IllegalArgumentException e){
            exceptionThrownINT = true;
        }
        //try to create an item object with an ivalid name
        try{   
            Item testItem = new Item(null, expectedID, expectedGrain, expectedFruit, expectedProtein,expectedOther,expectedCalories);
        }
        catch(IllegalArgumentException e){
            exceptionThrownSTRING = true;
        }
        //check if right exceptions were thrown.
        assertEquals("Item constructor did not Throw an exception when given a negative protein value.", exceptionThrownINT, true);
        assertEquals("Item constructor did not Throw an exception when given a null String for name", exceptionThrownSTRING, true);
    }

    /*
    Test to see that Item's getters return the correct values for a Item intialized good data.
    */
    @Test 
    public void testItemGettersValidInput(){
        //expected values used to test constructor.
        int expectedGrain = 100;
        int expectedFruit = 100;
        int expectedProtein = 100;
        int expectedOther = 100;
        int expectedCalories = 100;
        String expectedName = "banana";
        String expectedID = "1";

        //creating an item object.
        Item testItem = new Item("banana", "1", 100, 100, 100,100,100);

        //getting actual values.
        int actualGrain = testItem.getGrainContent();
        int actualFruit = testItem.getFruitContent();
        int actualProtein = testItem.getProteinContent();
        int actualOther = testItem.getOtherContent();
        int actualCalories = testItem.getCalories();
        String acutalName = testItem.getName();
        String actualID = testItem.getID();

        //compare expected values to actual values
        assertEquals("Item.getGrainContent did not return the correct value, which should have been 100", expectedGrain, actualGrain);
        assertEquals("Item.getFruitContent did not return the correct value, which should have been 100", expectedFruit, actualFruit);
        assertEquals("Item.getProteinContent did not return the correct value, which should have been 100", expectedProtein, actualProtein);
        assertEquals("Item.getOther did not return the correct value, which should have been 100", expectedOther, actualOther);
        assertEquals("Item.getCalories did not return the correct value, which should have been 100", expectedCalories, actualCalories);
        assertEquals("Item.getName did not return the correct value, which should have been banana", expectedName, acutalName);
        assertEquals("Item.getID did not return the correct value, which should have been 1", expectedID, actualID);
    }
}
