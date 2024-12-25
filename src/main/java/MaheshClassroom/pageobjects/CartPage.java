package MaheshClassroom.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MaheshClassroom.Abstractcomponents.Abstractcomponent;

public class CartPage extends Abstractcomponent
{

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;

	public Boolean findProductByName(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;	
	}
	
	public PaymentPage gotoPaymentPage()
	{
		checkoutBtn.click();
		PaymentPage paymentPage = new PaymentPage(driver);
		return paymentPage;
	}
	
	
}
