package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    RegisterPage registerPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        //Click on login link
        homePage.clickOnLoginLink();
        //verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(loginPage.getTextFromWelcomeText(), expectedMessage, "Error message: not matching");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterEmailField("xyz123@gmail.com");
        //Enter Password
        loginPage.enterPasswordField("Password1");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that the Error message
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertEquals(registerPage.VerifyErrorMessage(), expectedMessage, "error message not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterEmailField("zara123@gmail.com");
        //Enter Password
        loginPage.enterPasswordField("Zaral12");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that LogOut link is display
        String expectedLink = "Log out";
        Assert.assertEquals(homePage.verifyThatLogoutLinkIsDisplay(), expectedLink, "link not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterEmailField("zara123@gmail.com");
        //Enter Password
        loginPage.enterPasswordField("Zaral12");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Click on LogOut Link
        loginPage.clickOnLogOutButton();
        //Verify that LogIn Link Display
        String expectedLink1 = "Log in";
        Assert.assertEquals(homePage.verifyThatLoginLinkIsDisplay(), expectedLink1, "link not displayed");
    }

}
