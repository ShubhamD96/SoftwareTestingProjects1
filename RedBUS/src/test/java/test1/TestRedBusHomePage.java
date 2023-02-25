package test1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom_classes.RedBusHomePage;



public class TestRedBusHomePage {
	//WebDriver
	
	public static void main(String[]args)
	{
System.setProperty("webdriver.chrome.driver", "C:\\software testing Selenium\\chromedriver_win32\\chromedriver.exe");
		
		
		WebDriver driverTest= new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driverTest.manage().window().maximize();
	
		driverTest.get("https://www.redbus.in/");
		
		RedBusHomePage redBusHomePage  = new RedBusHomePage (driverTest);
		/*
		redBusHomePage.sendFromInputData("pune");
		redBusHomePage.clickOnBusFromSelectFirstResult();
		redBusHomePage.sendToInputData("Mumbai");
		redBusHomePage.clickOnBusToSelectFirstResult();
		redBusHomePage.clickOnBusDateBox();
		redBusHomePage.clickOnBusDate();
		redBusHomePage.clickOnBusSearch();
		*/
		//redBusHomePage.clickOnbrandTrustReportOption();
		//ArrayList<String> a=new ArrayList<String>(driverTest.getWindowHandles());
		
	//	driverTest.switchTo().window(a.get(1));
		//System.out.println(driverTest.getCurrentUrl());
		
		//driverTest.switchTo().window(a.get(0));
		//redBusHomePage.clickOnbusinessStandardOption();
	
		redBusHomePage.clickOnbangaloreBusOption();
		
       ArrayList<String> b=new ArrayList<String>(driverTest.getWindowHandles());
		
		driverTest.switchTo().window(b.get(1));
		System.out.println(driverTest.getCurrentUrl());
		ArrayList<String> c=new ArrayList<String>(driverTest.getWindowHandles());
		driverTest.switchTo().window(c.get(0));
		System.out.println(driverTest.getCurrentUrl());
		driverTest.close();
		driverTest.get("https://www.redbus.in/");
		redBusHomePage.clickOnpuneBusOption();
		
	       ArrayList<String> d=new ArrayList<String>(driverTest.getWindowHandles());
			
			driverTest.switchTo().window(d.get(1));
			System.out.println(driverTest.getCurrentUrl());
			ArrayList<String> e=new ArrayList<String>(driverTest.getWindowHandles());
			driverTest.switchTo().window(e.get(0));
			System.out.println(driverTest.getCurrentUrl());
		
	}
	
	

}
