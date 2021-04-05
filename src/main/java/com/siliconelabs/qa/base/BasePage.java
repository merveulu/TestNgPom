package com.siliconelabs.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static Properties properties;
	public static WebDriver driver;
	
	public BasePage(){
		properties = new Properties();
		String filePath = "./src/main/java/com/siliconelabs/qa/configuration/configuration.properties";
		try{
		FileInputStream file = new FileInputStream(filePath); 
		properties.load(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initializeDriver () {
		String browser = properties.getProperty("browser");
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}else {
			System.out.println("No driver found!");
		}
		
		driver.get(properties.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
	

}
