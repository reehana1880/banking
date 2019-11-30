package MercuryTour;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TicketPurchase {
	WebDriver driver;
	
  @BeforeMethod
  
  
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	  
  
  @Test
  public void verifyticketpurchase() 
  
  {
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		Select fromdropdowncountry = new Select(driver.findElement(By.name("fromPort")));
		fromdropdowncountry.selectByVisibleText("San Francisco");
		Select todropdowncountry = new Select(driver.findElement(By.name("toPort")));
		todropdowncountry.selectByIndex(5);
		
		//radio button business class
		WebElement bc = driver.findElement(By.name("servClass"));
		bc.isSelected();
		System.out.println("The Business Class radio button is selected " + bc.isSelected() );
		
		
		
  }

  @AfterMethod
  public void teardownmethod() throws InterruptedException
	 {
		 Thread.sleep(3000);
		  driver.quit();
	  }
}
