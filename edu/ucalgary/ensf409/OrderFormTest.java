/**
 * @author: Carlos Morera Pinilla
 * @version: 1.1
 * @since: 1.0
 */

package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.*;

public class OrderFormTest
{
    /**Tests if the OrderForm Constructor creates the ArrayList object of Hampers. */
    
    public void testOrderFormConstructor()
    {
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
        ArrayList<Hamper> report = new ArrayList<Hamper>();
        
        report.add(h1);
        report.add(h2);

        OrderForm order = new OrderForm(report);
        assertNotNull("OrderForm constructor did not create an OrderForm object when called", order);
    }
}
