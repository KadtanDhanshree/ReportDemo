package ej.Configuration;

import java.io.File;
import java.io.IOException;

//Packages to read data from XML file
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPath;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



import cucumber.api.Scenario;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Config
{
	public static WebDriverWait wait=null;
	public static WebElement element=null;
	public static int counter=1;
	public static WebDriver driver=null;
	public static int ino=1;

	
	
		public static String TakeScreenShot(String ImagePath,WebDriver driver,long ls) throws IOException
		{
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(ImagePath);
			FileUtils.copyFile(src, dest);
			String s = dest.toString();
			return s;
		}	
		
		
		
}
