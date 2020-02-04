package com.disney.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disney.test.base.Controller;
import com.disney.test.pages.DisneySitepage;
import com.disney.test.pages.ShopDisneyPage;
import com.disney.test.pages.SignUpFrame;
import com.disney.test.util.DisneyTestUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ShopPageTest extends Controller{
	
	String[] headers = { "FirstName", "LastName", "Email", "Password", "PhoneNo", "NavElements" };
	String[] loginInfo = { "waf", "afz", "wafz"+System.currentTimeMillis()+"@email.com", "Password123", "01/01/31"};
	String xpath= "//a[@class='nav-link dropdown-toggle']";
	public static String FILE_PATH ="/Users/wafzal/Documents/disneyqaresults.csv";
	
	/*String fname= elements[0].toString();
	String lname = elements[1].toString();
	String pwd=  elements[3].toString();
	String vpwd= elements[3].toString();
	String email=  elements[2].toString();
	String dob= elements[4].toString();*/
	
	DisneySitepage disneypage;
	ShopDisneyPage shopDisneyPage;
	SignUpFrame   signUpFrame;
	DisneyTestUtility disneyTestUtility;
	
	public ShopPageTest () {
		super();
	}
	
	@BeforeMethod
	public void initialization() throws InterruptedException {
		initialize();
		disneypage = new DisneySitepage();
		shopDisneyPage = new ShopDisneyPage();
		signUpFrame = new SignUpFrame();
		disneyTestUtility = new DisneyTestUtility();
		
		shopDisneyPage= disneypage.NavigateToShop();
		
	}
	
	@Test(priority=1)
	public void ShopPageTitleTest(){
		String title = shopDisneyPage.CheckPageTitle();
		Assert.assertEquals(title, "shopDisney | Official Site for Disney Merchandise");
	}
	
	@Test(priority=2)
	public void createAccount() throws InterruptedException {
		shopDisneyPage.clickSignIn();
		
		driver.switchTo().frame("disneyid-iframe");
		signUpFrame.clickCreateAccount();
		Thread.sleep(3000);
		signUpFrame.createNewAccount(loginInfo[0].toString(), loginInfo[1].toString(), loginInfo[2].toString(), 
				loginInfo[3].toString(), loginInfo[3].toString(), loginInfo[4].toString());
		
		Thread.sleep(3000);
		signUpFrame.clickContinue();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		 List<String> navElements = shopDisneyPage.getNavElements(xpath);
		 //elements[5] = navElements.toString();
		
//		 ArrayList<String> elements = new ArrayList<String>();
//		elements.addAll(Arrays.asList(loginInfo));
//		elements.add(navElements.toString());
//		
		
		String[] elements = new String[loginInfo.length + 1];
		elements[loginInfo.length] = navElements.toString();
		for (int i=0; i<loginInfo.length; i++) {
			elements[i] = loginInfo[i];
		}
	    DisneyTestUtility.writeDataLineByLine(FILE_PATH, headers, elements) ;
	}
	
	
	@AfterMethod
	public void endSession() {
		driver.quit();
	}

}
