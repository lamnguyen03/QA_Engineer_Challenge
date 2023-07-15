package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    @FindBy(linkText = "Sign in")
    private WebElement logInLink;

    @FindBy(linkText = "Sign up")
    private WebElement signUpLink;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToLoginPage() {
        waitToBeAvailable(logInLink);
        logInLink.click();
        return new LoginPage(driver);
    }
    public SignUpPage navigateToSignUpPage() {
        waitToBeAvailable(signUpLink);
        signUpLink.click();
        return new SignUpPage(driver);
    }
    public void waitToBeAvailable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
