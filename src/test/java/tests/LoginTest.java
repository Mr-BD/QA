package tests;


import components.Header;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    public final String HOME_URL = "http://training.skillo-bg.com:4200";
    protected WebDriver driver;

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
    public void login() {
        //1. Navigate to home page
        driver.get(HOME_URL);
        //2. Click on login link and go to login page
        Header header = new Header(driver);
        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
        //3. Login with existing user
        loginPage.login();

//     //4. Verify that we're logged by going to Profile page
//
    }

//    @AfterMethod
//    public void cleanup() {
//        if (driver != null) {
//            driver.close();
//        }
//    }
//

}
