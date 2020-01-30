package com.disney.test.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.test.base.Controller;

public class ShopDisneyPage extends Controller{

	public static String BEFORE_XPATH ="/html/body/div[1]/header/nav/div/div[2]/div/div/nav/div[2]/ul/li[";
	public static String AFTER_XPATH ="]/a";
	
	@FindBy(className="user-message")
	WebElement singIn;
	
	@FindBy(xpath="//a[@class='signout']")
	WebElement logout;
	
	public ShopDisneyPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String CheckPageTitle(){
		return driver.getTitle();
	}
	
	//Actions
	
	public void clickSignIn() {
		singIn.click();
	}
	
	
	public void clickLogOut() {
		logout.click();
	}
	
}
