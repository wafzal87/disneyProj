package com.disney.test.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.test.base.Controller;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class DisneyTestUtility extends Controller {
	

	public static String FILE_PATH ="/Users/wafzal/Documents/disneyqaresults.csv";
	
	public ArrayList <String > navElements = new ArrayList<String>();
	
	String[] headers = { "FirstName", "LastName", "Email", "Password", "PhoneNo", "NavElements" };
	String[]  elements = { "waf", "afz", "wafz@email.com", "Hello.123", "3105555555", navElements.toString()};
	
	public ArrayList<String> navigationElements(String BEFORE_XPATH, String AFTER_XPATH){
		
		for (int i=4; i<=10; i++) {
	    	 String fullXpath = BEFORE_XPATH+i+AFTER_XPATH;
	    	 WebElement h1 = driver.findElement(By.xpath(fullXpath));
	    	 navElements.add(h1.getText());
	}
		 return navElements;
	}
	
	public static void writeDataLineByLine(String filePath, String[] header, String[] values  ) 
	{ 
	    File file = new File(filePath); 
	    try { 
	        FileWriter outputfile = new FileWriter(file); 
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	        writer.writeNext(header); 
	        writer.writeNext(values);
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	} 
	
	public static ShopPageData readDataLineByLine(String file) 
	{ 
	  
	    try { 
	   
	        FileReader filereader = new FileReader(file);
	        CSVReader csvReader = new CSVReader(filereader); 
	    
	       List<String[]> allRecords = csvReader.readAll();
	     
	      String [] values = allRecords.get(1);
	      
	      return new ShopPageData(values[0], values[1], values[2], values[3],
	    		   values[4], values[5]);
	    } 
	    catch (Exception e) { 
	    	
	        e.printStackTrace(); 
	        return null;
	    } 
	} 
	
}
