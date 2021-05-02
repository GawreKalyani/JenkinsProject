package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPg {
WebDriver driver;

public UserPg(WebDriver driver) {
	
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//button[text()='Add User']")
private WebElement addUserButton;

public void clickAddUser(){
	addUserButton.click();
}

}
