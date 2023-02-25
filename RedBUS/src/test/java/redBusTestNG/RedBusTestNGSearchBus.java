package redBusTestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_classes.RedBusHomePage;
import pom_classes.RedRailwaySearchPage;

public class RedBusTestNGSearchBus {
	WebDriver driverTest;
	@BeforeClass
	public void launchBrowser()
	{
	//	System.out.println("beforeclass");
     System.setProperty("webdriver.chrome.driver", "C:\\Software Testing Selenium2\\chromedriver_win32\\chromedriver.exe");
		
     ChromeOptions  options=new ChromeOptions();
		options.addArguments("disable-notifications");
		 driverTest= new ChromeDriver(options);
		driverTest.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driverTest.manage().window().maximize();
	
	}
	@BeforeMethod
	public void redBusHomePage()
	{
		//System.out.println("beforemethod");
		driverTest.get("https://www.redbus.in/");
	}
	
	@Test
	
	public void SearchBus()
	{
		//System.out.println("test");
		RedBusHomePage redBusHomePage  = new RedBusHomePage (driverTest);
		redBusHomePage.sendFromInputData("pune");
		redBusHomePage.clickOnBusFromSelectFirstResult();
		redBusHomePage.sendToInputData("Mumbai");
		redBusHomePage.clickOnBusToSelectFirstResult();
		redBusHomePage.clickOnBusDateBox();
		redBusHomePage.clickOnBusDate();
		redBusHomePage.clickOnBusSearch();
	
		 String text =driverTest.getTitle();
		  boolean r= text.equals("Log in to Facebook");
			if(r==true )
			{
				System.out.println("Pass");
				System.out.println(text);
			}
			else
			{
				System.out.println("Fail");
				System.out.println(text);
			//	System.out.println(text);
			}
		

	      	 
		
	}
	
	
	
 @Test
 public void searchTrain() throws InterruptedException
 {
	 RedBusHomePage redBusHomePage=new RedBusHomePage(driverTest);
		redBusHomePage.clickOnRedRailNewPage(); 
	 
	
		RedRailwaySearchPage  redRailwaySearchPage= new RedRailwaySearchPage(driverTest);
		 redRailwaySearchPage.sendFromInputData("Pune");
		 
		 redRailwaySearchPage.clickOnRailFromSelectFirstResult();
		 redRailwaySearchPage.sendToInputData("Mumbai");
		 
		 redRailwaySearchPage.clickOnRailToSelectFirstResult();
		 redRailwaySearchPage.clickOnRailDateBox();
		 redRailwaySearchPage.clickOnRailDate();
		 
		 redRailwaySearchPage.clickRailSearch();
 }
 
 
	
 @AfterMethod
	public void aftermethod()
	{
		//driverTest.get("https://www.redbus.in/");
	}
	
	
	@AfterClass
	public void quitBrowser()
	{
		//driverTest.quit();
	}
	

}
