
import static com.revature.validation.CreditCardCheck.isValid;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;;

public class CreditCardCheckTest {
	
	// test bad inputs
	@Test
	public void nullToBeFalse() {
		assertFalse(isValid(null));
	}
	
	@Test
	public void emptyStringInvalid() {
		assertFalse(isValid(""));
	}
	
	@Test
	public void numberLengthToLong() {
		assertFalse(isValid("12345678910111213141516171819"));
	}
	
	@Test
	public void numberLengthToShort() {
		assertFalse(isValid("123456789"));
	}
	
	@Test
	public void numberIsValid() {
		assertTrue(isValid("1234567890123452"));
	}
	
	@Test
	public void numberInvalid() {
		assertFalse(isValid("1234567890123456"));
	}
}
