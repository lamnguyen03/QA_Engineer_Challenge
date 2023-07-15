package browsers;

import constants.AppConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static WebDriver driver;
    private String url;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
        driver.get(this.url);
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public void initDriver() {
        String webdriver = System.getProperty("webdriver", AppConstant.DEFAULT_BROWSER);
        switch (webdriver) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "browserstack":
                try {
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("browser", "Chrome");
                    caps.setCapability("browser_version", "latest");
                    caps.setCapability("os", "Windows");
                    caps.setCapability("os_version", "10");
                    caps.setCapability("name", "Your Test Name");
                    caps.setCapability("browserstack.user", AppConstant.USERNAME);
                    caps.setCapability("browserstack.key", AppConstant.AUTOMATE_KEY);

                    driver = new RemoteWebDriver(new URL(AppConstant.urlBrowserSrack), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        setUrl(AppConstant.URL);
    }
}
