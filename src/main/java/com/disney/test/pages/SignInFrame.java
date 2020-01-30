package com.disney.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.test.base.Controller;

public class SignInFrame extends Controller {

	@FindBy(xpath="//input[@type='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password'")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In'")
	WebElement signInBtn;
	
	public SignInFrame(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void createNewAccount(String uname, String pwd) {
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signInBtn.click();
		
	}
	
	
}
