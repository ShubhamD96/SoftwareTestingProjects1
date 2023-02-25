package test1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScrrenShotOfResBus {
	public static void main(String[]args) throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\software testing Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		Random random=new Random ();
		int a=random.nextInt();
		SimpleDateFormat b=new SimpleDateFormat("dd-MM-yyyy HH mm ss");
		Date date= new Date();
		String c=b.format(date);
		System.out.println(c);
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("D:\\selenium_screenshot\\Test"+(a)+  (c)+".png");
	FileHandler.copy(src, dest);
	
	}


	
	
	

}
