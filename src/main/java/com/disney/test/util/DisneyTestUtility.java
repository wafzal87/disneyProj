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

public class DisneyTestUtility {
	

	public static String FILE_PATH ="/Users/wafzal/Documents/disneyqaresults.csv";
	String[] headers = { "FirstName", "LastName", "Email", "Password", "PhoneNo", "NavElements" };
	
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
		CSVReader csvReader = null; 
	    try { 
	   
	        FileReader filereader = new FileReader(file);
	         csvReader = new CSVReader(filereader); 
	    
	       List<String[]> allRecords = csvReader.readAll();
	     
	      String [] values = allRecords.get(1);
	   
	      return new ShopPageData(values[0], values[1], values[2], values[3],
	    		   values[4], values[5]);
	    } 
	    catch (Exception e) { 
	    	
	        e.printStackTrace(); 
	        return null;
	    } finally
	    {
	    	if (csvReader!=null) {
	    		try {
					csvReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    }
	
	} 
	
}
