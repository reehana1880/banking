package MercuryTour;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class annotation {
WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
  }
  @Test
  public void f()
  {
	  System.out.println(driver.findElement(By.name("userName")).getAttribute("name"));
		System.out.println(driver.findElement(By.name("password")).getAttribute("name"));
  }
  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
