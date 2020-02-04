package com.disney.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.test.base.Controller;
import com.disney.test.util.DisneyTestUtility;

public class ShopDisneyPage extends Controller{

	public static String BEFORE_XPATH ="/html/body/div[1]/header/nav/div/div[2]/div/div/nav/div[2]/ul/li[";
	public static String AFTER_XPATH ="]/a";
	String xpath= "//a[@class='nav-link dropdown-toggle' and @id='vacation']";
	//@FindBy(xpath="//a[@class='nav-link dropdown-toggle' and @id='vacation']")
	//WebElement centerNavElements;
	
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
	
	/*public String getCenterNavElements() {
		String ele1 = centerNavElements.getText();
		return ele1;
	}*/
	
	public void clickSignIn() {
		singIn.click();
	}
	
	public  List<String> getNavElements(String xpath)
	{
		List<String> elements = new ArrayList<String>();
		List<WebElement> items = driver.findElements(By.xpath(xpath));
		for (int i=2; i<items.size(); i++) {
		elements.add(items.get(i).getText());
		}
		
		return elements;
	}
	
	public void clickLogOut() {
		logout.click();
	}
	
}
