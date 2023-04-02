package tests;


import components.Header;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreatePostPage;
import pages.LoginPage;

public class CreatePostTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {
                        "TestUser555", "123123"
                }
        };
    }

    @Test(dataProvider = "loginData")
    public void createPost(String username, String password) {
        // 1. Login with existing user
        Header header = new Header(driver);
        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        // 2. Navigate to CreatePostPage
        header.goToCreatePostPage();
        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.verifyCreatePostUrl();
        // 3. Creating the new post
        createPostPage.createPost();
        // 4. Verify if post is created

    }


}
