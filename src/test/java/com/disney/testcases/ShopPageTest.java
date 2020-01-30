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

public class ShopPageTest extends Controller{
	String fname= "waf";
	String lname = "afz";
	String pwd= "password123";
	String vpwd= "Password123";
	String email= "waf"+System.currentTimeMillis()+"@email.com";
	String dob= "01/01/1999";
	
	DisneySitepage disneypage;
	ShopDisneyPage shopDisneyPage;
	SignUpFrame   signUpFrame;
	DisneyTestUtility disneyTestUtility;
	
	public ShopPageTest () {
		super();
	}
	
	@BeforeMethod
	public void initialization() {
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
	public void createAccount() {
		shopDisneyPage.clickSignIn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame("disneyid-iframe");
		signUpFrame.clickCreateAccount();
		signUpFrame.createNewAccount(fname, lname, pwd, vpwd, email, dob);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void endSession() {
		driver.quit();
	}

}
