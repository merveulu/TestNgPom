package com.siliconelabs.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.spi.Element;
import com.siliconelabs.qa.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriverWait wait;
	
	public ElementUtil(){
		wait = new WebDriverWait(driver, 15);
	}
	
	public void waitForElementVisible(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void doSendText(WebElement element, String value){
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception happened while sending keys "+element);
		}
	}
	
	public void doClick(WebElement element){
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Some exception happenend while clicking"+element);
		}
		
	}
	
	public String doGetText(WebElement element){
		try {
			return element.getText();
		} catch (Exception e) {
			System.out.println("Some exception happened while getting text from " + element);
			return null;
		}
	}
	
	public static String getScreenShot() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenShot = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = "./Screenshots/"+dateFormat.format(new Date())+".png";
		try{
		FileUtils.copyFile(screenShot,new File (destination));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
	

}
