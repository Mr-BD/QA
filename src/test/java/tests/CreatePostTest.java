package tests;

import components.Header;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreatePostPage;
import pages.LoginPage;
import pages.ProfilePage;

import java.io.File;

public class CreatePostTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {
                        "TestUser555", "123123", "post caption", new File("src/test/java/assets/img.jpg")
                }
        };
    }

    @Test(dataProvider = "loginData")
    public void createPost(String username, String password, String caption, File imageToUpload) {
        // 1. Login with existing user
        Header header = new Header(driver);
        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        //2. Go to profile page to get the current number of posts
        header.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyUrl();
        int initialNumberOfPosts = profilePage.getNumberOfPosts();
        // 3. Navigate to CreatePostPage
        header.goToCreatePostPage();
        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.verifyCreatePostUrl();
        // 4. Creating the new post
        createPostPage.createPost(caption, imageToUpload);
        // 5. Verify if post is created
        profilePage.verifyUrl();
        int updatedNumberOfPosts = profilePage.getNumberOfPosts();
        Assert.assertEquals(updatedNumberOfPosts, initialNumberOfPosts + 1);
    }
}
