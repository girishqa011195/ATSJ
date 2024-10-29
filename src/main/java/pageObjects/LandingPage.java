package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class LandingPage {
    public WebDriver driver;

    @FindBy(id = "login-button")
    WebElement logIn;

    @FindBy(xpath = "//title")
    WebElement title;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getLogIn() {
        base.log.info("Returning the login WebElement");
        return logIn;
    }

    public WebElement getTitle() {
        base.log.info("Returning the header WebElement");
        return title;
    }
}
