package ej.Module;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import ej.Configuration.*;
import ej.ExtentReport.HTMLReportGenerator;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends Config
{
	
	public final static Logger logger=Logger.getLogger(Login.class);

	
	public void ImgStep(Scenario object)
	{
		object.getName();
	}
	
	@When("^user opens the \"([^\"]*)\" browser$")
	public void user_opens_the_browser(String BrowserName) throws Throwable 
	{
		Thread.sleep(3000);
		try
		   {
			 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.manage().window().maximize();
			 logger.info("Status:PASS,Step No.:"+(Config.counter++)+" Step Name:user opens the "+BrowserName+" browser, Exception:NA");
			
			// HTMLReportGenerator.StepDetails("pass", "user opens the "+BrowserName+" browser", "Parameter Browsername="+BrowserName+" ", "");
			 
			 HTMLReportGenerator.StepDetails("pass", "user opens the browser", "Parameter Browsername="+BrowserName+" ",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\OpenBrowser"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));
			   
		   }
		   catch(Exception ex) 
		   {
			   logger.error("Status:FAIL,Step No.:"+(Config.counter++)+" Step Name:user opens the "+BrowserName+" browser, Exception:"+ex.getMessage());
		   }
	}

	@When("^user enter the url \"([^\"]*)\"$")
	public void user_enter_the_url(String url) throws Throwable 
	{
		Thread.sleep(2000);
		try
		   {
				driver.get(url);
				logger.info("Status:PASS,Step No.:"+(Config.counter++)+" Step Name:user enter the url "+url+", Exception:NA");
								
				// HTMLReportGenerator.StepDetails("pass", "user enter the url", "url="+url+" ",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\imgURL.png", Config.driver, System.currentTimeMillis()));
				
				 HTMLReportGenerator.StepDetails("pass", "user enter the url", "url= "+url+" ",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\EnterURL"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));
		   }
		
		   catch(Exception ex)
		   {
			   logger.error("Status:FAIL,Step No.:"+(Config.counter++)+" Step Name:user enter the url "+url+", Exception:"+ex.getMessage());
		   }
	} 

	@Given("^user is on the application login page$")
	public void user_is_on_the_application_login_page() throws Throwable
	{
		Thread.sleep(2000);
		   try
		   {
		   element=driver.findElement(By.xpath("//i[contains(.,'Facebook')]"));
		   String label=element.getText();
		   if(label.contains("facebook"))
		   {
			   System.out.println("User is on application login page");
		   }
		   logger.info("Status:PASS, Step No.:"+(Config.counter++)+" Step Name:user is on the application login page, Exception:NA");
		   
		   HTMLReportGenerator.StepDetails("pass", "user is on the application login page", "Parameter NA", "E:\\Automation testing\\Example_reports\\ExtentReport\\AppHomePage"+(Config.ino++)+".png");
		   }
		   catch(Exception ex)
		   {
			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:user is on the application login page, Exception:"+ex.getMessage());
		   }	   
	}
	
	@When("^user enters \"([^\"]*)\" as username$")
	public void user_enters_as_username(String uname) throws Throwable 
	{
		Thread.sleep(1000);
		try 
		   {
			element=driver.findElement(By.xpath("//input[@type='email']"));
			element.sendKeys(uname);
			logger.info("Status:PASS, Step No.:"+(Config.counter++)+" Step Name:When user enters "+uname+" as username, Exception:NA");
			
			HTMLReportGenerator.StepDetails("pass", "When user enters "+uname+" as username", "Parameter Username="+uname+"", "");
	   }
		   catch(Exception ex)
		   {
			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:When user enters "+uname+" as username, Exception:"+ex.getMessage());
		   } 
	}

	@When("^user enters \"([^\"]*)\" as password$")
	public void user_enters_as_password(String pwd) throws Throwable 
	{
		Thread.sleep(1000);
		try
		   {
			//Thread.sleep(1000);
			   element=driver.findElement(By.xpath("//input[@name='pass']"));
			   element.sendKeys(pwd);	
			   logger.info("Status:PASS, Step No.:"+(Config.counter++)+" Step Name:user enters "+pwd+" as password, Exception:NA");
			   
			   HTMLReportGenerator.StepDetails("pass", "When user enters "+pwd+" as username", "Parameter Username="+pwd+"", "");
		   }
		   
		   catch(Exception ex)
		   {
			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:user enters "+pwd+" as password, Exception:"+ex.getMessage());
		   }
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable 
	{
		Thread.sleep(2000);

		try
		   {
			   element=driver.findElement(By.xpath("//input[@value='Log In']"));
			   element.click();	  
			   logger.info("Status:PASS, Step No.:"+(Config.counter++)+" Step Name:user clicks on login button, Exception:NA");
			   
			   HTMLReportGenerator.StepDetails("pass", "user clicks on login button", "Parameter NA", Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\login"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));
		   }
		   
		   catch(Exception ex)
		   {
			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:user clicks on login button, Exception:"+ex.getMessage());
		   }
	}

	@Then("^user is on the application home page$")
	public void user_is_on_the_application_home_page() throws Throwable 
	{
		Thread.sleep(2000);
		try
		   {
			   String url=driver.getCurrentUrl();
			   if(url.equalsIgnoreCase("https://www.facebook.com/"))
			   {
				   System.out.println("Application Home page");
			   
			   
			   logger.info("Status:PASS, Step No.:"+(Config.counter++)+" Step Name:user is on the application home page, Exception:NA");
			 
			   HTMLReportGenerator.StepDetails("PASS", "user is on the application home page", "Parameter NA",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\HomePage"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));
		   }
	  }
		   
		   catch(Exception ex)
		   {
			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:user is on the application home page, Exception:"+ex.getMessage());
			  
			   HTMLReportGenerator.StepDetails("FAIL", "user is on the application home page", "Parameter NA","");
		   } 
	}

	@Then("^user gets the message starting with \"([^\"]*)\" on the top$")
	public void user_gets_the_message_starting_with_on_the_top(String arg1) throws Throwable 
	{
		System.out.println("Welcome");
	    // Write code here that turns the phrase above into concrete actions
				
		   HTMLReportGenerator.StepDetails("pass", "user is on the application home page", "Parameter NA",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\imgpass"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));
}
	
	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_enter_valid_and_valid(String uname, String pass) throws Throwable 
	{
		try 
		{
			Thread.sleep(500);

			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(uname);

			driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(pass);
			
			logger.info("Status:PASS, Step No.:"+(Config.counter++)+" Step Name:user enter valid "+uname+" and "+pass+", Exception:NA");
			
			//HTMLReportGenerator.StepDetails("pass", "When user enters "+uname+" as username & "+pass+" as password", "Parameter Username="+uname+", password="+pass+"", "");
			
			HTMLReportGenerator.StepDetails("pass", "When user enters username & password", "Parameter Username="+uname+", password="+pass+"", Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\unamePwdIMG"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));
		} 
		
		catch (Exception ex) 
		{
			String message = "Status:FAIL,Step Number:" + Config.counter++ + ",Step:Step : i enter valid "+uname+" and valid "+pass+" exception:" + ex.getMessage();
			logger.error(message);
		}
	}

	@Then("^user should login successfully$")
	public void user_should_login_successfully() throws Throwable 
	{
		try 
		{
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
			
			logger.info("Status:PASS, Step No.:"+(Config.counter++)+" Step Name:user should login successfully, Exception:NA");
			
			//HTMLReportGenerator.StepDetails("pass", "user should login successfully", "Parameter NA",Config.TakeScreenShot("", Config.driver, System.currentTimeMillis()));
			
			HTMLReportGenerator.StepDetails("pass", "user should login successfully", "Parameter NA",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\imgURL.png", Config.driver, System.currentTimeMillis()));
			
			driver.quit();
		}
		
		catch (Exception ex)
		{
			String message = "Status:FAIL,Step Number:" + Config.counter++
			+ ",Step:Step :User Should Login Successfully" + "exception:" + ex.getMessage();
			logger.error(message);
		}
	}    

}

