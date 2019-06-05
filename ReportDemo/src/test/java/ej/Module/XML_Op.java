package ej.Module;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//Packages to read data from XML file
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPath;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class XML_Op 
{
	//variables for getting data from XML File
		public XPath objectXpath = null;
		public Document obejctdocument  = null;
		public DocumentBuilderFactory objectDocumentBuilderFactory;
		public DocumentBuilder objectDocumentBuilder;

		
		public XML_Op(String xmlPath)throws ParserConfigurationException,SAXException,IOException
		{
			objectDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			objectDocumentBuilder = objectDocumentBuilderFactory.newDocumentBuilder();
			obejctdocument = objectDocumentBuilder.parse(xmlPath);
			objectXpath = XPathFactory.newInstance().newXPath();	
		}
		
		public String GetText(String xPath) throws SAXException,ParserConfigurationException,IOException,XPathExpressionException
		{		
			System.out.println("******* GetTextSingle value  Information******");
			
		    NodeList nodes = (NodeList) (objectXpath).compile(xPath).evaluate(obejctdocument, XPathConstants.NODESET);	
			
			return nodes.item(0).getTextContent();
		}


}
