package TestDemoFirst;

import org.testng.annotations.Test;

public class ClassA {
	@Test(groups = { "g1" })
	public void m3() {
		System.out.println("method M3 class A");
	}

	@Test(groups= {"g1"})
	public void m2() {
		System.out.println("method M2 class A");
	}

	@Test(groups= {"g2"})
	public void m1() {
		System.out.println("method M1 class A");
	}

	@Test(groups = { "g2" })
	public void m5() {
		System.out.println("method M5 class A");
	}

	@Test(groups= {"g1"}, dependsOnMethods= {"m5"})
	public void m4() {
		System.out.println("method Dependenc class A");
	}

	@Test (groups= {"Santiy"})
	public void m41() {
		System.out.println("method M41 class A");
	}

	@Test (groups= {"Sanity"})
	public void m42() {
		System.out.println("method M42 class A");
	}

	@Test (groups= {"Sanity"})
	public void m43() {
		throw new ArithmeticException();
	}

	
}
