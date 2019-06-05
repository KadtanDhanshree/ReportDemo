package ej.Module;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import ej.Configuration.Config;
import ej.ExtentReport.HTMLReportGenerator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hookable 
{
	
	 @Before
	    public void beforeScenario(Scenario obj) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	 	{
		 
		 	XML_Op xmlop=new XML_Op("E:\\Automation testing\\Example_reports\\ReportDemo\\testng.xml");
			String t1=xmlop.GetText("SUITE/TEST/text()");
	        Login.logger.info(t1);
		 
		 	//for log4j
	        System.out.println("This will run before the Scenario");
	        
	        System.out.println(obj);
	        
	      // get particular scenario name from login.features
	      
	        Login.logger.info(obj.getName());
	        
	        boolean bol;
	        int count=0;
	        while(bol=new File("E:\\Automation testing\\Example_reports\\ExtentReport\\" +count+".html").exists())
	        {
	        	count++;
	        }
	        
	      //For HTML Report 
	        HTMLReportGenerator.TestSuiteStart("E:\\Automation testing\\Example_reports\\ExtentReport\\report.html", "ejagruti");
	        // get particular scenario name from login.features
	        HTMLReportGenerator.TestCaseStart(obj.getName(), "This is description");   
	 	}
	 
	 @After
	    public void afterScenario() throws IOException
	 {
		 	//for log4j
	        System.out.println("This will run after the Scenario");
	        Config.counter=1;
	        
	        
	        // for screenshot
	        
	       // Config.TakeScreenShot("", Config.driver, System.currentTimeMillis());
	        
	        //For HTML Report 

	        HTMLReportGenerator.TestCaseEnd();
	        HTMLReportGenerator.TestSuiteEnd();
	        
	 }
}
