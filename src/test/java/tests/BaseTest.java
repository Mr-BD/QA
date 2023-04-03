package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    public final String HOME_URL = "http://training.skillo-bg.com:4200";
    protected WebDriver driver;


    @BeforeSuite
    public void setupSuite() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void setupDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(HOME_URL);
    }

    @AfterMethod
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }


}
