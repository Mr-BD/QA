package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    protected final WebDriver driver;
    protected WebDriverWait smallWait;

    public Utils(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void typeInInput(WebElement input, String text) {
        smallWait.until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(text);
    }
}
