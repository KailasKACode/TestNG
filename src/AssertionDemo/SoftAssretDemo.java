package AssertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssretDemo {
	@Test
	public void testDemo() {
		SoftAssert softAssert=new SoftAssert();
		System.out.println("Entr user name: ");
		String user = "test123";
		String user2 = "test1234";
		softAssert.assertEquals(false, true);
		System.out.println("Enter password");
		softAssert.assertEquals(user2,user );

		System.out.println("Click on login");
		softAssert.assertEquals(true, true);
		softAssert.assertAll();


	}

}
