package TestDemoFirst;

import org.testng.annotations.Test;

public class ClassB {
	@Test(groups= {"g2"})
	public void m3() {
			System.out.println("method M3 class B");
	}
	
	@Test(groups= {"g1"})
	public void m2() {
			System.out.println("method M2 class B");
	}
	@Test(groups= {"g2"})
	public void m1() {
			System.out.println("method M1 class B");
	}
	@Test(groups= {"g1"})
	public void m5() {
			System.out.println("method M5 class B");
	}
	@Test(groups= {"g1"})
	public void m4() {
			System.out.println("method M1 class B");
	}
}
