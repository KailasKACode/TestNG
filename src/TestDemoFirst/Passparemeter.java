package TestDemoFirst;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Passparemeter {
	@Parameters({"user","pass"})
	@Test
	public void m3(String user,String pass) {
		System.out.println("M3 Method"+user+" sencod: "+pass);
	}
	@Test

	public void m1() {
		System.out.println("M3 Method");
	}
	@Test

	public void m4() {
		System.out.println("M3 Method");
	}
	@Test

	public void m2() {
		System.out.println("M3 Method");
	}

}
