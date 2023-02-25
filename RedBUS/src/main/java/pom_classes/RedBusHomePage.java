package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBusHomePage {
	@FindBy(xpath="//input[@data-message='Please enter a source city']")
	private WebElement busFromButton;
	
	@FindBy(xpath="//input[@data-message='Please enter a destination city']")
	private WebElement busToButton;
	
	@FindBy(xpath="//li[@select-id='results[0]']")
	private WebElement busFromSelectFirstResult;
	
	@FindBy(xpath=" // input[@id='onward_cal']")
	private WebElement dateBox;
	
	@FindBy(xpath="//td[text()='14']  ")
	private WebElement enterDate;
	
	@FindBy(xpath="//li[@select-id='results[0]']")
	private WebElement busToSelectFirstResult;
	

	@FindBy(xpath="//button[ text()='Search Buses']")
	private WebElement busSearchOption;
	
	@FindBy(xpath=" //a[@id='redRail']")
	private WebElement redRailOption;
	
	@FindBy(xpath="//a[@title='Hyderabad Bus Tickets'] ")
	private WebElement hyderabadBusOption;
	
	@FindBy(xpath="//a[@title='Bangalore Bus Tickets'] ")
	private WebElement bangaloreBusOption;
	
	@FindBy(xpath=" //a[@title='Chennai Bus Tickets']")
	private WebElement chennaiBusOption;
	
	@FindBy(xpath=" //a[@title='Pune Bus Tickets']")
	private WebElement puneBusOption;
	
	@FindBy(xpath="     (//div[@class='imgCont'] )[1]")
	private WebElement businessStandardOption;
	
	@FindBy(xpath="  (//div[@class='imgCont'] )[2]")
	private WebElement brandTrustReportOption;
	
	private WebDriver driver ;
	
	public  RedBusHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendFromInputData(String source)
	{
		 busFromButton.sendKeys(source);
	}

	
	public void sendToInputData(String destination)
	{
		busToButton.sendKeys(destination);
	}
	
	public void  clickOnBusFromSelectFirstResult()
	{
		 busFromSelectFirstResult.click();
	}
	public void  clickOnBusToSelectFirstResult()
	{
		busToSelectFirstResult.click();
	}
	
	public void  clickOnBusDateBox()
	{
		dateBox.click();
	}
	public void  clickOnBusDate()
	{
		 enterDate.click();
	}
	
	public void  clickOnBusSearch()
	{
		 busSearchOption.click();
	}
	
	public void  clickOnRedRailNewPage()
	{
		redRailOption.click();
	}
	
	public void  clickOnhyderabadBusOption()
	{
		 hyderabadBusOption.click();
	}
	public void  clickOnbangaloreBusOption()
	{
		bangaloreBusOption.click();
	}
	public void  clickOnchennaiBusOption()
	{
		chennaiBusOption.click();
	}
	public void  clickOnpuneBusOption()
	{
		puneBusOption.click();
	}
	public void  clickOnbusinessStandardOption()
	{
		businessStandardOption.click();
	}
	public void  clickOnbrandTrustReportOption()
	{
		brandTrustReportOption.click();
	}
}
