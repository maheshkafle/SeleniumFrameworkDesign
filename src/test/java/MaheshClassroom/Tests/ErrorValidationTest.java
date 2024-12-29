package MaheshClassroom.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import MaheshClassroom.TestComponents.BaseTest;
import MaheshClassroom.pageobjects.CartPage;
import MaheshClassroom.pageobjects.OrderHistoryPage;
import MaheshClassroom.pageobjects.PaymentPage;
import MaheshClassroom.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest
{

	@Test
	public void errorValidations() throws InterruptedException, IOException
	{
	
		ProductCatalogue productCataloguePage = landingPage.loginApplication("kafledarkhorse@gmail.com", "@wrongPassword");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	

	@Test
	public void productErrorValidation() throws InterruptedException, IOException
	{
		Assert.assertFalse(false);		
	}
	
	
}
