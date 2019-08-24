package TestDemoFirst;

import org.testng.annotations.Test;

public class D {
	@Test(groups= {"sanity"})
	public void m1() {
		System.out.println("M1 methosd");
	}
	@Test(groups= {"regression"})
	public void m13() {
		System.out.println("M13 methosd");
	}
	@Test(groups= {"sanity"})
	public void m14() {
		System.out.println("M14 methosd");
	}


}
