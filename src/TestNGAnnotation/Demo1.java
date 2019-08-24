package TestNGAnnotation;

import org.testng.annotations.Test;

public class Demo1 {
	@Test(priority = -40, invocationCount = 1)
	public void m1() {
		System.out.println("M1 methods");
		throw new NullPointerException();
	}

	@Test(priority = -2001, dependsOnMethods = { "m1" })
	public void m3() {
		System.out.println("M3 methods");

	}

	@Test(priority = 1)
	public void m5() {
		System.out.println("M5 methods");
	}

	@Test(priority = 80)
	public void m2() {
		System.out.println("M2 methods");
	}

	@Test(priority = -39)
	public void m4() {
		System.out.println("M4 methods");
	}

}
