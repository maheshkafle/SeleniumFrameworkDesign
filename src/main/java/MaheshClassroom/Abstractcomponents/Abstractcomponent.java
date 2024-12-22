package MaheshClassroom.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponent 
{
	WebDriver driver;
	
	public Abstractcomponent(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void waitForELementToAppear(By FindBy)
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	}
	
	
}
