package com.disney.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disney.test.base.Controller;
import com.disney.test.pages.*;

public class DisneySitePageTest extends Controller{

	DisneySitepage disneypage;
	
	public DisneySitePageTest() {
		super();
	}
	
	@BeforeMethod
	public void initialization() {
		initialize();
		disneypage = new DisneySitepage();
		
	}
	
	@Test
	public void onClick() throws InterruptedException {
		disneypage.NavigateToShop();
	}
	
	@AfterMethod
	public void endSession() {
		driver.quit();
	}
	
}
