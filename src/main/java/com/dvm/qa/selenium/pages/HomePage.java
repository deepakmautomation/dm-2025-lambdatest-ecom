package com.dvm.qa.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By myAccount = By.xpath("//div[@id='widget-navbar-217834']/child::ul/child::li[6]/child::a");
	By login = By.xpath("//span[contains(text(),'Login')]");
	
	public HomePage(WebDriver hdriver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = hdriver;
	}

	public LoginPage clickOnLogin() {
		WebElement myAccountelem = driver.findElement(myAccount);
		WebElement loginLink = driver.findElement(login);
		Actions act = new Actions(driver);
		act.moveToElement(myAccountelem).build().perform();
		loginLink.click();
		return new LoginPage(driver);
	}
}
