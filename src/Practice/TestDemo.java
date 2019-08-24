
package Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo {
	@Test
	private void m1() {

		System.out.println("@Test");
	}

	@BeforeSuite
	private void m2() {

		System.out.println("@BeforeSuite");

	}

	@BeforeClass
	private void m3() {
		System.out.println("@BeforeClass");

	}

	@BeforeMethod
	private void m4() {
		// TODO Auto-generated method stub

	}

	@BeforeTest
	private void m5() {
		System.out.println("@BeforeTest");

	}
}
