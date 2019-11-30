package banking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Testcase001_VerifyLogin {

WebDriver driver;
	
	
@BeforeMethod
 public void setup() 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://zero.webappsecurity.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
  @Test
  public void VerifyLogin() 
  {
	  driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password1");
		driver.findElement(By.name("submit")).click();
		 String actualtitle = driver.getTitle();
		 String expectedtitle = "Zero - Account Summary";
	     Assert.assertEquals(actualtitle, expectedtitle);
	     System.out.println( "The actual title is" + actualtitle);
  }
 
  

  @AfterMethod
 
	  
	  public void teardown(ITestResult testResult) throws IOException {
		  if(testResult.getStatus() == ITestResult.FAILURE) 
		  {
			 utility.Screenshot.takeScreenshot(driver, testResult.getName());
		  } driver.close();
  }

}
