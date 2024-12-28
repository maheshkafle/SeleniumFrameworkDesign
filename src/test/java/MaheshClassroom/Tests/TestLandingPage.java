package MaheshClassroom.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import MaheshClassroom.TestComponents.BaseTest;
import MaheshClassroom.pageobjects.CartPage;
import MaheshClassroom.pageobjects.LandingPage;
import MaheshClassroom.pageobjects.OrderHistoryPage;
import MaheshClassroom.pageobjects.PaymentPage;
import MaheshClassroom.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLandingPage extends BaseTest{

	@Test
	public void submitOrder() throws InterruptedException, IOException
	{
	
		LandingPage landingPage = launchApplication();
		ProductCatalogue productCataloguePage = landingPage.loginApplication("kafledarkhorse@gmail.com", "@Nepal123");
		String productName = "IPHONE 13 PRO";
		productCataloguePage.addProductToCart(productName);	
		CartPage cartPage = productCataloguePage.goToCartPage();
		Thread.sleep(2000);
		Boolean match = cartPage.findProductByName(productName);
		Assert.assertTrue(match);		
		PaymentPage paymentPage = cartPage.gotoPaymentPage();
		paymentPage.SelectCountry();
		OrderHistoryPage orderHistoryPage = paymentPage.gotoOrderHistoryPage();
		String confirmationText = orderHistoryPage.GetConfirmationText();
		orderHistoryPage.VerifyConfirmationText(confirmationText);	
	}
		
}
