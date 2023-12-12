package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility{
    @CacheLookup
    @FindBy(xpath="//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welcomeSignInPageTitleLocator;
    @CacheLookup
    @FindBy(css = "#Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(css = "#Password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(css = ".button-1.login-button")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutButton;



    public String getTextFromWelcomeText() {
        Reporter.log("Get Text From Welcome Text" );
        CustomListeners.test.log(Status.PASS,"Get Text From Welcome Text");
        return getTextFromElement(welcomeSignInPageTitleLocator);
    }
    public void enterEmailField(String email) {
        Reporter.log("Enter email  " + email + " to Email  field " + emailField.toString());
        CustomListeners.test.log(Status.PASS, "Enter email  " + email);
        sendTextToElement(emailField, email);
    }
    public void enterPasswordField(String password) {
        Reporter.log("Enter Password  " + password + " to Password  field " + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter Password  " + password);
        sendTextToElement(passwordField, password);
    }
    public void clickOnLoginButton() {
        Reporter.log("Click On Login Button");
        CustomListeners.test.log(Status.PASS, "Click On Login Button");
        clickOnElement(loginButton);
    }
    public void clickOnLogOutButton() {
        Reporter.log("Click On Logout Button");
        CustomListeners.test.log(Status.PASS, "Click On Logout Button");
        clickOnElement(logoutButton);
    }


}
