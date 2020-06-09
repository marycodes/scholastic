package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;

public class Driver {
//invoking driver
	//creating common utility
	public WebDriver driver;
	//scoping for loginpage
	public WebDriver logindriver;
	public Properties prop;

		public WebDriver Initialisebrowser() throws IOException
		{
			//chrome

			prop=new Properties();
			FileInputStream f = new FileInputStream("C:\\Users\\Kavitha Devasagayam\\eclipse-workspace\\scholastic\\src\\main\\java\\resource\\data.properties");
			prop.load(f);
			String browsername=prop.getProperty("browser");
			System.out.println(browsername);

			if(browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Kavitha Devasagayam\\Desktop\\webdriver\\chromedriver.exe");
                driver=new ChromeDriver();
                driver.manage().window().maximize();

			}
			else if(browsername.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Kavitha Devasagayam\\eclipse-workspace\\scholastic\\src\\main\\java\\resource\\geckodriver.exe");
				 driver=new FirefoxDriver();
				 driver.manage().window().maximize();
			}
			else if(browsername.equalsIgnoreCase("internetexplorer"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Kavitha Devasagayam\\eclipse-workspace\\scholastic\\src\\main\\java\\resource\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
			}

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;


			}


		public void getScreenshot(String result) throws IOException{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("C:\\Users\\Kavitha Devasagayam\\Pictures\\Screenshots\\"+result+".jpeg"));
		}

}
