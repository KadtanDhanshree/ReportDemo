package Temp;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import ej.Configuration.Config;
import ej.ExtentReport.HTMLReportGenerator;
import ej.Module.Login;
import ej.Module.XML_Op;

public class Temp_Login extends Config
{
	public final static Logger logger=Logger.getLogger(Login.class);
	
	
	@Test
	@Parameters({"Browser"})
	public void user_opens_the_browser(String BrowserName) throws Throwable 
	{
		Thread.sleep(3000);
		try
		   {
			 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.manage().window().maximize();
			 logger.info("Status:PASS,Step No.:"+(Config.counter++)+" Step Name:user opens the "+BrowserName+" browser, Exception:NA");
						 
			 HTMLReportGenerator.StepDetails("pass", "user opens the browser", "Parameter Browsername="+BrowserName+" ",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\OpenBrowser"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));	   
		   }
		   catch(Exception ex) 
		   {
			   System.out.println("Exception");

			   logger.error("Status:FAIL,Step No.:"+(Config.counter++)+" Step Name:user opens the "+BrowserName+" browser, Exception:"+ex.getMessage());
		   }
	}
	
	@Test
	@Parameters({"url"})

	public void user_enter_the_url(String url) throws Throwable 
	{
		Thread.sleep(2000);
		try
		   {
				driver.get(url);
				logger.info("Status:PASS,Step No.:"+(Config.counter++)+" Step Name:user enter the url "+url+", Exception:NA");
								
				 HTMLReportGenerator.StepDetails("pass", "user enter the url", "url= "+url+" ",Config.TakeScreenShot("E:\\Automation testing\\Example_reports\\ExtentReport\\EnterURL"+(Config.ino++)+".png", Config.driver, System.currentTimeMillis()));
		   }
		
		   catch(Exception ex)
		   {
			   System.out.println("Exception");

			   logger.error("Status:FAIL,Step No.:"+(Config.counter++)+" Step Name:user enter the url "+url+", Exception:"+ex.getMessage());
		   }
	}
	
	@Test
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
		   
		  // HTMLReportGenerator.StepDetails("pass", "user is on the application login page", "Parameter NA", "E:\\Automation testing\\Example_reports\\ExtentReport\\AppHomePage"+(Config.ino++)+".png");
		   }
		   catch(Exception ex)
		   {
			   System.out.println("Exception");
			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:user is on the application login page, Exception:"+ex.getMessage());
		   }
			   
		   }

	@Test
	@Parameters({"username"})
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
			   System.out.println("Exception");

			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:When user enters "+uname+" as username, Exception:"+ex.getMessage());
		   } 
	}
	
	@Test
	@Parameters({"password"})
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
			   System.out.println("Exception");

			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:user enters "+pwd+" as password, Exception:"+ex.getMessage());
		   }
	}

	@Test
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
			   System.out.println("Exception");

			   logger.error("Status:FAIL, Step No.:"+(Config.counter++)+" Step Name:user clicks on login button, Exception:"+ex.getMessage());
		   }
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		XML_Op xmlop=new XML_Op("E:\\Automation testing\\Example_reports\\ReportDemo\\testng.xml");
		String t1=xmlop.GetText("SUITE/TEST/text()");
		   System.out.println(t1);

        //Login.logger.info(t1);

	}

}
