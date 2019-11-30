package MercuryTour;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DemoTours {
	
	WebDriver driver;
	
  @BeforeMethod
  public void initialsetup() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
  
  @Test
  public void login() {
	 
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("tutorial");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tutorial");
		 driver.findElement(By.xpath("//input[@name='login']")).click();
		String actualtitle = driver.getTitle();
		 String expectedtitle = "Find a Flight: Mercury Tours:";
	     Assert.assertEquals(actualtitle, expectedtitle);
	     System.out.println("The actual title is " + actualtitle);
	 
  }

  @AfterMethod
  public void end() {
	  driver.close();
  }
  
}
