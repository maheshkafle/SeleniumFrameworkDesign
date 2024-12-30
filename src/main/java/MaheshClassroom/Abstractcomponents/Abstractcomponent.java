package MaheshClassroom.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MaheshClassroom.pageobjects.CartPage;
import MaheshClassroom.pageobjects.OrderHistoryPage;

public class Abstractcomponent 
{
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderButton;
	
	public Abstractcomponent(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void waitForElementToAppear(By FindBy)
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele)
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
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
	
	public OrderHistoryPage goToOrderPage()
	{
		orderButton.click();
		OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
		return orderHistoryPage;
	}
	
}
