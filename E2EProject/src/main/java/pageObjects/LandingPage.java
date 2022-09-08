package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;


public class LandingPage 

{
 public WebDriver driver;
 By logIn=By.xpath("//span[contains(text(),'Login')]");
 By header = By.xpath("//h2[text()='Featured Courses']");
 By navBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
 
 public LandingPage(WebDriver driver)
 {
	 this.driver=driver;
 }


public WebElement getLogIn()
{
	base.log.info("returning the login webelement");
	return driver.findElement(logIn);
}
public WebElement getHeader()
{
	 base.log.info("returning the header webelement");
	return driver.findElement(header);
}
public WebElement getNavBar()
{
	base.log.info("returning the navbar webelement");
	return driver.findElement(navBar);
}
}