package April4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

		WebDriver driver;
		
		@FindBy(id="email")
		private WebElement uname;
		
		@FindBy(id="password")
		private WebElement pass;
		
		@FindBy(xpath="//button")
		private WebElement loginButton;
		
		@FindBy(partialLinkText="Register")
		private WebElement registerLink;
		
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		public RegisterPage clickRegisterLink() {
			registerLink.click();
			return new RegisterPage(driver);
		}
		
		public void enterUsername(String text) {
			uname.sendKeys(text);
		}
		public void enterPassword(String text) {
			pass.sendKeys(text);
		}
		public void clickLoginButton() {
			loginButton.click();
		}
		
		public DashboardPage validLogin() {
			enterUsername("kiran@gmail.com");
			enterPassword("123456");
			clickLoginButton();
			return new DashboardPage(driver);
		}
		
}
