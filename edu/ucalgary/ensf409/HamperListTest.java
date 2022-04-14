/**
 * @author: Carlos Morera Pinilla
 * @version: 1.2
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
    public void testHamperListConstructor()
    {
        //Create HamperList object.
        HamperList hL = new HamperList();
        assertNotNull("HamperList Constructor did not create the array list and the hamperCount fields when called", hL);
    }

    /** Tests the getHamperCount method to see if it returns the expected
     * value of the ArrayList field of the HamperList class created in it's Constructor.
     */
    @Test
    public void testGetHamperCount()
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
    public void testTakeFromHamper()
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
    public void testClearHamperArray()
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
    public void testReturnShortages()
    {
        HamperList hl = new HamperList();
        
        assertNull("returnShortages() method did not return an empty array.", hl.returnShortages());
    }
    /**Tests to see if it returns -1 for the returnNumShortages() when created in the HamperList
     * Constructor.
    */
    @Test 
    public void testReturnNumShortages()
    {
        HamperList hl = new HamperList();
        int expected = -1;
        int actual = hl.returnNumShortages();
        assertEquals("returnNumShorages() did not return the correct value when created", expected, actual);
    }
    /**tests to see if the calculateOrder throws the UnavailableResourcesException
     * when there are no more resources available.
     */
    /*@Test 
    public void testUnavailableResourcesException()
    {
        HamperList hl = new HamperList();

        int[] a1 = {1, 1, 1, 1};
        
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
        testItemInfo[1] = null;
        testItemInfo[2] = "6";
        testItemInfo[3] = "6";
        testItemInfo[4] = "6";
        testItemInfo[5] = "6";
        testItemInfo[6] = "6";
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
    }*/
}
