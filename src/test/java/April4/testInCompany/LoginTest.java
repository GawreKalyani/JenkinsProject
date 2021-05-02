 package April4.testInCompany;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import April4.pages.AddUserPage;
import April4.pages.DashboardPage;
import April4.pages.LoginPage;
import April4.pages.RegisterPage;
import April4.pages.UserPage;

public class LoginTest {
	WebDriver driver;
	LoginPage lp=null;
	DashboardPage dp=null;
	RegisterPage rp=null;
	UserPage up=null;
	AddUserPage ap=null;
	
	@BeforeSuite
	public void setUp() 
	{
		driver= TestBase.initialization();
	    lp= new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loginTestCase() {
		
		dp=lp.validLogin();         //login peformed
		dp.clickLogout();			//DashboardPg--LogoutButton
	}
	
	@Test(priority=2)
	public void registerTest() {
		rp=lp.clickRegisterLink();		//login homepg--Register a New Membership
		rp.enterName("Ruhani");		//RegisterPage
		rp.enterMobno("9992221110");
		rp.enterUsername("ruhani@gmail.com");
		rp.enterPassword("r1234hani");
		rp.clickLoginButton();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		rp.clickAlreadyAMember();
		
	}
	@Test(priority=3)
	public void userpageTest() {
		dp=lp.validLogin();
		up=dp.clickUserBtn();
		ap=up.clickAddUser();
		ap.enterName("Saloni");
		ap.enterMob("8999995521");
		ap.enterEmail("saloni@gmail.com");
		ap.enterCourse("Java");
		ap.selectGenderRadioButton("Female");
		ap.selectByText("HP");
		ap.enterPass("salon123");
		ap.clickSubmitButton();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		dp.clickLogout();
	}
}
