import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class AdultMaleTest {

	// Testing AdultMale constructor when given dailyNeeds array with valid value
	@Test
	public void testAdultMaleConstructorValidInput() throws Exception {

		String[][] dailyNeeds = { { "432", "124", "321", "221", "121" }, { "321", "542", "123", "453", "321" },
				{ "456", "123", "345", "213", "865" }, { "766", "231", "655", "546", "432" } };

		AdultMale AdultMale = new AdultMale(dailyNeeds);

		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 432,
				AdultMale.getWholeGrains());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 124,
				AdultMale.getFruitsVeggies());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 321, 
				AdultMale.getProtein());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 221, 
				AdultMale.getOther());
		assertEquals("AdultMale constructor when given dailyNeeds array with valid value", 121,
				AdultMale.getCalories());

	}

	// Testing AdultMale constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testAdultMaleConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "-432", "124", "321", "221", "-121" }, { "321", "542", "123", "453", "321" },
				{ "456", "123", "345", "213", "865" }, { "766", "231", "655", "546", "432" } };

		assertThrows("AdultMale constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new AdultMale(dailyNeeds));
	}

	// Testing AdultMale constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testAdultMaleConstructorNullInput() throws Exception {
		String[][] dailyNeeds = null;
		assertThrows("AdultMale constructor when given dailyNeeds array with negative invalid value",
				NullPointerException.class, () -> new AdultMale(dailyNeeds));
	}
}
