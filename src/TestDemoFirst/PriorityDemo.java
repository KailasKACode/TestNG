package TestDemoFirst;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.implementation.bytecode.Throw;

public class PriorityDemo {
	SoftAssert st = new SoftAssert();

	@Test(dependsOnMethods = { "m9" }, alwaysRun = true)
	public void m1() {
		System.out.println("This is M1 moetod");
	}

	@Test(singleThreaded = true, threadPoolSize = 3, enabled = true, priority = 10, alwaysRun = true, invocationCount = 3, invocationTimeOut = 10000, successPercentage = 50)
	public void m9() {
		throw new ArithmeticException();

	}

	@Test
	public void m0() {
		int a[]= {};
		System.out.println("This is M1 moetod"+a[5]);
		
	}

}
