package com.dvm.qa.selenium.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	WebDriver driver;
	
	public static void getScreenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		
		 File source =  takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		 String filepath = System.getProperty("user.dir")+"\\screenshots\\screencap.png";
		 
		 File dest = new File(filepath);
		 
		 FileUtils.copyFile(source, dest);
	}

}
