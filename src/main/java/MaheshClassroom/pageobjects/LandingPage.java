package MaheshClassroom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage 
{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement driver = driver.findElement(By.id("userEmail"))
	
	@FindBy(id="userEmail")
	WebElement emailField;
	
	@FindBy(id="userPassword")
	WebElement passwordField;
	
	@FindBy(id="login")
	WebElement submitBtn;
	
	public void loginApplication(String email, String password)
	{
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		submitBtn.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}

