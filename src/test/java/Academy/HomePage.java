package Academy;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.Login;
import resources.base;

public class HomePage extends base
{
	public WebDriver driver;
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException 
	{
		log.info("initializing driver");
		driver=initializeDriver();
		log.info("opening url");
		driver.get(prop.getProperty("url"));
		log.info("creating the landing page object and passing the driver as argument");
		LandingPage l= new LandingPage(driver);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		log.info("Validating the title");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String titleText = (String) js.executeScript("return arguments[0].textContent;", l.getTitle());
		System.out.println("*******"+titleText+"#########");
		Assert.assertEquals(titleText,"Swag Labs");

		if(l.getLogIn().isDisplayed())
		{
			l.getLogIn().click();
		}
		log.info("creating the login object and passing driver as argument");
		Login lo=new Login(driver);
		log.info("entering the username");
		lo.getUsername().sendKeys(Username);
		log.info("entering the password");
		lo.getPassword().sendKeys(Password);
		log.info("click on signin button");
		lo.clickSignIn();
		
		
	
}
	@AfterTest
	public void testTearDown()
	
	{
		
		log.info("quitting the driver");
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		
		data[1][0]="locked_out_user";
		data[1][1]="secret_sauce";
		
		return data;
				
	}

}
