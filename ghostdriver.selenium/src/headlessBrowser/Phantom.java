package headlessBrowser;



import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


import org.testng.annotations.Test;

import library.Utility;

  public class Phantom {
	  @Test
	  public void verifyEdurekaTitle() throws IOException
	  {
		  File src1 = new File("/Users/meghasharma/Downloads/phantomjs-2.1.1-macosx/bin/phantomjs");
		  System.setProperty("phantomjs.binary.path", src1.getAbsolutePath());
		  WebDriver driver = new PhantomJSDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.google.com");
		  Utility.captureScreenshot(driver, "BrowserStarted");
		  WebElement element = driver.findElement(By.name("q"));
		  element.sendKeys("edureka");
		  element.submit();
		  Utility.captureScreenshot(driver, "EnteredEdureka");

		  
		  System.out.println("title of the page is: "+driver.getTitle());
		  
		  
		  driver.quit();
		  }
	
		
		
	}
	


