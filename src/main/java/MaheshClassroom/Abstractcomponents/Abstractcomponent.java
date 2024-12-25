package MaheshClassroom.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MaheshClassroom.pageobjects.CartPage;

public class Abstractcomponent 
{
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	public Abstractcomponent(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void waitForElementToAppear(By FindBy)
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitForElementToDisappear(WebElement spinner) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	
	public CartPage goToCartPage()
	{
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
}
