package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPg {
WebDriver driver;

public RegisterPg(WebDriver driver) 
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="name")
private WebElement name;

@FindBy(id="mobile")
private WebElement mobile;

@FindBy(id="email")
private WebElement uname;

@FindBy(id="password")
private WebElement pass;

@FindBy(xpath="//button")
private WebElement loginButton;

public void enterName(String text){
	name.sendKeys(text);
}
public void enterMobno(String text){
	mobile.sendKeys(text);
}
public void enterUserName(String text){
	uname.sendKeys(text);
}
public void enterPassword(String text){
	pass.sendKeys(text);
}
public void clickLoginButton(){
	loginButton.click();
}


}
