package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage {

	public WebDriver driver;

	public homepage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By link= By.xpath("//a");
	
	
	public List<WebElement> link() {
		return driver.findElements(link);
	}
	
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	
}
