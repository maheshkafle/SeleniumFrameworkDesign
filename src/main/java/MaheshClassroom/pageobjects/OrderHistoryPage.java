package MaheshClassroom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderHistoryPage 
{

	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	By confirmationtextDiv = By.cssSelector("h1.hero-primary");
	
	public String GetConfirmationText()
	{
		String confirmationText = driver.findElement(confirmationtextDiv).getText();
		return confirmationText;
	}
	
	public void VerifyConfirmationText(String actualText)
	{
		Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
