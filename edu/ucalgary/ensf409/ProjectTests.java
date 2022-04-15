/**
@author Kolby Lalonde, James Platt, Carlos Morera Pinilla, Jacob Adeyemo
@version 1.3.1 April, 15, 2022
@since 1.0 March, 13, 2022
**/

/*
NOTE: Invalid input is handled through the GUI, and as such is not explicitly tested in this file.
*/

package edu.ucalgary.ensf409;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.*;

public class ProjectTests {
    

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
	
    //carlos's tests
/**Tests the HamperList Constructor which should create the ArrayList of Hampers
     * and the hamperCount property correctly.
     */
    @Test
    public void testHamperListConstructor() throws Exception
    {
        //Create HamperList object.
        HamperList hL = new HamperList();
        assertNotNull("HamperList Constructor did not create the array list and the hamperCount fields when called", hL);
    }

    /** Tests the getHamperCount method to see if it returns the expected
     * value of the ArrayList field of the HamperList class created in it's Constructor.
     */
    @Test
    public void testGetHamperCount() throws Exception
    {
        HamperList hl = new HamperList();
        //Add some elements to the Hamper.
        int[] a1 = {1, 1, 1, 1};
        int[] a2 = {1, 2, 1, 2};
        
        String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2500" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1400" } };
        AdultMale aM = new AdultMale(dailyNeeds);
        AdultFemale aF = new AdultFemale(dailyNeeds);
        ChildOver8 cO8 = new ChildOver8(dailyNeeds);
        ChildUnder8 cU8 = new ChildUnder8(dailyNeeds);

        Hamper h1 = new Hamper(a1, aM, aF, cO8, cU8);
        Hamper h2 = new Hamper(a2, aM, aF, cO8, cU8);

        hl.addToHamper(h1);
        hl.addToHamper(h2);
        
        int expected = 2;
        int actual = hl.getHamperCount();
        assertEquals("The actual and expected values for testTakeFromHamper do not match", expected, actual);
    }
    /**Tests the takeFromHamper method which should remove a Hamper from the ArrayList
     * of Hampers field.
     */
    @Test
    public void testTakeFromHamper() throws Exception
    {
        HamperList hl = new HamperList();
        //Add some elements to the Hamper.
        int[] a1 = {1, 1, 1, 1};
        int[] a2 = {1, 2, 1, 2};
        
        String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2500" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1400" } };
        AdultMale aM = new AdultMale(dailyNeeds);
        AdultFemale aF = new AdultFemale(dailyNeeds);
        ChildOver8 cO8 = new ChildOver8(dailyNeeds);
        ChildUnder8 cU8 = new ChildUnder8(dailyNeeds);

        Hamper h1 = new Hamper(a1, aM, aF, cO8, cU8);
        Hamper h2 = new Hamper(a2, aM, aF, cO8, cU8);

        hl.addToHamper(h1);
        hl.addToHamper(h2);
        hl.takeFromHamper(h1);

        int expected = 1;
        int actual = hl.getHamperCount();
        assertEquals("The actual and expected values for testTakeFromHamper do not match", expected, actual);
    }
/**Tests the clearHamperArray method which should clear the entire arrayList of Hampers
 * resetting the count to 0.
 */
    @Test
    public void testClearHamperArray() throws Exception
    {
        HamperList hl = new HamperList();
        //Add some elements to the Hamper.
        int[] a1 = {1, 1, 1, 1};
        int[] a2 = {1, 2, 1, 2};
        
        String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2500" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1400" } };
        AdultMale aM = new AdultMale(dailyNeeds);
        AdultFemale aF = new AdultFemale(dailyNeeds);
        ChildOver8 cO8 = new ChildOver8(dailyNeeds);
        ChildUnder8 cU8 = new ChildUnder8(dailyNeeds);

        Hamper h1 = new Hamper(a1, aM, aF, cO8, cU8);
        Hamper h2 = new Hamper(a2, aM, aF, cO8, cU8);

        hl.addToHamper(h1);
        hl.addToHamper(h2);
        hl.clearHamperArray();

        int expected = 0;
        int actual = hl.getHamperCount();
        assertEquals("The actual and expected values for testTakeFromHamper do not match", expected, actual);
    }
    /**Tests to see if the shortages String array has been created. */
    @Test 
    public void testReturnShortages() throws Exception
    {
        HamperList hl = new HamperList();
        
        assertNull("returnShortages() method did not return an empty array.", hl.returnShortages());
    }
    /**Tests to see if it returns -1 for the returnNumShortages() when created in the HamperList
     * Constructor.
    */
    @Test 
    public void testReturnNumShortages() throws Exception
    {
        HamperList hl = new HamperList();
        int expected = -1;
        int actual = hl.returnNumShortages();
        assertEquals("returnNumShorages() did not return the correct value when created", expected, actual);
    }
    /**tests to see if the calculateOrder throws the UnavailableResourcesException
     * when there are no more resources available.
     */
    @Test 
    public void testUnavailableResourcesException() throws Exception
    {
        HamperList hl = new HamperList();
        int[] a1 = {1, 0, 0, 0};
        
        String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "2500" },
				{ "2", "Adult Female", "16", "28", "26", "30", "2000" },
				{ "3", "Child over 8", "21", "33", "31", "15", "2200" },
				{ "4", "Child under 8", "21", "33", "31", "15", "1400" } };
        AdultMale aM = new AdultMale(dailyNeeds);
        AdultFemale aF = new AdultFemale(dailyNeeds);
        ChildOver8 cO8 = new ChildOver8(dailyNeeds);
        ChildUnder8 cU8 = new ChildUnder8(dailyNeeds);
        Hamper h1 = new Hamper(a1, aM, aF, cO8, cU8);
        hl.addToHamper(h1);
        
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "25";
        testItemInfo[3] = "25";
        testItemInfo[4] = "25";
        testItemInfo[5] = "25";
        testItemInfo[6] = "100";
        testDataBase[0] = testItemInfo;
        boolean exceptionThrown = false;
        AvailibleFood aFood = new AvailibleFood(testDataBase);
        try
        {
            hl.calculateOrder(aFood);
        }
        catch(UnavailableResourcesException e)
        {
            exceptionThrown = true;
        }
        assertEquals("calculateOrder did not throw the UnavaiableResourcesException when insufficient resources were given", exceptionThrown, true);
    }
    /**
     * test to see if the HamperList.calculateOrder() determines the optimal Hampers correctly.
     */
    @Test 
    public void testHamperListCalculateOrder() throws Exception
    {
        HamperList hl = new HamperList();
        int[] a1 = {1, 0, 0, 0};
        int[] a2 = {0, 1, 0, 0};
        String[][] dailyNeeds = { { "1", "Adult Male", "16", "28", "26", "30", "300" },
				{ "2", "Adult Female", "16", "28", "26", "30", "200" },
				{ "3", "Child over 8", "21", "33", "31", "15", "100" },
				{ "4", "Child under 8", "21", "33", "31", "15", "80" } };
        AdultMale aM = new AdultMale(dailyNeeds);
        AdultFemale aF = new AdultFemale(dailyNeeds);
        ChildOver8 cO8 = new ChildOver8(dailyNeeds);
        ChildUnder8 cU8 = new ChildUnder8(dailyNeeds);
        Hamper h1 = new Hamper(a1, aM, aF, cO8, cU8);
        Hamper h2 = new Hamper(a2, aM, aF, cO8, cU8);

        hl.addToHamper(h1);
        hl.addToHamper(h2);
        
        String[][] testDataBase =  new String[1][];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "1";
        testItemInfo[1] = "banana";
        testItemInfo[2] = "16";
        testItemInfo[3] = "28";
        testItemInfo[4] = "26";
        testItemInfo[5] = "30";
        testItemInfo[6] = "2150";
        testDataBase[0] = testItemInfo;

        AvailibleFood aFood = new AvailibleFood(testDataBase);
        aFood.addItem(new Item("Strawberry", "2", 16, 28, 26, 30, 1450));
        aFood.addItem(new Item("Blueberry", "3", 16, 28, 26, 30, 1750));
        aFood.addItem(new Item("Blackberry", "4", 16, 28, 26, 30, 2500));
        aFood.addItem(new Item("RedBerry", "5", 16, 28, 26, 30, 1100));
        try
        {
            hl.calculateOrder(aFood);
        }
        catch(UnavailableResourcesException e)
        {
        }
        assertEquals("calculateOrder did not return the most optimal list of Items for hamper 1", h1.getItems()[0].getID(), "1");
        assertEquals("calculateOrder did not return the most optimal list of Items for hamper 2", h2.getItems()[0].getID(), "2");
    }

//jacobs tests

	// Testing AdultMale constructor when given dailyNeeds array with valid value
	@Test
	public void testAdultMaleConstructorValidInput() throws Exception {

		String[][] dailyNeeds = { { "1", "Adult Male", "101", "102", "103", "104", "105" },
				{ "2", "Adult Female", "201", "202", "203", "204", "205" },
				{ "3", "Child over 8", "301", "302", "303", "304", "305" },
				{ "4", "Child under 8", "401", "402", "403", "404", "405" } };

		AdultMale AdultMale = new AdultMale(dailyNeeds);

		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 101,
				AdultMale.getWholeGrains());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 102,
				AdultMale.getFruitsVeggies());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 103, AdultMale.getProtein());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 104, AdultMale.getOther());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 105,
				AdultMale.getCalories());

	}

	// Testing AdultMale constructor when given dailyNeeds array with negative
	// invalid value
	@Test
	public void testAdultMaleConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "1", "Adult Male", "-101", "-102", "-103", "-104", "-105" },
				{ "2", "Adult Female", "201", "202", "203", "204", "205" },
				{ "3", "Child over 8", "301", "302", "303", "304", "305" },
				{ "4", "Child under 8", "401", "402", "403", "404", "405" } };

		assertThrows("AdultMale constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new AdultMale(dailyNeeds));
	}

	// Testing AdultMale constructor when given dailyNeeds array with negative
	// invalid value
	@Test
	public void testAdultMaleConstructorNullInput() throws Exception {
		String[][] dailyNeeds = null;
		assertThrows("AdultMale constructor when given dailyNeeds array with negative invalid value",
				NullPointerException.class, () -> new AdultMale(dailyNeeds));
	}

	// Testing AdultFemale constructor when given dailyNeeds array with valid value
	@Test
	public void testAdultFemaleConstructorValidInput() throws Exception {

		String[][] dailyNeeds = { { "1", "Adult Male", "432", "124", "321", "221", "121" },
				{ "2", "Adult Female", "321", "542", "123", "453", "321" },
				{ "3", "Child over 8", "456", "123", "345", "213", "865" },
				{ "4", "Child under 8", "766", "231", "655", "546", "432" } };

		AdultFemale adultFemale = new AdultFemale(dailyNeeds);

		assertEquals("AdultFemale constructor when given dailyNeeds array with valid value", 321,
				adultFemale.getWholeGrains());
		assertEquals("AdultFemale constructor when given dailyNeeds array with valid value", 542,
				adultFemale.getFruitsVeggies());
		assertEquals("AdultFemale constructor when given dailyNeeds array with valid value", 123,
				adultFemale.getProtein());
		assertEquals("AdultFemale constructor when given dailyNeeds array with valid value", 453,
				adultFemale.getOther());
		assertEquals("AdultFemale constructor when given dailyNeeds array with valid value", 321,
				adultFemale.getCalories());

	}

	// Testing AdultFemale constructor when given dailyNeeds array with negative
	// invalid value
	@Test
	public void testAdultFemaleConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "1", "Adult Male", "432", "124", "321", "221", "121" },
				{ "2", "Adult Female", "-321", "-542", "123", "453", "-321" },
				{ "3", "Child over 8", "456", "123", "345", "213", "865" },
				{ "4", "Child under 8", "766", "231", "655", "546", "432" } };

		assertThrows("AdultFemale constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new AdultFemale(dailyNeeds));

	}

	// Testing AdultFemale constructor when given dailyNeeds array with negative
	// invalid value
	@Test
	public void testAdultFemaleConstructorNullInput() throws NullPointerException, Exception {
		String[][] dailyNeeds = null;
		assertThrows("AdultFemale constructor when given dailyNeeds array with negative invalid value",
				NullPointerException.class, () -> new AdultFemale(dailyNeeds));
	}
	
    
	// Testing ChildOver8 constructor when given dailyNeeds array with valid value
	@Test
	public void testChildOver8ConstructorValidInput() throws Exception {

		String[][] dailyNeeds = { { "1", "Adult Male", "101", "102", "103", "104", "105" },
				{ "2", "Adult Female", "201", "202", "203", "204", "205" },
				{ "3", "Child over 8", "301", "302", "303", "304", "305" },
				{ "4", "Child under 8", "401", "402", "403", "404", "405" } };

		ChildOver8 ChildOver8 = new ChildOver8(dailyNeeds);

		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 301,
				ChildOver8.getWholeGrains());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 302,
				ChildOver8.getFruitsVeggies());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 303,
				ChildOver8.getProtein());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 304, ChildOver8.getOther());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 305,
				ChildOver8.getCalories());

	}

	// Testing ChildOver8 constructor when given dailyNeeds array with negative
	// invalid value
	@Test
	public void testChildOver8ConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "1", "Adult Male", "101", "102", "103", "104", "105" },
				{ "2", "Adult Female", "201", "202", "203", "204", "205" },
				{ "3", "Child over 8", "301", "-302", "303", "304", "-305" },
				{ "4", "Child under 8", "401", "402", "403", "404", "405" } };

		assertThrows("ChildOver8 constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new ChildOver8(dailyNeeds));
	}

	
	// Testing ChildUnder8 constructor when given dailyNeeds array with negative
	// invalid value
	@Test
	public void testChildUnder8ConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "1", "Adult Male", "101", "102", "103", "104", "105" },
				{ "2", "Adult Female", "201", "202", "203", "204", "205" },
				{ "3", "Child over 8", "301", "302", "303", "304", "305" },
				{ "4", "Child under 8", "-401", "402", "403", "404", "405" } };

		assertThrows("ChildUnder8 constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new ChildUnder8(dailyNeeds));
	}

	// Testing ChildUnder8 constructor when given dailyNeeds array with negative
	// invalid value
	@Test
	public void testChildUnder8ConstructorNullInput() throws Exception {
		String[][] dailyNeeds = null;
		assertThrows("ChildUnder8 constructor when given dailyNeeds array with negative invalid value",
				NullPointerException.class, () -> new ChildUnder8(dailyNeeds));
	}

	// Testing ClientDailyNeeds constructor when given dailyNeeds array with valid
	// value
	@Test
	public void testClientDailyNeedsConstructorValidInput() throws Exception {

		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, 104, 105);

		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 101,
				clientDailyNeeds.getWholeGrains());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 102,
				clientDailyNeeds.getFruitsVeggies());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 103,
				clientDailyNeeds.getProtein());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 104,
				clientDailyNeeds.getOther());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 105,
				clientDailyNeeds.getCalories());

	}

	// Testing ClientDailyNeeds constructor when given dailyNeeds array with
	// negative invalid value
	@Test
	public void testClientDailyNeedsConstructorInvalidInput() throws Exception {

		assertThrows("ClientDailyNeeds constructor when given dailyNeeds array with negative invalid value",
				Exception.class, () -> new ClientDailyNeeds(-101, 102, 103, 104, 105));
	}

	// Testing getWholeGrains method when given valid WholeGrains value
	@Test
	public void testGetWholeGrainsValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, 104, 105);

		assertEquals("getWholeGrains method when given valid WholeGrains value", 101,
				clientDailyNeeds.getWholeGrains());
	}

	// Testing getWholeGrains method when given invalid WholeGrains value
	@Test
	public void testGetWholeGrainsInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = null;
		try {
			clientDailyNeeds = new ClientDailyNeeds(-101, 102, 103, 104, 105);
			assertEquals("getWholeGrains method when given invalid WholeGrains value", 0,
					clientDailyNeeds.getWholeGrains());
		} catch (IllegalArgumentException ex) {
			assertEquals("ClientDailyNeeds Constructor recieved a negative value for one of it's arguments!",
					ex.getMessage());
		}

	}

	// Testing getFruitsVeggies method when given valid FruitsVeggies value
	@Test
	public void testGetFruitsVeggiesValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, 104, 105);

		assertEquals("getFruitsVeggies method when given valid FruitsVeggies value", 102,
				clientDailyNeeds.getFruitsVeggies());
	}

	// Testing getFruitsVeggies method when given invalid FruitsVeggies value
	@Test
	public void testGetFruitsVeggiesInvalidInput() throws Exception {

		ClientDailyNeeds clientDailyNeeds = null;
		try {
			clientDailyNeeds = new ClientDailyNeeds(101, -102, 103, 104, 105);
			assertEquals("getFruitsVeggies method when given invalid FruitsVeggies value", 0,
					clientDailyNeeds.getFruitsVeggies());
		} catch (IllegalArgumentException ex) {
			assertEquals("ClientDailyNeeds Constructor recieved a negative value for one of it's arguments!",
					ex.getMessage());
		}

	}

	// Testing getProtein method when given valid Protein value
	@Test
	public void testGetProteinValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, 104, 105);

		assertEquals("getProtein method when given valid Protein value", 103, clientDailyNeeds.getProtein());
	}

	// Testing getProtein method when given invalid Protein value
	@Test
	public void testGetProteinInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = null;
		try {
			clientDailyNeeds = new ClientDailyNeeds(101, 102, -103, 104, 105);
			assertEquals("getProtein method when given invalid Protein value", 0, clientDailyNeeds.getProtein());
		} catch (IllegalArgumentException ex) {
			assertEquals("ClientDailyNeeds Constructor recieved a negative value for one of it's arguments!",
					ex.getMessage());
		}
	}

	// Testing getOther method when given valid Other value
	@Test
	public void testGetOtherValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, 104, 105);

		assertEquals("getOther method when given valid Other value", 104, clientDailyNeeds.getOther());
	}

	// Testing getOther method when given invalid Other value
	@Test
	public void testGetOtherInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = null;
		try {
			clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, -104, 105);
			assertEquals("getOther method when given invalid Other value", 0, clientDailyNeeds.getOther());
		} catch (IllegalArgumentException ex) {
			assertEquals("ClientDailyNeeds Constructor recieved a negative value for one of it's arguments!",
					ex.getMessage());
		}
	}

	// Testing getCalories method when given valid Calories value
	@Test
	public void testGetCaloriesValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = null;
		try {
			clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, 104, 105);
			assertEquals("getCalories method when given valid Calories value", 105, clientDailyNeeds.getCalories());
		} catch (IllegalArgumentException ex) {
			assertEquals("ClientDailyNeeds Constructor recieved a negative value for one of it's arguments!",
					ex.getMessage());
		}
	}

	// Testing getCalories method when given invalid Calories value
	@Test
	public void testGetCaloriesInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = null;
		try {
			clientDailyNeeds = new ClientDailyNeeds(101, 102, 103, 104, -105);
			assertEquals("getCalories method when given invalid Calories value", 0, clientDailyNeeds.getCalories());
		} catch (IllegalArgumentException ex) {
			assertEquals("ClientDailyNeeds Constructor recieved a negative value for one of it's arguments!",
					ex.getMessage());
		}
	}

	// Testing OrderForm Constructor
	@Test
	public void testOrderFormConstructor() {
		ArrayList<Hamper> REPORT = new ArrayList<>();

		try {
			new OrderForm(REPORT);
		} catch (Exception e) {
			fail(e.getMessage()); // if it's failing that means constructor is not working correctly.
		}
	}

	
    /// KOLBY's Tests 

    /*
    Test to see if hamper class constructor is work as expected with valid input
    */
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

    /*
    Test for hamper class method calculateOptimal Hamper returns correct combination of items with easy example data
    */
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

    /*
    Test for hamper class method calculateOptimal Hamper returns correct combination of items with hard example data
    */
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


    /*
    Test for hamper class method calculateOptimal Hamper returns correct shortages when give insuffiecent food totals
    */
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
	
    //DataStorage Tests

    /*
    Testing Data storage constructor has no issues
    */
    @Test
    public void testDataStorageConstructorValidInput() throws Exception {

        // Set exception to false
        boolean exceptionThrown = false;

        try{    
            //settup availible food.
            DataStorage data = new DataStorage("jdbc:mysql://localhost/FOOD_INVENTORY");
            data.initializeConnection();
            data.setAvaliableFoodTable("AVAILABLE_FOOD", data.numberOfFoodItems("AVAILABLE_FOOD") );
            data.setDailyClientNeedsTable("DAILY_ClIENT_NEEDS");
            data.close();
        }
        catch(Exception e){
            exceptionThrown = true;
        }

        //Should not throw any exception
        assertEquals("DataStorage constructor failed to make connection to ", false, exceptionThrown);

    }

    /*
    Testing Data storage getters and setters work as expected
    */
    @Test
    public void testDataStorageSettersGettersValidInput() throws Exception {

        // Set exception to false
        boolean exceptionThrown = false;
        String [][] myFoods = null;
        String [][] myClientsNeeds = null;
        try{    
            //settup availible food.
            DataStorage data = new DataStorage("jdbc:mysql://localhost/FOOD_INVENTORY");
            data.initializeConnection();
            data.setAvaliableFoodTable("AVAILABLE_FOOD", data.numberOfFoodItems("AVAILABLE_FOOD") );
            data.setDailyClientNeedsTable("DAILY_ClIENT_NEEDS");

            // Getting tables
            myFoods = data.getAvaliableFoodTable();
            myClientsNeeds = data.getDailyClientNeedsTable();
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
