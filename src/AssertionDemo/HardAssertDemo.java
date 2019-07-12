package AssertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * This is hard assert in testNG if we are use Assert it will check both are equal or not 
 * It will 100% all test cases will fail after use the hard assert.
 * @author Kailas
 *
 */
public class HardAssertDemo {
	@Test
	public void testDemo() {
		System.out.println("Entr user name: ");
		String user = "test123";
		String user2 = "test1234";
		Assert.assertEquals(user, user2);
		System.out.println("Enter password");
		Assert.assertEquals(user, user2);

		System.out.println("Click on login");
		Assert.assertEquals(user, user2);

	}
}
