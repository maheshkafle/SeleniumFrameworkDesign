package MaheshClassroom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import MaheshClassroom.pageobjects.CartPage;
import MaheshClassroom.pageobjects.LandingPage;
import MaheshClassroom.pageobjects.OrderHistoryPage;
import MaheshClassroom.pageobjects.PaymentPage;
import MaheshClassroom.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLandingPage {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Implicit Waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();		
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
