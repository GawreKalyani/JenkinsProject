package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPg {
WebDriver driver;

public DashboardPg(WebDriver driver) //every pg has constructor
{
	
	this.driver = driver;
	PageFactory.initElements(driver, this); //this points to current pg object
}


	@FindBy(xpath="//a[text()='LOGOUT']")
	private WebElement logoutButton;

	@FindBy(xpath="//span[text()='Users']")
	private WebElement users;

	
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
	public void clickUsers(){
		users.click();
	}
}
