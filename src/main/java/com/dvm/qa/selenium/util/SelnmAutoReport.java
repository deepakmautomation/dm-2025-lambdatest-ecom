package com.dvm.qa.selenium.util;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SelnmAutoReport {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void generateReport() {
		
		extent = new ExtentReports();
		
	    ExtentSparkReporter  spark = new ExtentSparkReporter("target\\SelnmAutoReports\\SelnmAutoReport.html");
		
		spark.config().setDocumentTitle("SeleniumAutoReport");
		spark.config().setReportName("SeleniumAutoReport");
		spark.config().setTheme(Theme.STANDARD);
		
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Tester", "Deepak");
		extent.setSystemInfo("Host", "WIN10");
		extent.setSystemInfo("browser", "chrome");
		
	}

}
