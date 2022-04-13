import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class AdultFemaleTest {

	// Testing AdultFemale constructor when given dailyNeeds array with valid value
	@Test
	public void testAdultFemaleConstructorValidInput() throws Exception {

		String[][] dailyNeeds = { { "432", "124", "321", "221", "121" }, { "321", "542", "123", "453", "321" },
				{ "456", "123", "345", "213", "865" }, { "766", "231", "655", "546", "432" } };

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

	// Testing AdultFemale constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testAdultFemaleConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "432", "124", "321", "221", "121" }, { "-321", "-542", "123", "453", "-321" },
				{ "456", "123", "345", "213", "865" }, { "766", "231", "655", "546", "432" } };

		assertThrows("AdultFemale constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new AdultFemale(dailyNeeds));

	}

	// Testing AdultFemale constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testAdultFemaleConstructorNullInput() throws NullPointerException, Exception {
		String[][] dailyNeeds = null;
		assertThrows("AdultFemale constructor when given dailyNeeds array with negative invalid value",
				NullPointerException.class, () -> new AdultFemale(dailyNeeds));
	}
}
