package redBusTestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom_classes.RedBusHomePage;

public class RedBusHomePageTestNGSuite1 {
	WebDriver driver;
	RedBusHomePage redBusHomePage;
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBowser(String browsername)
	{
		
		if( browsername.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Software Testing Selenium2\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions  options=new ChromeOptions();
			options.addArguments("disable-notifications");
			 driver= new ChromeDriver(options);
		 
		 
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
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void pomClassObject()
	{
		redBusHomePage  = new RedBusHomePage (driver);
	}
	
	@BeforeMethod
	public void redBusHomePage()
	{
		driver.get("https://www.redbus.in/");
	}
	
@Test
	
	public void SearchBus() throws InterruptedException
	{
	Thread.sleep(3000);
		//System.out.println("test");
	//	RedBusHomePage redBusHomePage  = new RedBusHomePage (driver);
		redBusHomePage.sendFromInputData("pune");
		Thread.sleep(2000);
		redBusHomePage.clickOnBusFromSelectFirstResult();
		Thread.sleep(2000);
		redBusHomePage.sendToInputData("Mumbai");
		Thread.sleep(2000);
		redBusHomePage.clickOnBusToSelectFirstResult();
		redBusHomePage.clickOnBusDateBox();
		redBusHomePage.clickOnBusDate();
		redBusHomePage.clickOnBusSearch();
		Thread.sleep(2000);
		String actual =driver.getCurrentUrl();
		String expected ="https://www.redbus.in/bus-tickets/pune-to-mumbai?fromCityName=Pune&fromCityId=130&to"
				+ "CityName=Mumbai&toCityId=462&onward=14-Feb-2023&srcCountry=IND&destCountry=I"
				+ "ND&opId=0&busType=Any";
		if(actual.equals(expected))
		{
			System.out.println("Pass");
			System.out.println(actual);
		}
		
		else
		{
			System.out.println("Fail");
			System.out.println(actual);
		}
	}

    @Test 
     public void toVerifyHydrabadBusTicketsLink() throws InterruptedException
     { 
    	
    	redBusHomePage.clickOnhyderabadBusOption();
    	Thread.sleep(3000);
    	ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actual =driver.getCurrentUrl();
		String expected ="https://www.redbus.in/buses/hyderabad-bus-tickets";
		if(actual.equals(expected))
		{
			System.out.println("Pass");
			System.out.println(actual);
		}
		
		else
		{
			System.out.println("Fail");
			System.out.println(actual);
		}
    	
     }
    @Test 
    public void toVerifyBangloreBusTicketsLink() throws InterruptedException
    { 

    	
    	redBusHomePage.clickOnbangaloreBusOption();
    	Thread.sleep(3000);
    	ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actual =driver.getCurrentUrl();
		String expected ="https://www.redbus.in/buses/bangalore-bus-tickets";
		if(actual.equals(expected))
		{
			System.out.println("Pass");
			System.out.println(actual);
		}
		
		else
		{
			System.out.println("Fail");
			System.out.println(actual);
		}
    }
    
    @AfterMethod
    public void goTOHomePage() 

	
    { 
    	driver.close();
    //	ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		//driver.switchTo().window(addr.get(0));
    	driver.get("https://www.redbus.in/");
    	
    }
    
    
    @AfterClass
    public void clearPOMObj()
    {
    	redBusHomePage= null;
    }
    
    @AfterTest
	public void closedBrowser()
	{
		driver.close();
		driver=null;
		System.gc(); 
	}

	
}
