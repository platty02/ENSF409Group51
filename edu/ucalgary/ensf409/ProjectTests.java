package edu.ucalgary.ensf409;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class ProjectTests {
    
    @Test
    public void testAvailibleFoodConstructorValidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][7];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "banna";
        testItemInfo[1] = "0";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testDataBase[0] = testItemInfo;

        //testing constructor now.
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        ArrayList testList = availibleFoodObject.returnList();
        //test if availibleFoodObject == null;
        assertNotNull("AvailibleFood constructor did not properly create an AvailibleFood object when given a valid input.", availibleFoodObject);
        assertNotNull("AvailibleFood did not return a valid arrayList", testList);
        assertEquals("The arrayList was not properly intialized", "banna", testList.get(0).getName());
    }

    @Test
    public void testAvailibleFoodConstructorInvalidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][2];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "banna";
        testItemInfo[1] = "0";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        boolean exceptionThrown = false;
        //testing constructor now.
        try{
            AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        //test to see if AvailibleFoods threw an invalid input exception
        assertEquals("AvailibleFoods constructor did not throw an exception when given an invalid input.", exceptionThrown, true);
    }

    //need to discuss this one with the group.
    @Test
    public void testAvailibleFoodAddItemValidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][7];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "banna";
        testItemInfo[1] = "0";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testDataBase[0] = testItemInfo;

        //create AvailibleFood object
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        
        //create valid food Item.
        Item expectedItem = new Item("strawberry", "1", 100,100,100,100,100);

        //test adding an object 
        
        availibleFoodObject.addItem(testItem);
        Item actualItem = availibleFoodObject.remove("1");

        assertEquals("AvailibleFood did not remove and return the correct item.", expectedItem, actualItem);
    }

    //need to discuss this one with the group.
    @Test 
    public void testAvailibileFoodAddItemInvalidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][7];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "banna";
        testItemInfo[1] = "0";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
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

        assertEquals("AvailabileFood.addItem did not throw an exception when given a null item.", exceptionThrown, true);
    }

    //need to discuss with group.
    @Test 
    public void testAvailibleFoodRemoveValidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][7];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "banna";
        testItemInfo[1] = "0";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testDataBase[0] = testItemInfo;

        //create AvailibleFood object
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        
        //test remove function here
        Item test = availibleFoodObject.remove("0");

        asserNotEquals("AvailibleFood.remove() did not remove the first item", "0", test.getID());
    }
    // need to discuss with group
    @Test 
    public void testAvailibleFoodRemoveInvalidInput(){
        //create valid dataTable to test with.
        String[][] testDataBase =  new String[1][7];
        String[] testItemInfo = new String[7];
        testItemInfo[0] = "banna";
        testItemInfo[1] = "0";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testItemInfo[1] = "6";
        testDataBase[0] = testItemInfo;

        //create AvailibleFood object
        AvailibleFood availibleFoodObject = new AvailibleFood(testDataBase);
        
        //test remove function here
        boolean exceptionThrown = false;

        try{
            //try to remove an item with a negative item id
            availibleFoodObject.remove(-25);
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertEquals("AvailibleFood.remove did not throw an error when given a negative input.", exceptionThrown, true);
    }

    //begining tests on item class.

    //discuss with group, constructor for Item needs to be changed and two getters / setters need to be added.
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
        int actualOther = testItem.getOther();
        int actualCalories = testItem.getCalories();
        String acutalName = testItem.getName();
        String actualID = testItem.getID();

        //compare expected values to actual values
        AssertEquals("Item.getGrainContent did not return the correct value, which should have been 100", expectedGrain, actualGrain);
        AssertEquals("Item.getFruitContent did not return the correct value, which should have been 100", expectedFruit, actualFruit);
        AssertEquals("Item.getProteinContent did not return the correct value, which should have been 100", expectedProtein, actualProtein);
        AssertEquals("Item.getOther did not return the correct value, which should have been 100", expectedOther, actualOther);
        AssertEquals("Item.getCalories did not return the correct value, which should have been 100", expectedCalories, actualCalories);
        AssertEquals("Item.getName did not return the correct value, which should have been banna", expectedName, acutalName);
        AssertEquals("Item.getID did not return the correct value, which should have been 1", expectedID, actualID);
    }

    //discuss with group.
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
    //this test may be usless, because I think we can just get rid of the setters.
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
        int actualOther = testItem.getOther();
        int actualCalories = testItem.getCalories();
        String acutalName = testItem.getName();
        String actualID = testItem.getID();

        //compare expected values to actual values
        AssertEquals("Item.getGrainContent did not return the correct value, which should have been 100", expectedGrain, actualGrain);
        AssertEquals("Item.getFruitContent did not return the correct value, which should have been 100", expectedFruit, actualFruit);
        AssertEquals("Item.getProteinContent did not return the correct value, which should have been 100", expectedProtein, actualProtein);
        AssertEquals("Item.getOther did not return the correct value, which should have been 100", expectedOther, actualOther);
        AssertEquals("Item.getCalories did not return the correct value, which should have been 100", expectedCalories, actualCalories);
        AssertEquals("Item.getName did not return the correct value, which should have been banana", expectedName, acutalName);
        AssertEquals("Item.getID did not return the correct value, which should have been 1", expectedID, actualID);
    }

    //carlos's tests
        //Tests for object creation of valid input to the HamperList constructor
@Test
public void testHamperListConstructorValidInput()
{
    //Creating a HamperList object, which instantiates the number of hampers in the array:
    HamperList hampList = new HamperList(3);
    assertNotNull("HamperList constructor did not create an object when given a valid integer.", hampList);
}

//Tests for object creation of invalid input to the HamperList constructor
@Test
public void testHamperListConstructorInvalidInput()
{
    //Creating a HamperList object, which instantiates the number of hampers in the array:
    HamperList hampList = new HamperList(-6);
    assertNull("HamperList constructor did create an object when given an invalid integer.", hampList);
}

@Test
public void testSetHamperCountMethod()
{
    int expectedHamperCount = 5;
    HamperList hampList = new HamperList(expectedHamperCount);
    hampList.setHamperCount(expectedHamperCount);
    int actualHamperCount = hampList.getHamperCount();
    assertEquals("Method setHamperCount did not return the expected Hamper Count:", expectedHamperCount, actualHamperCount);
}

@Test
public void testTakeFromHamperMethodNotEmpty()
{
    HamperList hampList = new HamperList(3);
    Hamper hamp = new Hamper(1, 1, 1, 1);
    hampList.addToHamper(hamp);
    hampList.takeFromHamper(hamp);

    assertNotNull("takeFromHamper did not remove the hamper object specified when the hamperArray was not empty.", hamp);
}

@Test
public void testTakeFromHamperMethodEmpty()
{
    HamperList hampList = new HamperList(3);
    Hamper hamp = new Hamper(1, 1, 1, 1);
    hampList.takeFromHamper(hamp);

    assertNull("Method returned a hamper object from the arrayList despite it being empty:", hamp);
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

    // Hamper getter tests (5 total)
    @Test
    public void testGetGrainCalories(){

        //creating hamper with valid input
        Hamper myHamper = new Hamper(1,1,1,1);
        // get return value of method
        int grainCalories = myHamper.getGrainCalories();
        // Creating int with the expected return value
        int expectedGrainCalories = 500;
        assertEquals("Method getGrainCalories returned an unexpected value", expectedGrainCalories, grainCalories);

    }

    @Test
    public void testGetNetCalories(){

        //creating hamper with valid input
        Hamper myHamper = new Hamper(1,1,1,1);
        // get return value of method
        int netCalories = myHamper.getNetCalories();
        // Creating int with the expected return value
        int expectedNetCalories = 2000;
        assertEquals("Method getNetCalories returned an unexpected value", expectedNetCalories, netCalories);

    }

    @Test
    public void testGetFruitsVeggiesCalories(){

        //creating hamper with valid input
        Hamper myHamper = new Hamper(1,1,1,1);
        // get return value of method
        int fruitVeggiesCalories = myHamper.getFruitsVeggiesCalories();
        // Creating int with the expected return value
        int expectedFruitVeggiesCalories = 2000;
        assertEquals("Method getFruitVeggiesCalories returned an unexpected value", expectedFruitVeggiesCalories, fruitVeggiesCalories);

    }

    @Test
    public void testGetProtienCalories(){

        //creating hamper with valid input
        Hamper myHamper = new Hamper(1,1,1,1);
        // get return value of method
        int protienCalories = myHamper.getProtienCalories();
        // Creating int with the expected return value
        int expectedProtienCalories = 2000;
        assertEquals("Method getProtienCalories returned an unexpected value", expectedProtienCalories, protienCalories);

    }

    @Test
    public void testGetOtherCalories(){

        //creating hamper with valid input
        Hamper myHamper = new Hamper(1,1,1,1);
        // get return value of method
        int otherCalories = myHamper.getOtherCalories();
        // Creating int with the expected return value
        int expectedOtherCalories = 2000;
        assertEquals("Method getOtherCalories returned an unexpected value", expectedOtherCalories, otherCalories);

    }

    // test calculate optimal hamper method
    @Test
    public void testCalculateOptimalHamper(){

        //creating hamper with valid input
        Hamper myHamper = new Hamper(1,1,1,1);

        //creating items array to test
        Item[] expectedItems = new Item[3];
        expectedItems[0] = new Item(1,1,1,1,1);
        expectedItems[1] = new Item(2,2,2,2,2);
        expectedItems[2] = new Item(3,3,3,3,3);

        // setting items and testing method
        myHamper.setItems(expectedItems);
        Item[] optimalHamper = myHamper.testCalculateOptimalHamper();

        // creating the expected hamper
        Item[] expectedHamper  = new Item[2];
        expectedItems[0] = new Item(2,2,2,2,2);
        expectedItems[1] = new Item(3,3,3,3,3);
        assertEquals("Method setItems did not return the expected result:", expectedHamper, optimalHamper);

    }

}
