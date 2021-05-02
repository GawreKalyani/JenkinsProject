package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) //constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//button")
	private WebElement loginButton;
	
	
	@FindBy(partialLinkText="Register")
	private WebElement registerLink;

	public void enterUserName(String text){
		uname.sendKeys(text);
	}
	public void enterPassword(String text){
		pass.sendKeys(text);
	}
	public void clickLoginButton(){
		loginButton.click();
		
	}
	
	public void clickRegisterlink(){
		registerLink.click();
	}
}
