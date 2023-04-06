package tests;

import components.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PostsPage;
import pages.ProfilePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void register() {
        //1. Go to Login page
        Header header = new Header(driver);
        header.goToLoginPage();
        //2. Click on Register link
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
        loginPage.goToRegister();
        //3. Verify that we're on Register page
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.verifyUrl();
        //4. Submit the form and get the created username
        String usernameFromForm = registerPage.fillFormAndSubmit();
        //5. Verify that we've been redirected to home page (Posts)
        PostsPage postsPage = new PostsPage(driver);
        postsPage.verifyPostsPageUrl();
        //6. Navigate to Profile page
        header.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyUrl();
        //7. Verify that the username matches the one that we've provided
        String usernameOnProfile = profilePage.getUsername();
        Assert.assertEquals(usernameOnProfile, usernameFromForm);
    }
}
