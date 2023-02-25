package test1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import pom_classes.RedBusHomePage;
import pom_classes.RedRailwaySearchPage;

public class TestRedRailwaySearchPage {

	public static void main(String[]args) throws IOException, InterruptedException 
	{
System.setProperty("webdriver.chrome.driver", "C:\\software testing Selenium\\chromedriver_win32\\chromedriver.exe");
		
		
		WebDriver driverTest= new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driverTest.manage().window().maximize();
	
		driverTest.get("https://www.redbus.in/");
		
		Random random=new Random ();
		int a=random.nextInt();
		SimpleDateFormat b=new SimpleDateFormat("dd-MM-yyyy HH mm ss");
		Date date= new Date();
		String c=b.format(date);
		System.out.println(c);
		TakesScreenshot ts=(TakesScreenshot)driverTest;
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("D:\\selenium_screenshot\\RedBusHomePage"+(a)+  (c)+".png");
	FileHandler.copy(src, dest);
	
		RedBusHomePage redBusHomePage=new RedBusHomePage(driverTest);
		redBusHomePage.clickOnRedRailNewPage();
		
		File src1=ts.getScreenshotAs(OutputType.FILE);
		
		File dest1=new File("D:\\selenium_screenshot\\RedBusRailwayPage"+(a)+  (c)+".png");
		FileHandler.copy(src1, dest1);
		RedRailwaySearchPage  redRailwaySearchPage= new RedRailwaySearchPage(driverTest);
		 redRailwaySearchPage.sendFromInputData("Pune");
		// Thread.sleep(3000);
		 redRailwaySearchPage.clickOnRailFromSelectFirstResult();
		 redRailwaySearchPage.sendToInputData("Mumbai");
		 
		
		// Thread.sleep(3000);
		 redRailwaySearchPage.clickOnRailToSelectFirstResult();
		 redRailwaySearchPage.clickOnRailDateBox();
		 redRailwaySearchPage.clickOnRailDate();
		 File src2=ts.getScreenshotAs(OutputType.FILE);
			
			File dest2=new File("D:\\selenium_screenshot\\RedBusRailwaySelectDataPage"+(a)+  (c)+".png");
			FileHandler.copy(src2, dest2);
		 
		 redRailwaySearchPage.clickRailSearch();
		 Thread.sleep(3000);
		 File src3=ts.getScreenshotAs(OutputType.FILE);
			
			File dest3=new File("D:\\selenium_screenshot\\RedBusRailwayListOfTrain"+(a)+  (c)+".png");
			FileHandler.copy(src3, dest3);
		
		
	}
}
