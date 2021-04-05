package com.siliconelabs.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.siliconelabs.qa.base.BasePage;
import com.siliconelabs.qa.utilities.ElementUtil;

public class HomePage extends BasePage {
	
	ElementUtil elementUtil;
	
	@FindBy(xpath="//*[@id='content']//h1")
	WebElement dashboard;
	
	@FindBy(xpath = "//*[@id='dashboard-quick-launch-panel-menu_holder']//span")
	List<WebElement> quicklaunchElements;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		elementUtil = new ElementUtil();
		
	}
	
	public String verifyHeader(){
		elementUtil.waitForElementVisible(dashboard);
		return elementUtil.doGetText(dashboard);

		
	}
	
	public ArrayList<String> verifyQuickLaunchElements(){
		ArrayList<String> elementsList = new ArrayList<String>();
		
		for (WebElement webElement : quicklaunchElements) {
			String elementText = webElement.getText();
			elementsList.add(elementText);
		}
		return elementsList;
	}

}
