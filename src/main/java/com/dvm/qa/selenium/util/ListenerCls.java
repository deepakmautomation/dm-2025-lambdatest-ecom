package com.dvm.qa.selenium.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerCls implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + "Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ "Test Success");
		ExtentTest test = SelnmAutoReport.extent.createTest(result.getMethod().getMethodName());
		test.assignAuthor("Deepak");
		test.log(Status.PASS, "Test Pass");
		test.assignCategory("smokeTest");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ "Test Failed");
		ExtentTest test = SelnmAutoReport.extent.createTest(result.getMethod().getMethodName());
		test.assignAuthor("Deepak");
		test.log(Status.FAIL, "TesFailed");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Finshed");
	}

	
}
