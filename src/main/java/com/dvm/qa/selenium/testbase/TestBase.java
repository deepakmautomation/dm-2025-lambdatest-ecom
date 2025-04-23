package com.dvm.qa.selenium.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
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
	
	private String uname =  "deepakmautomation";
	private String akey = "LT_gSiwhdZWbZBFabYoXbPitx6GKu5PgPectSo8rrymbUc0aPb";

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
	
	public WebDriver launchBrowser(String browserName) throws URISyntaxException, MalformedURLException {
		
		URI uri = new URI("https://"+uname+":"+akey+"@hub.lambdatest.com/wd/hub");
		URL url = uri.toURL();
		
		if (prop.getProperty("remote").equals("true")) {
			if(browserName.equalsIgnoreCase("chrome")) {

				//driver = new ChromeDriver();
				/*
				 * DesiredCapabilities chromeCap = new DesiredCapabilities();
				 * chromeCap.setBrowserName(browserName); chromeCap.setPlatform(Platform.WIN10);
				 * ChromeOptions cops = new ChromeOptions(); cops.merge(cops); driver = new
				 * RemoteWebDriver(cops);
				 */
				
				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("135");
				HashMap<String, Object> ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", uname);
				ltOptions.put("accessKey", akey);
				ltOptions.put("network", true);
				ltOptions.put("build", "chromeBuild");
				ltOptions.put("project", "dm-2025-lambdatest-ecom");
				ltOptions.put("name", "Chrome-Lambda-Automation-Test");
				ltOptions.put("console", "error");
				ltOptions.put("selenium_version", "4.0.0");
				ltOptions.put("w3c", true);
				browserOptions.setCapability("LT:Options", ltOptions);
				
				driver  = new RemoteWebDriver(url, browserOptions);

			}else if(browserName.equalsIgnoreCase("firefox")) {

				//driver = new FirefoxDriver();
				/*
				 * DesiredCapabilities ffCap = new DesiredCapabilities();
				 * ffCap.setBrowserName(browserName); ffCap.setPlatform(Platform.WIN10);
				 * FirefoxOptions fops = new FirefoxOptions(); fops.merge(ffCap); driver = new
				 * RemoteWebDriver(fops);
				 */
				
				FirefoxOptions browserOptions = new FirefoxOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("dev");
				HashMap<String, Object> ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", uname);
				ltOptions.put("accessKey", akey);
				ltOptions.put("network", true);
				ltOptions.put("build", "FireFoxBuild");
				ltOptions.put("project", "Untitled");
				ltOptions.put("name", "dm-2025-lambdatest-ecom-FireFox-Test");
				ltOptions.put("console", "error");
				ltOptions.put("w3c", true);
				ltOptions.put("plugin", "java-testNG");
				browserOptions.setCapability("LT:Options", ltOptions);
				driver  = new RemoteWebDriver(url, browserOptions);

			} else if(browserName.equalsIgnoreCase("edge")) {

				//driver = new EdgeDriver();
				/*
				 * DesiredCapabilities edcap = new DesiredCapabilities();
				 * edcap.setBrowserName(browserName); edcap.setPlatform(Platform.WIN10);
				 * EdgeOptions eops = new EdgeOptions(); eops.merge(edcap); driver = new
				 * RemoteWebDriver(eops);
				 */
				
				EdgeOptions browserOptions = new EdgeOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("dev");
				HashMap<String, Object> ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", uname);
				ltOptions.put("accessKey", akey);
				ltOptions.put("network", true);
				ltOptions.put("build", "EdgeBuild");
				ltOptions.put("project", "dm-2025-lambdatest-ecom");
				ltOptions.put("name", "dm-2025-lambdatest-ecom-Edge-Test");
				ltOptions.put("console", "error");
				ltOptions.put("w3c", true);
				ltOptions.put("plugin", "java-testNG");
				browserOptions.setCapability("LT:Options", ltOptions);
				driver  = new RemoteWebDriver(url, browserOptions);
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
