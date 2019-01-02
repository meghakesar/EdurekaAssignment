package headlessBrowser;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


import org.testng.annotations.Test;

  public class Phantom {
	  @Test
	  public void verifyEdurekaTitle() throws IOException
	  {
		  File src1 = new File("/Users/meghasharma/Downloads/phantomjs-2.1.1-macosx/bin/phantomjs");
		  System.setProperty("phantomjs.binary.path", src1.getAbsolutePath());
		  WebDriver driver = new PhantomJSDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.google.com");
		  WebElement element = driver.findElement(By.name("q"));
		  element.sendKeys("edureka");
		  element.submit();
		  
		  System.out.println("title of the page is: "+driver.getTitle());
		  
		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("./screenshot/edureka.png"),true); 
		  System.out.println("Screenshot captured");
		  driver.quit();
		  }
	
		
		
	}
	


