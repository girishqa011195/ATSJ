package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class Login 
{
 public WebDriver driver;
 By username=By.cssSelector("input[id='user_email']");
 By password=By.cssSelector("input[id='user_password']");
 By signIn=By.cssSelector("input[type='submit']");
 
 
 public Login(WebDriver driver)
 {
	 this.driver=driver;
 }
	
 public WebElement getUsername()
 {
	base.log.info("returning username webelement");
	return driver.findElement(username);
 }
 public WebElement getPassword()
 {
	 base.log.info("returning password webelement");
	return driver.findElement(password);
 }
 public WebElement clickSignIn()
 {
	 base.log.info("returning signin webelement");
	return driver.findElement(signIn);
 }
}
