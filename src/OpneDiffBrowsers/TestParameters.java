package OpneDiffBrowsers;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TestParameters extends ParametersBase{
	
	//@Parameters({"browserName"})
	@Test
	public void m1() {
		openUrl("https://www.facebook.com");
	}
	@Test
	public void m2() {
		openUrl("https://www.canarabank.in");
	}
	@Test
	public void m3() {
		openUrl("https://www.testingshastra.com");
	}

}