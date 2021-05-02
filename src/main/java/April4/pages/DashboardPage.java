package April4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DashboardPage {
	
	WebDriver driver;

	public DashboardPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="LOGOUT")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//span[text()='Users']")
	private WebElement userBtn;
	
	public UserPage clickUserBtn() {
		userBtn.click();
		return new UserPage(driver);
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
	
	
}