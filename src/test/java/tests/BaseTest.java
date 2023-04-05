package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {


    public static final String RESOURCES_DIR = "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources" + File.separator;
    public static final String SCREENSHOTS_DIR = RESOURCES_DIR + "screenshots" + File.separator;
    public static final String REPORTS_DIR = RESOURCES_DIR + "reports" + File.separator;
    public final String HOME_URL = "http://training.skillo-bg.com:4200";
    protected WebDriver driver;


    @BeforeSuite
    public void setupSuite() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        cleanDirectory(SCREENSHOTS_DIR);
        cleanDirectory(REPORTS_DIR);
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
    public void cleanup(ITestResult testResult) {
        takeScreenshot(testResult);
        if (driver != null) {
            driver.quit();
        }
    }

    public void takeScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String testName = testResult.getName();
            try {
                FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR + testName + ".jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void cleanDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        FileUtils.cleanDirectory(directory);
        String[] fileList = directory.list();
        if (fileList != null && fileList.length == 0) {
            System.out.printf("All files are deleted in Directory: %s%n", directoryPath);
        } else {
            System.out.printf("Unable to delete the files in Directory:%s%n", directoryPath);
        }
    }

}
