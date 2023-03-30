package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final String URL = "http://training.skillo-bg.com:4200/posts/all";

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public void navigate() {
        driver.get(URL);
    }

}
