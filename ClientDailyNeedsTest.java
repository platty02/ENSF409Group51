import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ClientDailyNeedsTest {

	// Testing ClientDailyNeeds constructor when given dailyNeeds array with valid value
	@Test
	public void testClientDailyNeedsConstructorValidInput() throws Exception {

		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		clientDailyNeeds.FoodContent(489, 431, 531, 312, 743);

		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 489,
				clientDailyNeeds.getWholeGrains());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 431,
				clientDailyNeeds.getFruitsVeggies());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 531,
				clientDailyNeeds.getProtein());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 312,
				clientDailyNeeds.getOther());
		assertEquals("ClientDailyNeeds constructor when given dailyNeeds array with valid value", 743,
				clientDailyNeeds.getCalories());

	}

	// Testing ClientDailyNeeds constructor when given dailyNeeds array with negative invalid value
	@Test
	public void testClientDailyNeedsConstructorInvalidInput() throws Exception {

		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();

		assertThrows("ClientDailyNeeds constructor when given dailyNeeds array with negative invalid value",
				Exception.class, () -> clientDailyNeeds.FoodContent(-489, 431, 531, 312, 743));
	}

	// Testing getWholeGrains method when given valid WholeGrains value
	@Test
	public void testGetWholeGrainsValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		clientDailyNeeds.FoodContent(489, 431, 531, 312, 743);

		assertEquals("getWholeGrains method when given valid WholeGrains value", 489,
				clientDailyNeeds.getWholeGrains());
	}

	// Testing getWholeGrains method when given invalid WholeGrains value
	@Test
	public void testGetWholeGrainsInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();

		assertThrows("getWholeGrains method when given invalid WholeGrains value", Exception.class,
				() -> clientDailyNeeds.FoodContent(-489, 431, 531, 312, 743));

		assertEquals("getWholeGrains method when given invalid WholeGrains value", 0,
				clientDailyNeeds.getWholeGrains());
	}

	// Testing getFruitsVeggies method when given valid FruitsVeggies value
	@Test
	public void testGetFruitsVeggiesValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		clientDailyNeeds.FoodContent(489, 431, 531, 312, 743);

		assertEquals("getFruitsVeggies method when given valid FruitsVeggies value", 431,
				clientDailyNeeds.getFruitsVeggies());
	}

	// Testing getFruitsVeggies method when given invalid FruitsVeggies value
	@Test
	public void testGetFruitsVeggiesInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();

		assertThrows("getFruitsVeggies method when given invalid FruitsVeggies value", Exception.class,
				() -> clientDailyNeeds.FoodContent(489, -431, 531, 312, 743));

		assertEquals("getFruitsVeggies method when given invalid FruitsVeggies value", 0,
				clientDailyNeeds.getFruitsVeggies());
	}

	// Testing getProtein method when given valid Protein value
	@Test
	public void testGetProteinValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		clientDailyNeeds.FoodContent(489, 431, 531, 312, 743);

		assertEquals("getProtein method when given valid Protein value", 531, clientDailyNeeds.getProtein());
	}

	// Testing getProtein method when given invalid Protein value
	@Test
	public void testGetProteinInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		assertThrows("getProtein method when given invalid Protein value", Exception.class,
				() -> clientDailyNeeds.FoodContent(489, 431, -531, 312, 743));

		assertEquals("getProtein method when given invalid Protein value", 0, clientDailyNeeds.getProtein());
	}

	// Testing getOther method when given valid Other value
	@Test
	public void testGetOtherValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		clientDailyNeeds.FoodContent(489, 431, 531, 312, 743);

		assertEquals("getOther method when given valid Other value", 312, clientDailyNeeds.getOther());
	}

	// Testing getOther method when given invalid Other value
	@Test
	public void testGetOtherInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		assertThrows("getOther method when given invalid Other value", Exception.class,
				() -> clientDailyNeeds.FoodContent(489, 431, 531, -312, 743));

		assertEquals("getOther method when given invalid Other value", 0, clientDailyNeeds.getOther());
	}

	// Testing getCalories method when given valid Calories value
	@Test
	public void testGetCaloriesValidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		clientDailyNeeds.FoodContent(489, 431, 531, 312, 743);

		assertEquals("getCalories method when given valid Calories value", 743, clientDailyNeeds.getCalories());
	}

	// Testing getCalories method when given invalid Calories value
	@Test
	public void testGetCaloriesInvalidInput() throws Exception {
		ClientDailyNeeds clientDailyNeeds = new ClientDailyNeeds();
		assertThrows("getCalories method when given invalid Calories value", Exception.class,
				() -> clientDailyNeeds.FoodContent(489, 431, 531, 312, -743));

		assertEquals("getCalories method when given invalid Calories value", 0, clientDailyNeeds.getCalories());
	}

}
