import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ChildUnder8Test {

	// Testing ChildUnder8 constructor when given dailyNeeds array with valid value
	@Test
	public void testChildUnder8ConstructorValidInput() throws Exception {

		String[][] dailyNeeds = { { "432", "124", "321", "221", "121" }, { "321", "542", "123", "453", "321" },
				{ "456", "123", "345", "213", "865" }, { "766", "231", "655", "546", "432" } };

		ChildUnder8 ChildUnder8 = new ChildUnder8(dailyNeeds);

		assertEquals("ChildUnder8 constructor when given dailyNeeds array with valid value", 766,
				ChildUnder8.getWholeGrains());
		assertEquals("ChildUnder8 constructor when given dailyNeeds array with valid value", 231,
				ChildUnder8.getFruitsVeggies());
		assertEquals("ChildUnder8 constructor when given dailyNeeds array with valid value", 655,
				ChildUnder8.getProtein());
		assertEquals("ChildUnder8 constructor when given dailyNeeds array with valid value", 546,
				ChildUnder8.getOther());
		assertEquals("ChildUnder8 constructor when given dailyNeeds array with valid value", 432,
				ChildUnder8.getCalories());

	}

	// Testing ChildUnder8 constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testChildUnder8ConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "432", "124", "321", "221", "121" }, { "321", "542", "123", "453", "321" },
				{ "456", "123", "345", "213", "865" }, { "-766", "231", "-655", "546", "432" } };

		assertThrows("ChildUnder8 constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new ChildUnder8(dailyNeeds));
	}
	
	// Testing ChildUnder8 constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testChildUnder8ConstructorNullInput() throws Exception {
		String[][] dailyNeeds = null;
		assertThrows("ChildUnder8 constructor when given dailyNeeds array with negative invalid value",
				NullPointerException.class, () -> new ChildUnder8(dailyNeeds));
	}
}
