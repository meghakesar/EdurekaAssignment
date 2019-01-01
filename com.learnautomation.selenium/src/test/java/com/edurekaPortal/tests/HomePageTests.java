package com.edurekaPortal.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTests extends TestSetup {
	public HomePageTests() throws Exception {
		super();
		}
	@Parameters({"megha.kesar@gmail.com", "megha1983"})
	@Test
	public void verifyLoginToApplication(String sUserEmailId, String sUserPassword) throws Exception {
		homepage.userLogin(sUserEmailId, sUserPassword);

		String actualWelcomeText = "Megha";

		String expectedWelcomeText = homepage.getProfileNameText();
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);

	}
	

}
