package tests;

import components.Header;

import org.testng.annotations.*;
import pages.LoginPage;
import pages.PostsPage;


public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {
                        "TestUser555", "123123"
                }
        };
    }

    @Test(dataProvider = "loginData")
    public void login(String username, String password) {
        //1. Click on login link and go to login page
        Header header = new Header(driver);
        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
        //2. Login with existing user
        loginPage.login(username, password);
        //3. Verify that we're logged by going to Profile page
        PostsPage postsPage = new PostsPage(driver);
        postsPage.verifyPostsPageUrl();
    }

}
