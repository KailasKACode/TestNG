package Parrallesim;

import org.testng.annotations.Test;

public class OpenUrlAll extends TestDemoParallal {
	@Test
	public void m1() {
		openUrl("https://www.facebook.com");
	}
	
	@Test
	public void m2() {
		openUrl("http://newtours.demoaut.com/");
	}
	@Test
	public void m3() {
		openUrl("https://mvnrepository.com/");

	}
}
