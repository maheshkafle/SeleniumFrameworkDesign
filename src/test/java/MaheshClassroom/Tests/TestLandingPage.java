package MaheshClassroom.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MaheshClassroom.TestComponents.BaseTest;
import MaheshClassroom.pageobjects.CartPage;
import MaheshClassroom.pageobjects.LandingPage;
import MaheshClassroom.pageobjects.OrderConfirmationPage;
import MaheshClassroom.pageobjects.OrderHistoryPage;
import MaheshClassroom.pageobjects.PaymentPage;
import MaheshClassroom.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLandingPage extends BaseTest{

//	String productName = "IPHONE 13 PRO";
	
	@Test(dataProvider="getData", groups={"Purchase"})
	public void submitOrder(String email, String password, String productName) throws InterruptedException, IOException
	{
		ProductCatalogue productCataloguePage = landingPage.loginApplication(email, password);
		productCataloguePage.addProductToCart(productName);	
		CartPage cartPage = productCataloguePage.goToCartPage();
		Thread.sleep(2000);
		Boolean match = cartPage.findProductByName(productName);
		Assert.assertTrue(match);		
		PaymentPage paymentPage = cartPage.gotoPaymentPage();
		paymentPage.SelectCountry();
		OrderConfirmationPage OrderConfirmationPage = paymentPage.gotoOrderConfirmationPage();
		String confirmationText = OrderConfirmationPage.GetConfirmationText();
		OrderConfirmationPage.VerifyConfirmationText(confirmationText);	
		driver.findElement(By.cssSelector(".btn-custom .fa-sign-out")).click();
	}
		
	@Test(dependsOnMethods= {"submitOrder"}, dataProvider="getData")
	public void orderHistoryTest(String email, String password, String productName) throws InterruptedException, IOException
	{
		ProductCatalogue productCataloguePage = landingPage.loginApplication(email, password); //New Credentials kexax37272@nongnue.com //Kexax37272
		OrderHistoryPage orderHistoryPage = productCataloguePage.goToOrderPage();
		Assert.assertTrue(orderHistoryPage.verifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"kexax37272@nongnue.com","Kexax37272", "IPHONE 13 PRO"},{"kafledarkhorse@gmail.com", "@Nepal123","ADIDAS ORIGINAL"}};
	}
}
