package ListnerDemo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListnerDemo.class)
public class TestDemo {
@Test
private void m1() {
throw new ArithmeticException();
}
}
