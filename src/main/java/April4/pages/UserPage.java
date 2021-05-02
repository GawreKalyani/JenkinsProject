package April4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Add User']")
	private WebElement addUserButton;

	public AddUserPage clickAddUser(){
		addUserButton.click();
		return new AddUserPage(driver);
	}

	
}
