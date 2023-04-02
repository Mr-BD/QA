package tests;


import components.Header;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.PostsPage;

import java.time.Duration;

public class LoginTest {
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
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {
                        "auto_user", "auto_pass"
                }
        };
    }

    @Test(dataProvider = "loginData")
    public void login(String username, String password) {
        //1. Navigate to home page
        driver.get(HOME_URL);
        //2. Click on login link and go to login page
        Header header = new Header(driver);
        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
        //3. Login with existing user
        loginPage.login(username, password);
        //4. Verify that we're logged by going to Profile page
        PostsPage postsPage = new PostsPage(driver);
        postsPage.verifyPostsPageUrl();
    }

    @AfterMethod
    public void cleanup() {
        if (driver != null) {
            driver.close();
        }
    }

}
