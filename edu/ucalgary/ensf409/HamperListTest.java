/**
 * @author Kolby Lalonde James Platt Carlos Morera Pinilla and Jacob Adeyemo
 * @version: 1.3
 * @since: 1.0
 */

package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.*;


public class HamperListTest 
{
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
        assertEquals("The actual and expected values for clearHamperArray Tests do not match", expected, actual);
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
}
