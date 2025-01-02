package MaheshClassroom.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

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
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException
	{
		ProductCatalogue productCataloguePage = landingPage.loginApplication(input.get("email"), input.get("password"));
		productCataloguePage.addProductToCart(input.get("product"));	
		CartPage cartPage = productCataloguePage.goToCartPage();
		Thread.sleep(2000);
		Boolean match = cartPage.findProductByName(input.get("product"));
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
	public Object[][] getData() throws IOException
	{
		//
		List<HashMap<String, String>> data = getJSONDataToHashMap(System.getProperty("user.dir")+ "\\src\\test\\java\\MaheshClassroom\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}}; 
	}
	
	//Using HashMap
//	@DataProvider
//	public Object[][] getData()
//	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "kexax37272@nongnue.com");
//		map.put("password", "Kexax37272");
//		map.put("product", "IPHONE 13 PRO");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "kafledarkhorse@gmail.com");
//		map1.put("password", "@Nepal123");
//		map1.put("product", "ADIDAS ORIGINAL");
//		return new Object[][] {{map}, {map1}}; 
//	}
	
	//Using Array
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"kexax37272@nongnue.com", "Kexax37272", "IPHONE 13 PRO"}, {"kafledarkhorse@gmail.com", "@Nepal123", "ADIDAS ORIGINAL"}}; 
//	}
}
