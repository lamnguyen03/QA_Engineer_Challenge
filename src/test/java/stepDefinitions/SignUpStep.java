package stepDefinitions;

import browsers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SignUpPage;

import java.util.Random;

public class SignUpStep {
    protected WebDriver driver;
    private HomePage homePage;
    SignUpPage signUpPage;

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

    }

    @When("^user navigate to the sign up page$")
    public void user_navigate_to_the_sign_up_page() {
        signUpPage = homePage.navigateToSignUpPage();
        signUpPage.isOnSignUpPage();
    }

    @When("^user enters (.+),(.+),(.+)$")
    public void user_enters_username_email_password(String userName, String email, String password) {
        signUpPage.setUserName(generateRandomString(8) + "1")
                .setEmail(generateRandomString(8) + "@example.com")
                .setPassword(generateRandomString(10));
    }

    @And("^the user clicks on the Sign in button$")
    public void the_user_clicks_on_the_Sign_in_button() {
        signUpPage.clickOnSignUp();
    }

    @Then("^User should access the home page successfully$")
    public void User_should_access_the_home_page_successfully() {
        signUpPage.signUpSuccess();
    }
    private String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
