package com.dvm.qa.selenium.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	public WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\dvm\\qa\\selenium\\config\\config.properties");
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);	
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver launchBrowser(String browserName) {

		if(prop.getProperty("remote").equals(true)) {

			if(browserName.equalsIgnoreCase("chrome")) {

				//driver = new ChromeDriver();
				DesiredCapabilities chromeCap = new DesiredCapabilities();
				chromeCap.setBrowserName(browserName);
				chromeCap.setPlatform(Platform.WIN10);
				ChromeOptions cops = new ChromeOptions();
				cops.merge(cops);
				driver = new RemoteWebDriver(cops);

			}else if(browserName.equalsIgnoreCase("firefox")) {

				//driver = new FirefoxDriver();
				DesiredCapabilities ffCap = new DesiredCapabilities();
				ffCap.setBrowserName(browserName);
				ffCap.setPlatform(Platform.WIN10);
				FirefoxOptions fops = new FirefoxOptions();
				fops.merge(ffCap);
				driver = new RemoteWebDriver(fops);


			} else if(browserName.equalsIgnoreCase("edge")) {

				//driver = new EdgeDriver();
				DesiredCapabilities edcap = new DesiredCapabilities();
				edcap.setBrowserName(browserName);
				edcap.setPlatform(Platform.WIN10);
				EdgeOptions eops = new EdgeOptions();
				eops.merge(edcap);
				driver = new RemoteWebDriver(eops);
			}
		}else {

			if(browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}

		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		return driver;
	}

}
