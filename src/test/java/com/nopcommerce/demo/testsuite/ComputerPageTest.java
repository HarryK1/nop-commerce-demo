package com.nopcommerce.demo.testsuite;


import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //Click on Computer tab
        computerPage.clickOnComputerTab();
        //Verify "Computer" text
        String expectedText = "Computers";
        Assert.assertEquals(computerPage.verifyTextComputer(),expectedText, "Text is not displayed");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //Click on Computer tab
        computerPage.clickOnComputerTab();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Verify "Desktops" text
        String expectedMessage = "Desktops";
        Assert.assertEquals(desktopsPage.verifyTextDesktops(),expectedMessage, "error message");
    }

    @Test(dataProvider = "builtYourOwnComputer", dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        //Click on Computer tab
        computerPage.clickOnComputerTab();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Click on product name "Build your own computer"
        buildYourOwnComputerPage.clickOnBuildYourOwnComputerProduct();
        //Select processor "processor"
        buildYourOwnComputerPage.selectProcessor();
        //Select RAM "ram"
        buildYourOwnComputerPage.selectRAM();
        //Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD();
        //Select OS "os"
        buildYourOwnComputerPage.selectOS();
        //Select Software "software"
        buildYourOwnComputerPage.selectMicrosoftOffice();
        buildYourOwnComputerPage.selectTotalCommander();
        //Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartButton();
        //Verify message "The product has been added to your shopping cart"
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(buildYourOwnComputerPage.verifyTheProductHasBeenAddedToYourShoppingCart(),expectedMessage,"product not added");
    }
}


