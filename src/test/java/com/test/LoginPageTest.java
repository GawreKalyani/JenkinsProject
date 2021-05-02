package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DashboardPg;
import com.pages.LoginPage;
import com.pages.RegisterPg;

public class LoginPageTest {
WebDriver driver;
LoginPage lp=null;
DashboardPg dp=null;
RegisterPg rp=null;

	@BeforeSuite
	public void setUp(){
		driver=A.initialization();
		lp=new LoginPage(driver);
		dp=new DashboardPg(driver);
		rp=new RegisterPg(driver);
	}


	@Test(priority=1)
	public void loginTestcase() throws Exception{
		lp.enterUserName("kiran@gmail.com");
		lp.enterPassword("123456");
		lp.clickLoginButton();
		Thread.sleep(2000);
		dp.clickLogoutButton();
	}

	@Test(priority=2)
	public void registerNewMember(){
		lp.clickRegisterlink();
		rp.enterName("Afsana Sheik");
		rp.enterMobno("9444444444");
		rp.enterUserName("afsana@gmail.com");
		rp.enterPassword("345555");
		rp.clickLoginButton();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}
}
