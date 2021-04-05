package com.siliconelabs.qa.tests;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.siliconelabs.qa.base.BasePage;
import com.siliconelabs.qa.pages.HomePage;
import com.siliconelabs.qa.pages.LoginPage;

public class HomePageTest extends BasePage{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initializeDriver();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	@Test
	public void quickLaunchElementsTest(){
		Assert.assertEquals(homePage.verifyQuickLaunchElements(), 
				new ArrayList<String>(Arrays.asList("Assign Leave", "Leave List", "Timesheets", "Apply Leave", "My Leave","My Timesheet")));
	}
}
