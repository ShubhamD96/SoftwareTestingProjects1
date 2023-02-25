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

public class RedBusHomePageTestNGSuite2 {
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
			// driverTest= new ChromeDriver(options);
		
		 driver=new ChromeDriver(options);
		 
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
	}
	
	@BeforeMethod
	public void redBusHomePage()
	{
		driver.get("https://www.redbus.in/");
	}
	
	  @Test 
	     public void toverifyChennaiBusTicketsLink() throws InterruptedException
	     { 
		 
		  redBusHomePage.clickOnchennaiBusOption();
		  Thread.sleep(3000);
		  ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			String actual =driver.getCurrentUrl();
			String expected ="https://www.redbus.in/buses/chennai-bus-tickets";
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
	    public void toVerifyPuneBusTicketsLink() throws InterruptedException
	    { 
	    	redBusHomePage.clickOnpuneBusOption();
	    	Thread.sleep(3000);
	    	ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			String actual =driver.getCurrentUrl();
			String expected ="https://www.redbus.in/buses/pune-bus-tickets";
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
	     public void toVerifyBrandTrustReportLink() throws InterruptedException
	     
	     { 
	    	
	    	redBusHomePage.clickOnbrandTrustReportOption();
	    	Thread.sleep(3000);
	    	ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			String actual =driver.getCurrentUrl();
			String expected ="https://thebrandtrustreport.wordpress.com/tag/redbus-in/";
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
	  /*  
	    @Test 
	    public void toVerifyBusinessStandardLink() throws InterruptedException
	    {  
	    	Thread.sleep(3000);
	    	redBusHomePage.clickOnbusinessStandardOption();
	    	ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(1));
			String actual =driver.getCurrentUrl();
			String expected ="";
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
			
	    }*/
	    
	    @AfterMethod
	    public void goTOHomePage() throws InterruptedException
	   
	    { 
	    	 driver.close();
	    	
	    	
	    	ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(0));
	    	
	    }
	    
	    @AfterClass
	    public void clearPOMObj()
	    {
	    	redBusHomePage= null;
	    }
	    
	    @AfterTest
		public void closedBrowser()
		{
			driver.quit();
			driver=null;
			System.gc(); 
		}
}
