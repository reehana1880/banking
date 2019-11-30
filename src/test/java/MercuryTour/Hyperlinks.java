package MercuryTour;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hyperlinks {

	WebDriver driver;
	@BeforeMethod
	public void initialsetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");

	}
	
@Test
public void verifylinks()
{
	System.out.println(driver.findElement(By.name("userName")).getAttribute("name"));
	System.out.println(driver.findElement(By.name("password")).getAttribute("name"));
	driver.findElement(By.name("userName")).sendKeys("tutorial");
	driver.findElement(By.name("password")).sendKeys("tutorial");
	 driver.findElement(By.name("login")).click();
	 
	     
     System.out.println(driver.findElements(By.tagName("a")).size());
     int count = driver.findElements(By.tagName("a")).size();
     
   
	for (int i=0; i<count; i++) 
	{
		System.out.println( driver.findElements(By.tagName("a")).get(i).getText());
	}
}
	 @AfterMethod
	 
	 public void teardownmethod() throws InterruptedException
	 {
		 Thread.sleep(5000);
		  driver.quit();
	  }
	  
	}

