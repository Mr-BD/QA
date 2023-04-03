package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProfilePage extends BasePage {
    public final String URL = "http://training.skillo-bg.com:4200/users";

    @FindBy(css = "app-post")
    List<WebElement> posts;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrlContains(URL);
    }

    public int getNumberOfPosts() {
        mediumWait.until(ExpectedConditions.visibilityOfAllElements(posts));
        return posts.size();
    }
}
