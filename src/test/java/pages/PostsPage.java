package pages;

import org.openqa.selenium.WebDriver;

public class PostsPage extends BasePage {
    public final String POSTS_PAGE_URL = "http://training.skillo-bg.com:4200/posts/all";

    public PostsPage(WebDriver driver) {
        super(driver);
    }


    public void verifyPostsPageUrl() {
        verifyUrl(POSTS_PAGE_URL);
    }


}
