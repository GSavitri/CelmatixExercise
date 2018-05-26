package Celmatix.ToDoApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	WebDriver driver;
	String driverpath =System.getProperty("user.dir") ;
	
	/**
	 * Method Name:launchApplication
	 * Description: Method initializes the driver,Launches Web Browser,
	 * 				Launches application and Maximizes the browser screen.
	 * 				This method runs before executing first test case in the test suite
	 * Author: Savitri
	 * Input:None 
	 * Output:None
	 */
	@BeforeTest
	public void launchApplication()
	{		
		driver = initializeDriver();
		driver.get("http://todomvc.com/examples/react/#/");
		driver.manage().window().maximize();
		System.out.println("Application launched");
	}
	
	
	/**
	 * Method Name:initializeDriver
	 * Description: Method reads the browser type from data.properties file
	 * 			    and initializes the driver object with specified driver
	 * Author: Savitri
	 * Input:None 
	 * Output:Web driver object
	 */
	public WebDriver initializeDriver()
	{	
		try {
			Properties pro=new Properties();
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Celmatix/ToDoApp/data.properties");
			pro.load(fs);
			String browser = pro.getProperty("Browser");
			if(browser.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",driverpath+"/Drivers/chromedriver");
				 driver=new ChromeDriver();
			}
			else if(browser.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver",driverpath+"/Drivers/geckodriver");
				 driver = new FirefoxDriver();	
			}
			else if(browser.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver",driverpath+"/Drivers/geckodriver");
				 driver = new FirefoxDriver();	
			}
			else
			{
				System.out.println("Please check browser in name in data.properties file");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	/**
	 * Method Name:CloseApplication
	 * Description: Closes the browser.
	 * 				This method is run after all test cases are run.
	 * Author: Savitri
	 * Input:None 
	 * Output:Web driver object
	 */
	@AfterTest
	public void CloseApplication()
	{
		driver.close();
		System.out.println("Application Closed");
	}
}
