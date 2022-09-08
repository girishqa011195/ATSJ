package Academy;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
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
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Login')]"))));
		log.info("asserting the feature courses");
		Assert.assertEquals(l.getHeader().getText(),"FEATURED COURSES");
		log.info("asserting the navigation bar");
		Assert.assertTrue(l.getNavBar().isDisplayed());
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
		lo.clickSignIn().click();
		
		
	
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
		data[0][0]="nonrestricted@gmail.com";
		data[0][1]="12346";
		
		data[1][0]="restricted@gmail.com";
		data[1][1]="23467";
		
		return data;
				
	}

}
