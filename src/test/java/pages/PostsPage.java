package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PostsPage extends BasePage {

    public final String POSTS_PAGE_URL = "http://training.skillo-bg.com:4200/posts/all";
    @FindBy(className = "fa-heart")
    List<WebElement> likeButtons;

    @FindBy(css = "strong")
    List<WebElement> numberOfLikesText;

    public PostsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyPostsPageUrl() {
        verifyUrl(POSTS_PAGE_URL);
    }

    public void likeFirstPost() {
        clickElement(likeButtons.get(0));
    }

    public int getFirstPostsNumberOfLikes() {
        String numberOfLikesString = numberOfLikesText.get(0).getText().replace(" likes", "");
        return Integer.parseInt(numberOfLikesString);
    }


}
