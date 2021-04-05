package com.siliconelabs.qa.listeners;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportSetUp {
	
	static ExtentReports extent;
	static ExtentSparkReporter sparkReport;
	static ExtentTest extentTest;
	
	public static ExtentReports extentReportSetup (){
		
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport/" +getLocalTime()+ ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("Test automation report");
		sparkReport.config().setReportName("Regression Test");
		
		return extent;
	}
	
	public static String getLocalTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
		
	}

}
