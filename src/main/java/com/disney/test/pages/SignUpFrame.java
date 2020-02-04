package com.disney.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disney.test.base.Controller;
import com.disney.test.util.ShopPageData;

public class SignUpFrame extends Controller{
	
	
	@FindBy(xpath = "//a[contains(text(), 'Create an Account')]")
	WebElement createAccountButton;
	
	@FindBy(xpath = "//input[@type='text' and @name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@type='text' and @name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@type='password' and @name='newPassword']")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='password' and @name='verifyPassword']")
	WebElement verifyPassword;
	
	@FindBy(xpath = "//input[@type='tel' and @name='dateOfBirth']")
	WebElement dateOfBirth;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;
	
	//Initialize page elements
	public SignUpFrame(){
		PageFactory.initElements(driver, this);
	}
	
    //Actions
	
	public void clickCreateAccount(){
		createAccountButton.click();
	}
	
	public void createNewAccount(String fname, String lname, String email, String pw, 
			String vpw, String dob ) {
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		Email.sendKeys(email);
		password.sendKeys(pw);
		verifyPassword.sendKeys(vpw);
		dateOfBirth.sendKeys(dob);
		submitButton.click();
		
	}
	
	public ShopDisneyPage clickContinue() {
		
		continueButton.click();
		return new ShopDisneyPage();
	}
	
}
