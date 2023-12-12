package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutLink;
    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerMenuLink;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Electronics'])[1]")
    WebElement electronicsMenuLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    WebElement apparelMenuLink;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Digital downloads'])[1]")
    WebElement digitalDownloadsMenuLink;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Books'])[1]")
    WebElement booksMenuLink;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Jewelry'])[1]")
    WebElement jewelryMenuLink;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Gift Cards'])[1]")
    WebElement giftCardsMenuLink;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopcommerceLogo;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='My account']")
    WebElement myAccountLink;


    public void clickOnLoginLink() {
        Reporter.log("Click On Login Link");
        CustomListeners.test.log(Status.PASS, "Click On Login Link");
        clickOnElement(loginLink);

    }

    public String verifyThatLogoutLinkIsDisplay() {
        Reporter.log("Verify logout link is displayed");
        CustomListeners.test.log(Status.PASS, "Verify logout link is displayed");
        return getTextFromElement(logoutLink);
    }

    public String verifyThatLoginLinkIsDisplay() {
        Reporter.log("Verify login link is displayed");
        CustomListeners.test.log(Status.PASS, "Verify login link is displayed");
        return getTextFromElement(loginLink);
    }

    public void clickOnRegisterLink() {
        Reporter.log("Click on register link");
        CustomListeners.test.log(Status.PASS, "Click on register link");
        clickOnElement(registerLink);
    }
    public void clickOnComputersMenu() {
        Reporter.log("Click on computers menu");
        CustomListeners.test.log(Status.PASS, "Click on computers menu");
        clickOnElement(computerMenuLink);
    }

    public void clickOnElectronicsMenu() {
        Reporter.log("Click on electronics menu");
        CustomListeners.test.log(Status.PASS, "Click on electronics menu");
        clickOnElement(electronicsMenuLink);
    }

    public void clickOnApparelMenu() {
        Reporter.log("Click on apparel menu");
        CustomListeners.test.log(Status.PASS, "Click on apparel menu");
        clickOnElement(apparelMenuLink);
    }

    public void clickOnDigitalDownloadsMenu() {
        Reporter.log("Click on digital downloads menu");
        CustomListeners.test.log(Status.PASS, "Click on digital downloads menu");
        clickOnElement(digitalDownloadsMenuLink);
    }

    public void clickOnBooksMenu() {
        Reporter.log("Click on books menu");
        CustomListeners.test.log(Status.PASS, "Click on books menu");
        clickOnElement(booksMenuLink);
    }

    public void clickOnJewelryMenu() {
        Reporter.log("Click on jewelry menu");
        CustomListeners.test.log(Status.PASS, "Click on jewelry menu");
        clickOnElement(jewelryMenuLink);
    }

    public void clickOnGiftCardsMenu() {
        Reporter.log("Click on gift cards menu");
        CustomListeners.test.log(Status.PASS, "Click on gift cards menu");
        clickOnElement(giftCardsMenuLink);
    }

    public boolean verifyNopCommerceLogo() {
        Reporter.log("Verify nopcommerce logo is displayed");
        CustomListeners.test.log(Status.PASS, "Verify nopcommerce logo is displayed");
        return verifyThatElementIsDisplayed(nopcommerceLogo);
    }

    public void clickOnMyAccountLink() {
        Reporter.log("Click on my account link");
        CustomListeners.test.log(Status.PASS, "Click on my account link");
        clickOnElement(myAccountLink);
    }

}
