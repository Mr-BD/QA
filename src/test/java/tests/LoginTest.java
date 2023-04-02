package tests;

import components.Header;
import components.LoginForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

    @BeforeSuite
    public void setupSuite() {
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void loginTest() {
        //1. Navigate to home page
        HomePage homePage = new HomePage(driver);
        homePage.navigate();
        //2. Click on login link and go to login page
        Header header = new Header(driver);
        header.goToLoginPage();
        //3. Login with existing user
//        LoginForm loginForm = new LoginForm(driver);
//        loginForm.login();
        //4. Verify that we're logged by going to Profile page
//        Assert.assertFalse(header.getLogoutLink().isDisplayed());
    }


}
