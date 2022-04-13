import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;

import org.junit.Test;

public class OrderFormTest {

	// Testing OrderForm Constructor when given valid hamperList value
	@Test
	public void testOrderFormConstructorValidInput() {
		HamperList hampList = new HamperList(3);
		OrderForm orderForm = new OrderForm(hamperList);

		assertEquals("OrderForm Constructor when given valid hamperList value", "3", orderForm.getFormattedForm());
	}

	// Testing OrderForm Constructor when given invalid hamperList value
	@Test
	public void testOrderFormConstructorInvalidInput() {
		HamperList hampList = new HamperList(-3);

		assertThrows("OrderForm Constructor when given invalid hamperList value", IOException.class,
				() -> new OrderForm(hamperList));
	}

	// Testing GetFormattedForm method when given valid hamperList value
	@Test
	public void testGetFormattedFormValidInput() {

		HamperList hampList = new HamperList(3);
		OrderForm orderForm = new OrderForm(hamperList);

		assertEquals("GetFormattedForm method when given valid hamperList value", "3", orderForm.getFormattedForm());
	}

	// Testing GetFormattedForm method when given invalid hamperList value
	@Test
	public void testGetFormattedFormInvalidInput() {

		HamperList hampList = new HamperList(-3);
		OrderForm orderForm = new OrderForm(hamperList);

		assertThrows("OrderForm Constructor when given invalid hamperList value", IOException.class,
				() -> orderForm.getFormattedForm());
		
		assertEquals("GetFormattedForm method when given invalid hamperList value", null, orderForm.getFormattedForm());

	}

}
