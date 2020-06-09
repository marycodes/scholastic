package project.scholastic;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.homepage;


public class HomePage extends resource.Driver{

	//public static Logger log=LogManager.getLogger(Driver.class.getName());
@BeforeTest
	public void initalise() throws IOException{
		driver=Initialisebrowser();
//log.info("Browser invoked");
	}

@Test
public void Home() {
	driver.get("https://www.scholastic.com/");
	
	homepage h=new homepage(driver);
	List<WebElement> totallink=h.link();
	System.out.println(h.gettitle());
	System.out.println(totallink.size());
	for(WebElement temp:totallink) {
		System.out.println(temp.getText());
	}
	
	
	
}
	
	/*

@Test(dataProvider=("getData"))
	public void Home(String username,String password) throws IOException
	{
	//create an object for the class to be accessed
	//can also use inheritance
	driver.get(prop.getProperty("url"));
	LandingPage obj=new LandingPage(driver);
WebElement a=obj.getsignin();
WebElement b=obj.getDropdown();
//System.out.println(a);
	//obj.getPhone().click();
	Actions s=new Actions(driver);
	s.moveToElement(a).build().perform();
s.moveToElement(b).click().build().perform();
log.info("My Account icon clicked");

logindriver=login();
myVerizonlogin myz=new myVerizonlogin(logindriver);
//myz.getUsernametext().click();
myz.getUsernametext().sendKeys(username);
log.info("username entered");
myz.passwordboxtext().click();
myz.passwordboxtext().sendKeys(password);
log.info("password entered");
myz.getsubmit().click();
//System.out.println(driver.switchTo().alert().getText());
	}
@DataProvider
public Object[][] getData()
{
	//if you declare it as object[1][1] there is an array out of bound exception - coz if its one the value expected is one but we are pasing 2 values
	Object[][] data=new Object[2][2];
	data[0][0]="Mary";
	data[0][1]="password";
	data[1][0]="Keshav";
	data[1][1]="1234";
	return data;
} */
@AfterTest
public void TearDown()
{
	driver.close();
	driver=null;
}
}


