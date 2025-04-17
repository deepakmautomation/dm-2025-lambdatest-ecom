package com.dvm.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	
	By logoutLink = By.linkText("Logout");
	
	public DashboardPage(WebDriver ddriver) {
		this.driver = ddriver;
	}
	
	public LoginPage logout() {
		driver.findElement(logoutLink).click();
		return new LoginPage(driver);
	}
}
