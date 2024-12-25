package MaheshClassroom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MaheshClassroom.pageobjects.LandingPage;
import MaheshClassroom.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLandingPage {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Implicit Waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();		
		landingPage.loginApplication("kafledarkhorse@gmail.com", "@Nepal123");
		ProductCatalogue productCataloguePage = new ProductCatalogue(driver);
		List<WebElement>products = productCataloguePage.getProductList();	
		String productName = "IPHONE 13 PRO";
		productCataloguePage.addProductToCart(productName);
		
		//ExplicitWait
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);	
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".actions .action__submit")).click();
		String confirmationText = driver.findElement(By.cssSelector("h1.hero-primary")).getText();
		Assert.assertTrue(confirmationText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
