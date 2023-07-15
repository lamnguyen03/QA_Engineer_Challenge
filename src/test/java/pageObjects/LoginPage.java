package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//fieldset[@class='form-group']//input[@placeholder='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//fieldset[@class='form-group']//input[@placeholder='Password']")
    private WebElement passwordField;
    @FindBy(xpath = "//fieldset//button")
    private WebElement loginBtn;
    @FindBy(xpath = "//div//ul[@class='error-messages']")
    private WebElement erorMessage;
    @FindBy(xpath = " //div//h1[contains(text(),'Sign In')]")
    private WebElement titleLoginPage;
    public boolean errorMessages() {
        waitToBeAvailable(erorMessage);
        return erorMessage.isDisplayed();
    }
    public LoginPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public boolean isOnLoginPage() {
        waitToBeAvailable(titleLoginPage);
        return titleLoginPage.isDisplayed();
    }
    public LoginPage clickOnSignIn() {
        loginBtn.click();
        return this;
    }

}
