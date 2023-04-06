package tests;

import com.github.javafaker.Faker;
import components.Header;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PostsPage;

public class CommentAPostTest extends BaseTest {
    @Parameters({"username", "password"})
    @Test
    public void shouldBeAbleToLeaveACommentUnderAPost(String username, String password) {
        Faker faker = new Faker();
        //1. Login with existing user
        Header header = new Header(driver);
        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
        loginPage.login(username, password);
        //2. Verify that we're on posts page (Homepage)
        PostsPage postsPage = new PostsPage(driver);
        postsPage.verifyPostsPageUrl();
        //3. Click on the first post that appears
        postsPage.clickOnTheFirstPost();
        //4. Verify that the post is opened inside the modal
        postsPage.waitForSelectedModalToBeVisible();
        //5. Submit a new comment
        String newComment = faker.friends().quote();
        postsPage.fillCommentInput(newComment);
        postsPage.submitForm();
        //6. Verify that the last comment on the post matches the text of our comment
        postsPage.waitForCommentsToBeUpdated();
        String newestComment = postsPage.selectNewestComment();
        Assert.assertEquals(newestComment, newComment, "Latest comment did not match the one that you've created");
    }

}
