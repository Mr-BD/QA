package tests;

import components.Header;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PostsPage;

public class LikeAPostTest extends BaseTest {


    // Get username and password from testng.xml parameters
    @Parameters({"username", "password"})
    @Test
    public void likeAPost(String username, String password) {
        //1. Login with existing user
        Header header = new Header(driver);
        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
        loginPage.login(username, password);
        //2. Go to Posts page
        PostsPage postsPage = new PostsPage(driver);
        postsPage.verifyPostsPageUrl();
        //3. Select a post and get current number of likes
        int numberOfLikes = postsPage.getFirstPostsNumberOfLikes();
        //4. Click on Like button
        postsPage.likeFirstPost();

        int updatedNumberOfLikes = postsPage.getFirstPostsNumberOfLikes();

        //5. Verify that number of likes has been increased by one
        // TODO: Number OF LIKES IS NOT UPDATING
        Assert.assertEquals(updatedNumberOfLikes, numberOfLikes + 1);

    }
}
