package com.edurekaPortal.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import com.edurekaPortal.page.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigRead;

public class TestSetup {
	CommonDriver cmnDriver;
	HomePage homepage;
	private WebDriver driver;
	public Properties configProperty;
	public String currentProjectPath;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception{
       setCurrentDirectoryPath();
		
		uploadConfigProperty();
		cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));
		int pageLoadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
		int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		cmnDriver.navigateToFirstUrl(configProperty.getProperty("baseUrl"));
		driver = cmnDriver.getDriver();
		homepage = new HomePage(driver);
		}
	@AfterClass(alwaysRun = true)
	public void cleanup() throws Exception {
		cmnDriver.closeAllBrowsers();
		}
	private void setCurrentDirectoryPath() throws Exception{

		currentProjectPath = System.getProperty("user.dir");
	}

	private void uploadConfigProperty() throws Exception {

		configProperty = ConfigRead.getProperties(currentProjectPath + "/config/config.properties");

	}
	
	

}
