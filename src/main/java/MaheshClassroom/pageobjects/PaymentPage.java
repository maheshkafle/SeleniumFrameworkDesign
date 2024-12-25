package MaheshClassroom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MaheshClassroom.Abstractcomponents.Abstractcomponent;

public class PaymentPage extends Abstractcomponent
{
	WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="(//button[contains(@class, 'ta-item')])[2]")
	WebElement countryName;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".actions .action__submit")
	WebElement placeOrderButton;
	
	By searchList = By.cssSelector(".ta-results");
	
	public OrderHistoryPage gotoOrderHistoryPage()
	{
		placeOrderButton.click();
		OrderHistoryPage OrderHistoryPage = new OrderHistoryPage(driver);
		return OrderHistoryPage;
	}
	
	public void SelectCountry()
	{
		Actions act = new Actions(driver);
		act.sendKeys(selectCountry, "india").build().perform();		
		waitForElementToAppear(searchList);
		countryName.click();	
	}	
	
}
