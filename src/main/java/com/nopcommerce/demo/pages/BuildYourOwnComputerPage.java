package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputer;

    @CacheLookup
    @FindBy(xpath = "(//select[@id='product_attribute_1'])[1]")
    WebElement processorDropdown;
    @CacheLookup
    @FindBy(xpath = "(//select[@id='product_attribute_2'])[1]")
    WebElement ramDropdown;
//    @CacheLookup
//    @FindBy(css="#product_attribute_2")
//    WebElement ramDropdownLocator;

    @CacheLookup
    @FindBy(css="#product_attribute_3_7")
    WebElement hddRadioButtonLocator;

    @CacheLookup
    @FindBy(css="#product_attribute_4_9")
    WebElement osRadioButtonLocator;

    @CacheLookup
    @FindBy(xpath = "(//button[@id='add-to-cart-button-1'])[1]")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement addedToShoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='option-list']//li//label")
    List<WebElement> radioButtonSelection;

    @CacheLookup
    @FindBy(xpath="(//input[@id='product_attribute_5_10'])[1]")
    WebElement msOfficeCheckBoxLocator;

    @CacheLookup
    @FindBy(xpath="(//input[@id='product_attribute_5_12'])[1]")
    WebElement totalCommanderCheckBoxLocator;


    public void clickOnBuildYourOwnComputerProduct() {
        Reporter.log("Click On build your own computer product");
        CustomListeners.test.log(Status.PASS, "Click On build your own computer product");
        clickOnElement(buildYourOwnComputer);
    }

    public void selectProcessor() {
        Reporter.log("Select Processor");
        CustomListeners.test.log(Status.PASS, "Select Processor");
        selectByIndexFromDropDown(processorDropdown, 1);

    }

    public void selectRAM() {
        Reporter.log("Select RAM");
        CustomListeners.test.log(Status.PASS, "Select RAM");
        selectByIndexFromDropDown(ramDropdown, 1);

    }

//    public void selectRAM(){
//        Reporter.log("Select RAM" );
//        CustomListeners.test.log(Status.PASS,"Select RAM");
//        selectByIndexFromDropDown(ramDropdownLocator, 3);
//
//    }
    public void selectHDD()
    {
        Reporter.log("Select HDD" );
        CustomListeners.test.log(Status.PASS,"Select HDD");
        clickOnElement(hddRadioButtonLocator);
    }

    public void selectOS()
    {
        Reporter.log("Select OS" );
        CustomListeners.test.log(Status.PASS,"Select OS");
        clickOnElement(osRadioButtonLocator);
    }

    public void selectMicrosoftOffice() {
        Reporter.log("Select MS Office" );
        CustomListeners.test.log(Status.PASS,"Select MS Office");
        WebElement element = driver.findElement(By.cssSelector("#product_attribute_5_10"));
        if (!element.isSelected()) {
            clickOnElement(msOfficeCheckBoxLocator);
        }
    }
    public void selectTotalCommander(){
        Reporter.log("Select Total Commander" );
        CustomListeners.test.log(Status.PASS,"Select Total Commander");
        clickOnElement(totalCommanderCheckBoxLocator);
    }

    public void differentSelection(String visibleText) {
        for (WebElement element : radioButtonSelection) {
            System.out.println("RadioButton: " + element.getText());
            if (element.getText().equalsIgnoreCase(visibleText)) {
                clickOnElement(element);
                break;
            }
        }

    }

    public void clickOnAddToCartButton () {
        Reporter.log("Click on add to cart button");
        CustomListeners.test.log(Status.PASS, "Click on add to cart button");
        clickOnElement(addToCartButton);
    }
    public String verifyTheProductHasBeenAddedToYourShoppingCart() {
        Reporter.log("Verify added to shopping cart text");
        CustomListeners.test.log(Status.PASS, "Verify added to shopping cart text");
        return getTextFromElement(addedToShoppingCartText);
    }
}
