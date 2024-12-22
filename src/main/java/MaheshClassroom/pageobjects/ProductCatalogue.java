package MaheshClassroom.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MaheshClassroom.Abstractcomponents.Abstractcomponent;

public class ProductCatalogue extends Abstractcomponent
{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> products =  driver.findElements(By.cssSelector(".mb-3"))
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	
	public List<WebElement> getProductList()
	{
		waitForELementToAppear(productsBy);
		return products;
	}
	
}
