package TestDemoFirst;

import org.testng.annotations.Test;

public class C {
	@Test(groups= {"regression"})
	public void m3() {
		System.out.println("M3 methosd");
	}
	@Test(groups= {"sanity"})
	public void m7() {
		System.out.println("M7 methosd");
	}
	@Test(groups= {"regression"})
	public void m5() {
		System.out.println("M5 methosd");
	}

}
