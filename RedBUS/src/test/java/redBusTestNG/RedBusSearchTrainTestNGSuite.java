package redBusTestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom_classes.RedBusHomePage;
import pom_classes.RedRailwaySearchPage;

public class RedBusSearchTrainTestNGSuite {
	WebDriver driver;
	RedBusHomePage redBusHomePage;
	RedRailwaySearchPage  redRailwaySearchPage;
	@Parameters ("browser")
	@BeforeTest
	public void launchBowser(String browsername)
	{
		
		if( browsername.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Software Testing Selenium2\\chromedriver_win32\\chromedriver.exe");
		
		 driver=new ChromeDriver();
		 
		}
		if( browsername.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\software testing Selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		
		 driver=new FirefoxDriver();
		 
		}
		if( browsername.equals("Edge"))
		{
		System.setProperty("webdriver.edge.driver", "C:\\software testing Selenium\\edgedriver_win64\\msedgedriver.exe");
		
		 driver=new EdgeDriver();
		 
		}
		
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void pomClassObject()
	{
		redBusHomePage  = new RedBusHomePage (driver);
		  redRailwaySearchPage= new RedRailwaySearchPage(driver);
	}
	
	@BeforeMethod
	public void redBusHomePage()
	{
		driver.get("https://www.redbus.in/");
	}
	
	@Test
	 public void searchTrain() throws InterruptedException
	 {
		// RedBusHomePage redBusHomePage=new RedBusHomePage(driverTest);
			redBusHomePage.clickOnRedRailNewPage(); 
		 
		
		//	RedRailwaySearchPage  redRailwaySearchPage= new RedRailwaySearchPage(driver);
			 redRailwaySearchPage.sendFromInputData("Pune");
			 
			 redRailwaySearchPage.clickOnRailFromSelectFirstResult();
			 redRailwaySearchPage.sendToInputData("Mumbai");
			 
			 redRailwaySearchPage.clickOnRailToSelectFirstResult();
			 redRailwaySearchPage.clickOnRailDateBox();
			 redRailwaySearchPage.clickOnRailDate();
			 
			 redRailwaySearchPage.clickRailSearch();
				System.out.println(driver.getCurrentUrl());
	 }
	
	 @AfterMethod
	    public void goTOHomePage()
	    {  ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
	    	driver.get("https://www.redbus.in/");
	    }
	  @AfterClass
	    public void clearPOMObj()
	    {
	    	redBusHomePage= null;
	    	redRailwaySearchPage=null;
	    }
	    
	    @AfterTest
		public void closedBrowser()
		{
			driver.quit();
			driver=null;
			System.gc(); 
		}
}
