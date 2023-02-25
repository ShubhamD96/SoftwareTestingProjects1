package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedRailwaySearchPage {
	
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement fromStationButton;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement  ToStationButton;
	
	@FindBy(xpath="(//div[@class='stn_code'])[1] ")
	private WebElement RailFromSelectFirstResult;
	
	@FindBy(xpath="//div[@class='home_calendar'] ")
	private WebElement dateBox;
	
	@FindBy(xpath="//span[text()='3']")
	private WebElement enterDate;
	
	@FindBy(xpath="(//div[@class='stn_code'])[1]")
	private WebElement RailToSelectFirstResult;
	

	@FindBy(xpath="//button[@class='search-btn ']")
	private WebElement RailSearchOption;
	
	 private WebDriver driver;
	
	public  RedRailwaySearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendFromInputData(String source) 
	{
		fromStationButton.sendKeys(source);
		
	}

	
	public void sendToInputData(String Destination) 
	{
		ToStationButton.sendKeys( Destination);
		
	}
	
	public void  clickOnRailFromSelectFirstResult() throws InterruptedException 
	{
		Thread.sleep(1000);
		RailFromSelectFirstResult.click();
		
	}
	public void  clickOnRailToSelectFirstResult() throws InterruptedException 
	{
		Thread.sleep(3000);
		RailToSelectFirstResult.click();
	}
	
	public void  clickOnRailDateBox()
	{
		dateBox.click();
	}
	public void  clickOnRailDate()
	{
		
		enterDate.click();
	}
	
	public void  clickRailSearch()
	{
		 RailSearchOption.click();
	}
	
	

}
