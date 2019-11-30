package banking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Testcase004_ForeignExchange {
  WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() 
	
	{
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
  public void f() 
	{
		driver.findElement(By.linkText("Pay Bills")).click();
		driver.findElement(By.linkText("Purchase Foreign Currency")).click();
		
		Select currency = new Select(driver.findElement(By.id("pc_currency")));
		currency.selectByIndex(12);
		
		driver.findElement(By.id("pc_amount")).sendKeys("100");
		
		//radio button usd or selected currency
		
		WebElement sc = driver.findElement(By.id("pc_inDollars_false"));
		sc.click();
		//System.out.println("New Zealand currency amount 100 dollars is equal to " + sc.isSelected());
		
		driver.findElement(By.id("pc_calculate_costs")).click();
		
		System.out.println(driver.findElement(By.id("pc_conversion_amount")));
		System.out.println("welcome to git");
		driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
		
		System.out.println(driver.findElement(By.id("alert_content")).getText());
		
			
  }
	
  
  @AfterMethod
  public void teardownmethod() throws InterruptedException
	 {
		 Thread.sleep(3000);
		  driver.quit();
	  }
}
