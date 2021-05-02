package April4.testInCompany;

import java.io.FileInputStream;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import April4.pages.AddUserPage;
import April4.pages.DashboardPage;
import April4.pages.LoginPage;
import April4.pages.RegisterPage;
import April4.pages.UserPage;
import jxl.Sheet;
import jxl.Workbook;

public class DaProvidRegister {
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
	
	@Test(priority=2,dataProvider="registerDetails")
	public void fillDetails(String userName,String mobile,String email,String password) {
		rp=lp.clickRegisterLink();		//login homepg--Register a New Membership
		rp.enterName(userName);		//RegisterPage
		rp.enterMobno(mobile);
		rp.enterUsername(email);
		rp.enterPassword(password);
		rp.clickLoginButton();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		rp.clickAlreadyAMember();
	}
	@DataProvider
	  public Object[][] registerDetails() throws Exception{
		  	FileInputStream fis = new FileInputStream("register.xls");	
			Workbook wb= Workbook.getWorkbook(fis);
			Sheet sh = wb.getSheet("registerData");
			int row=sh.getRows();
			int col=sh.getColumns();
			String dataArr[][]= new String[row-1][col];
			for(int i=1;i<row;i++) {
				for(int j=0;j<col;j++) {
					String data=sh.getCell(j,i).getContents();	
					dataArr[i-1][j]=data;
				}
			}
			return dataArr; //return of DataProvider method
			
	  }//terminte DataProvider method
	
	@Test(priority=3,dataProvider="addUserDetails")
	public void userpageTest(String name,String email,String mob,String course,String gender,String state,String pass) {
		dp=lp.validLogin();
		up=dp.clickUserBtn();
		ap=up.clickAddUser();
		ap.enterName(name);
		ap.enterMob(mob);
		ap.enterEmail(email);
		ap.enterCourse(course);
		ap.selectGenderRadioButton(gender);
		ap.selectByText(state);
		ap.enterPass(pass);
		ap.clickSubmitButton();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}
	@DataProvider
	  public Object[][] addUserDetails() throws Exception{
		  	FileInputStream fis = new FileInputStream("register.xls");	
			Workbook wb= Workbook.getWorkbook(fis);
			Sheet sh = wb.getSheet("data");
			int row=sh.getRows();
			int col=sh.getColumns();
			String dataArr[][]= new String[row-1][col];
			for(int i=1;i<row;i++) {
				for(int j=0;j<col;j++) {
					String data=sh.getCell(j,i).getContents();	
					dataArr[i-1][j]=data;
				}
			}
			return dataArr; //return of DataProvider method
			
	  }//terminte DataProvider method
}
