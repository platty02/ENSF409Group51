import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ChildOver8Test {

	// Testing ChildOver8 constructor when given dailyNeeds array with valid value
	@Test
	public void testChildOver8ConstructorValidInput() throws Exception {

		String[][] dailyNeeds = { { "432", "124", "321", "221", "121" }, { "321", "542", "123", "453", "321" },
				{ "456", "123", "345", "213", "865" }, { "766", "231", "655", "546", "432" } };

		ChildOver8 ChildOver8 = new ChildOver8(dailyNeeds);

		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 456,
				ChildOver8.getWholeGrains());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 123,
				ChildOver8.getFruitsVeggies());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 345,
				ChildOver8.getProtein());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 213, 
				ChildOver8.getOther());
		assertEquals("ChildOver8 constructor when given dailyNeeds array with valid value", 865,
				ChildOver8.getCalories());

	}

	// Testing ChildOver8 constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testChildOver8ConstructorInvalidInput() throws Exception {
		String[][] dailyNeeds = { { "432", "124", "321", "221", "121" }, { "321", "542", "123", "453", "321" },
				{ "456", "123", "345", "-213", "865" }, { "766", "231", "655", "546", "432" } };

		assertThrows("ChildOver8 constructor when given dailyNeeds array with negative invalid value", Exception.class,
				() -> new ChildOver8(dailyNeeds));
	}

	// Testing ChildOver8 constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testChildOver8ConstructorNullInput() throws Exception {
		String[][] dailyNeeds = null;
		assertThrows("ChildOver8 constructor when given dailyNeeds array with negative invalid value",
				NullPointerException.class, () -> new ChildOver8(dailyNeeds));
	}
}
