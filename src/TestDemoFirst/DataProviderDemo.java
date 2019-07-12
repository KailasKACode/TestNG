package TestDemoFirst;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class DataProviderDemo {
	
	@Test(dataProvider="BooksInfo")
	public void test01(String BookName,String author) {
		
		System.out.println("Bookname:  "+BookName+"\t"+"author name: "+author);
	}
	
	@Test(dataProvider="BooksInfo")
	public void test02(String BookName,String author) {
		
		System.out.println("Bookname:  "+BookName+"\t"+"author name: "+author);
	}

	 
	@DataProvider(name="BooksInfo")
	public Object[] [] booksInfoprovider() {
		String BooksInfo [][]= {{"Phycis","Kachwe Sir"},{"Chemistry","Bochare Sir"},{"Evs","Yede"},{"agnipankh","Dr. abdhul kalam"}};

		
		return BooksInfo;
	}

}
