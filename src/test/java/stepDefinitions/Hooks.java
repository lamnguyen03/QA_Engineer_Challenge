package stepDefinitions;

import browsers.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void beforeScenario() {
        Driver driverBrowser = new Driver();
        driverBrowser.initDriver();
        driver = Driver.getDriver();
    }
    @After
    public void AfterScenario() {
        driver.quit();
    }
}
