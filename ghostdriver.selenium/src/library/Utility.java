package library;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {
	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(src, new File("./screenshot/"+screenshotName+".png"),true); 
			  System.out.println("Screenshot captured");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		} 
	}
	}
	
