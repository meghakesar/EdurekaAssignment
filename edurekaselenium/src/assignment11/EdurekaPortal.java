package assignment11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EdurekaPortal {
	ChromeDriver driver;
	String userName = "megha.kesar@gmail.com";
	String password = "megha1983";
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/meghasharma/Downloads/chromedriver 3");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");
		}
	@Test(priority=1)
	public void loginEdureka() {
		driver.findElement(By.linkText("Log In")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("si_popup_email")));
		driver.findElement(By.id("si_popup_email")).sendKeys(userName);
		driver.findElement(By.id("si_popup_passwd")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		}
	@Test(priority=2)
	public void searchCourse() throws InterruptedException  {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='trackButton']")).click();
		driver.findElement(By.xpath("//input[@class='trackButton']")).sendKeys("Manual Testing Certification Training");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='trackButton']")));
		driver.findElement(By.xpath("//input[@class='trackButton']")).sendKeys(Keys.RETURN);
		System.out.println("Course Selected");
		}
	@Test(priority=3)
	public void saveCourse() throws InterruptedException  {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[text()='Manual Testing Certification Training']")).click();
	    
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enroll Now']")));
		driver.findElement(By.xpath("//button[text()='Enroll Now']")).click();
	}
	@Test(priority=4)
	public void backBrowser() {
		driver.navigate().back();
		System.out.println("Product Screen");
	}
	@Test(priority=5)
	public void logoutEdureka() {
		driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		System.out.println("Logged out Successfully");
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	

}
