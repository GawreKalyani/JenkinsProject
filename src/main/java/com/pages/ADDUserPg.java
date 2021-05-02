package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ADDUserPg {
	WebDriver driver;
	
	public ADDUserPg(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="mobile")
	private WebElement mob;

	@FindBy(id="course")
	private WebElement course;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//input[@value='Male']")
	private WebElement maleradio;

	@FindBy(xpath="//input[@value='Female']")
	private WebElement femaleradio;
	
	@FindBy(xpath="//select")
	private WebElement selectstate;

	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbutton;
	
	public void selectGenderRadioButton(String gender){
		if(gender.equals("Male"))
		maleradio.click();
		else
			femaleradio.click();
	}
	
	
	
	public void enterName(String text){
		username.sendKeys(text);	
	}
	public void enterMob(String text){
		mob.sendKeys(text);	
	}
	public void enterEmail(String text){
		email.sendKeys(text);	
	}
	public void enterPass(String text){
		pass.sendKeys(text);	
	}
	public void enterCourse(String text){
		course.sendKeys(text);	
	}
	public void selectByText(String text){
		Select state=new Select(selectstate);
		state.selectByVisibleText(text);
	}
	
	
	public void clickSubmitButton(){
		submitbutton.click();
	}
}
