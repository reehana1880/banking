package banking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Testcase003_Transferfund {
 
	WebDriver driver;
	
 @BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://zero.webappsecurity.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

			  driver.findElement(By.id("signin_button")).click();
			  driver.findElement(By.id("user_login")).sendKeys("username");
			  driver.findElement(By.id("user_password")).sendKeys("password");
			  driver.findElement(By.name("submit")).click();
	  }
  @Test
  public void transferfunds()
  {
  	  
	  driver.findElement(By.linkText("Transfer Funds")).click();
	  Select frmaccount = new Select(driver.findElement(By.id("tf_fromAccountId")));
	  frmaccount.selectByIndex(5);
	  Select toaccount = new Select(driver.findElement(By.id("tf_toAccountId")));
	  toaccount.selectByIndex(5);
	  driver.findElement(By.id("tf_amount")).sendKeys("100");
	  driver.findElement(By.id("tf_description")).sendKeys("Transfer Funds");
	  driver.findElement(By.id("btn_submit")).click();
	  driver.findElement(By.id("btn_submit")).click();
	  
	  System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());  
  }
  
  @AfterMethod
  public void teardownmethod() throws InterruptedException
	 {
		 Thread.sleep(5000);
		  driver.quit();
	  }
}
