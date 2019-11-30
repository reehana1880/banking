package MercuryTour;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Textverify 
{

WebDriver driver;
  
@BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
	
		  
  }
  
  
  @Test
  public void textverification() 
  
  {
	  driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
	    driver.findElement(By.xpath("//*[@id=\"pay_bills_tab\"]/a")).click();
	    driver.findElement(By.linkText("Add New Payee")).click();
	    
	  /*  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
	    driver.findElement(By.id("np_new_payee_name")).sendKeys("HydroOne Utility");
	    driver.findElement(By.id("np_new_payee_address")).sendKeys("200 RobertSpec Pkwy,Mississauga,ON, L6R1K9");
	    driver.findElement(By.id("np_new_payee_account")).sendKeys("123234434");
	    driver.findElement(By.id("np_new_payee_details")).sendKeys("Natural Gas Utility");
	    driver.findElement(By.id("add_new_payee")).click();
	    
	    //System.out.println(driver.findElement(By.cssSelector("div#alert_content")).getText());
	    String expectedtitle = driver.findElement(By.cssSelector("div#alert_content")).getText();
	  //  System.out.println(expectedtitle);
	   
	    String actualtitle = "The new payee HydroOne Utility was successfully created";
	//    System.out.println(actualtitle);
	   
	    if(actualtitle.equals(expectedtitle)) 
	    {
	    	System.out.println("The new payee HydroOne Utility was successfully created");
	    }
	    else
	    {
	    	System.out.println("The payee is not added");
	    }  
	  
}
  
  
  @AfterMethod
  public void teardownmethod() throws InterruptedException
	 {
		 Thread.sleep(5000);
		  driver.quit();
	  }
}
