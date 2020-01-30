package com.disney.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Controller {

	public static WebDriver driver;
	public static Properties prop;
	
	public Controller()
	{
		try
		{
			prop = new Properties();
			FileInputStream input = new FileInputStream("/Users/wafzal/eclipse-workspace/DisneyTestProject/src/main/java/com/disney/test/config/config.properties");
			
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		
		String browser = prop.getProperty("browser");
		
		if (browser.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver", "/Users/wafzal/Documents/chromedriver");
		 driver = new ChromeDriver();
		}else if  (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/wafzal/Documents/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
}
