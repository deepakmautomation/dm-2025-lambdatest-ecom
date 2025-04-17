package com.dvm.qa.selenium.testcases;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.DashboardPage;
import com.dvm.qa.selenium.pages.HomePage;
import com.dvm.qa.selenium.pages.LoginPage;
import com.dvm.qa.selenium.testbase.TestBase;

public class LoginPageTest extends TestBase{
	
	WebDriver driver;
	TestBase testBase;
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@Parameters({"browsername"})
	@BeforeMethod
	public void setUp(String browsername) throws MalformedURLException, URISyntaxException {
		testBase = new TestBase();
		//driver = testBase.launchBrowser(prop.getProperty("browser"));
		driver = testBase.launchBrowser(browsername);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void verify_Login_with_valid_credentials() {
		loginPage =  homePage.clickOnLogin();
		dashboardPage = loginPage.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
		dashboardPage.logout();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
