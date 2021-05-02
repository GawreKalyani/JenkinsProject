package April4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;

	public RegisterPage(WebDriver driver) 
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

@FindBy(xpath="//a[contains(text(),'I')]")
private WebElement alreadyMember;

public void enterName(String text){
	name.clear();
	name.sendKeys(text);
}
public void enterMobno(String text){
	mobile.clear();
	mobile.sendKeys(text);
}
public void enterUsername(String text) {
	uname.clear();
	uname.sendKeys(text);
}
public void enterPassword(String text) {
	pass.clear();
	pass.sendKeys(text);
}
public void clickLoginButton() {
	
	loginButton.click();
}
public void clickAlreadyAMember(){
	alreadyMember.click();
}

}
