package locatar;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Selectclass {
	@Test
	public void test()throws Exception{
	WebDriver driver;
	System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.manage().window().maximize();
driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");	
driver.findElement(By.id("password")).sendKeys("123456");
driver.findElement(By.xpath("//button")).click();
driver.findElement(By.xpath("//span[text()='Users']")).click();
driver.findElement(By.xpath("//button[text()='Add User']")).click();

Select state=new Select(driver.findElement(By.tagName("select")));
state.selectByValue("Maharashtra");
state.selectByValue("Delhi");
state.selectByValue("Punjab");
state.selectByValue("HP");

state.selectByVisibleText("Maharashtra");
state.selectByVisibleText("Delhi");
state.selectByVisibleText("HP");
state.selectByVisibleText("Punjab");

List<WebElement>listofoption=state.getOptions();

	for(WebElement option:listofoption){
		System.out.println(option.getText());
	}
	
	//Radio Button
	WebElement radiomale=driver.findElement(By.id("Male"));
	//boolean male=radiomale.isSelected();//
	
	WebElement radiofemale=driver.findElement(By.id("Female"));
	//boolean female=radiofemale.isSelected();
	 
	radiofemale.click();
	if(radiomale.isSelected())
	{
		System.out.println("Male selected");
	}
	else
	{
		System.out.println("FeMale selected");
	}
}
}
