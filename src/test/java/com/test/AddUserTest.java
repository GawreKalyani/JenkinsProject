package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.ADDUserPg;
import com.pages.DashboardPg;
import com.pages.LoginPage;
import com.pages.UserPg;


public class AddUserTest {
WebDriver driver;
LoginPage lp=null;
DashboardPg dp=null;
UserPg up=null;
ADDUserPg ap=null;

@BeforeSuite
public void setUp(){
	driver=A.initialization();
	lp=new LoginPage(driver);
	dp=new DashboardPg(driver);
	up=new UserPg(driver);
	ap=new ADDUserPg(driver);
}

@Test
public void addUsersTestCase(){
	lp.enterUserName("kiran@gmail.com");
	lp.enterPassword("123456");
	lp.clickLoginButton();
	dp.clickUsers();
	up.clickAddUser();
	
	ap.enterName("Afsana Sheik");
	ap.enterMob("9833336732");
	ap.enterEmail("afsana@gmail.com");
	ap.enterCourse("java");
	ap.selectGenderRadioButton("Female");
	ap.selectByText("HP");
	ap.enterPass("oppp");
	ap.clickSubmitButton();
	Alert al=driver.switchTo().alert();
	al.accept();
}







}
