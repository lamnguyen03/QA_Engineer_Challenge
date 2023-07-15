package stepDefinitions;

import browsers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

public class LoginStep {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Given("^open the home page$")
    public void open_the_home_page() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

    }
    @When("^user navigate to the login page$")
    public void user_navigate_to_the_login_page() {
        loginPage = homePage.navigateToLoginPage();
        loginPage.isOnLoginPage();
    }

    @When("^user enters (.+),(.+) to login$")
    public void user_enters_email_password_to_login(String email, String passWord) {
        loginPage.setEmail(email).setPassword(passWord);
    }

    @And("^the user clicks on the login button$")
    public void the_user_clicks_on_the_login_button() {
        loginPage.clickOnSignIn();
    }
    @Then("^user can not login and error message is displayed$")
    public void user_can_not_login_and_error_message_is_displayed(){
        loginPage.errorMessages();
    }
}
