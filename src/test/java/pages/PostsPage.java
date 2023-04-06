package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class PostsPage extends BasePage {

    public final String POSTS_PAGE_URL = "http://training.skillo-bg.com:4200/posts/all";

    @FindBy(css = ".comment-container .comment-content")
    List<WebElement> comments;

    @FindBy(className = "comment-form")
    WebElement newCommentForm;

    @FindBy(css = ".post-modal-container input[formcontrolname='content']")
    WebElement newCommentInput;

    @FindBy(className = "post-modal-container")
    WebElement selectedPostModal;

    @FindBy(className = "post-feed-container")
    List<WebElement> posts;

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
        smallWait.until(ExpectedConditions.visibilityOfAllElements(numberOfLikesText));
        String numberOfLikesString = getElementText(numberOfLikesText.get(0)).replace(" likes", "");
        return Integer.parseInt(numberOfLikesString);
    }

    public String getFirstLikeButtonClassName() {
        return likeButtons.get(0).getAttribute("class");
    }

    public boolean postHasBeenLikedFromUs() {
        return getFirstLikeButtonClassName().contains("liked");
    }

    public void clickOnTheFirstPost() {
        clickElement(posts.get(0));
    }

    public void waitForSelectedModalToBeVisible() {
        smallWait.until(ExpectedConditions.visibilityOf(selectedPostModal));
    }

    public void fillCommentInput(String comment) {
        enterText(newCommentInput, comment);
    }

    public void submitForm() {
        newCommentForm.submit();
    }

    public String selectNewestComment() {
        smallWait.until(ExpectedConditions.visibilityOfAllElements(comments));
        WebElement newestComment = comments.get(comments.size() - 1);
        return getElementText(newestComment);
    }

    public void waitForCommentsToBeUpdated() {
        smallWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".comment-container .comment-content"), comments.size() + 1));
    }
}
