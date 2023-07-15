package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends HomePage{
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//fieldset[@class='form-group']//input[@placeholder='Username']")
    private WebElement userNameField;
    @FindBy(xpath = "//fieldset[@class='form-group']//input[@placeholder='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//fieldset[@class='form-group']//input[@placeholder='Password']")
    private WebElement passwordField;
    @FindBy(xpath = " //div//h1[contains(text(),'Sign Up')]")
    private WebElement titleSingUpPage;
    @FindBy(xpath = "  //div//li//a[@href='#']")
    private WebElement homeLink;
    @FindBy(xpath = "//fieldset//button")
    private WebElement signUpBtn;



    public SignUpPage setUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }
    public SignUpPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public SignUpPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public boolean isOnSignUpPage() {
        waitToBeAvailable(titleSingUpPage);
        return titleSingUpPage.isDisplayed();
    }
    public boolean signUpSuccess() {
        waitToBeAvailable(homeLink);
        return homeLink.isDisplayed();
    }
    public SignUpPage clickOnSignUp() {
        signUpBtn.click();
        return this;
    }
}
