package com.dvm.qa.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	By email = By.name("email");
	By password = By.name("password");
	By loginBtn = By.xpath("//input[@value='Login']");
	
	public LoginPage(WebDriver ldriver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = ldriver;
	}
	
	public DashboardPage login(String uname, String pwd) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(email)));
		driver.findElement(email).sendKeys(uname);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(password)));
		driver.findElement(password).sendKeys(pwd);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginBtn)));
		driver.findElement(loginBtn).click();
		return new DashboardPage(driver);
	}

}
