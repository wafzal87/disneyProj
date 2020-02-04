package com.disney.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.test.base.Controller;

public class DisneySitepage extends Controller{

	//*[@id='goc-bar-left']/li[3]
	@FindBy(xpath="//*[@id='goc-bar-left']/li[3]")
	WebElement shopLink;
	
	@FindBy(className="goc-wide-link")
	WebElement disneyTitle;
	
	public DisneySitepage(){
		PageFactory.initElements(driver, this);
	}
	
	public String CheckPageTitle(){
		return driver.getTitle();
	}
	
	public boolean CheckDisneyLogo(){
		return disneyTitle.isDisplayed();
	}
	
	public ShopDisneyPage NavigateToShop() throws InterruptedException {
		Thread.sleep(10000);
		shopLink.click();
		return new ShopDisneyPage();
	}
	
}
