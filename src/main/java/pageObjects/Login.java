package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class Login {
    public WebDriver driver;

    @FindBy(css = "input[id='user-name']")
    private WebElement username;

    @FindBy(css = "input[id='password']")
    private WebElement password;

    @FindBy(css = "input[type='submit']")
    private WebElement signIn;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsername() {
        base.log.info("Returning username WebElement");
        return username;
    }

    public WebElement getPassword() {
        base.log.info("Returning password WebElement");
        return password;
    }

    public void clickSignIn() {
        base.log.info("Clicking on Sign In button");
        signIn.click();
    }
}
