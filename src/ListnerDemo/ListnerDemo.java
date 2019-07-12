package ListnerDemo;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

public class ListnerDemo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case start"+result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case start"+result);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case start"+result);
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case start"+result);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}