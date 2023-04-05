package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait smallWait;
    protected final WebDriverWait mediumWait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mediumWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterText(WebElement field, String text) {
        smallWait.until(ExpectedConditions.visibilityOf(field));
        field.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        smallWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void verifyUrl(String url) {
        mediumWait.until(ExpectedConditions.urlToBe(url));
    }

    public void verifyUrlContains(String url) {
        mediumWait.until(ExpectedConditions.urlContains(url));
    }

    public String getElementText(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

}
