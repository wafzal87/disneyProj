package com.disney.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disney.test.base.Controller;
import com.disney.test.pages.DisneySitepage;
import com.disney.test.pages.ShopDisneyPage;
import com.disney.test.pages.SignInFrame;
import com.disney.test.util.DisneyTestUtility;
import com.disney.test.util.ShopPageData;

public class VerificationTest extends Controller{
	
	public static String FILE_PATH ="/Users/wafzal/Documents/disneyqaresults.csv";
	public static String XPATH= "//a[@class='nav-link dropdown-toggle']";
	
	DisneySitepage disneypage;
	ShopDisneyPage shopDisneyPage;
	SignInFrame   signInFrame;
	DisneyTestUtility disneyTestUtility;
	ShopPageData  shopPageData;
	
	public VerificationTest () {
		super();
	}
	
	@BeforeMethod
	public void initialization() throws InterruptedException {
		initialize();
		disneypage = new DisneySitepage();
		shopDisneyPage = new ShopDisneyPage();
		signInFrame = new SignInFrame();
		disneyTestUtility = new DisneyTestUtility();
		shopDisneyPage= disneypage.NavigateToShop();
		
	}
	
	@Test(priority=1)
	public void signInVerify() throws InterruptedException {
		shopPageData  = DisneyTestUtility.readDataLineByLine(FILE_PATH);
		shopDisneyPage.clickSignIn();
		Thread.sleep(3000);
		driver.switchTo().frame("disneyid-iframe");
		signInFrame.logInToAccount(shopPageData.getEmail(), shopPageData.getPassword());
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		 List<String> navElements = shopDisneyPage.getNavElements(XPATH);
		 String verifyList = navElements.toString();
		 
		 Assert.assertEquals(verifyList, shopPageData.getNavElements());
		 Thread.sleep(3000);
		 shopDisneyPage.clickLogOut();
		}
	
	@AfterMethod
	public void endSession() {
		driver.quit();
	}
}
