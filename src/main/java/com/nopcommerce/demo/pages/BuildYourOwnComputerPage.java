package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Build your own computer Text, Processor Drop Down, Ram drop down,
 * HDD radios, os radio, software check boxes, Add To Card button,
 * "The product has been added to your shopping cart" message locators and it's actions
 */

public class BuildYourOwnComputerPage extends Utility {

    //Build your own computer Text
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Build your own computer']")
    WebElement titleText;

    //Processor drop down
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement selectProcessor;

    //Ram drop down
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ram;

    //HDD Radios
    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement hdd;

    //OS radio
    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement os;

    //software check boxes
    @CacheLookup
    @FindBy(id = "product_attribute_5_12")
    WebElement software;

    //Add To Card button
    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartLink;

    //"The product has been added to your shopping cart" message locators
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement message;

//=====================================================================================================//

    //Get Build Your Own Computer Title
    public String getBuildYourOwnComputerTitle() {
        CustomListeners.test.log(Status.PASS, "Get Build Your Own Computer Title");
        return getTextFromElement(titleText);
    }
    //Select Product Processor method
    public void selectProcessor(String Text) {
        selectByVisibleTextFromDropDown(selectProcessor, Text);
    }

    //Select Product RAM method
    public void selectRAM(String Text) {
        selectByVisibleTextFromDropDown(ram, Text);
    }

    //Select HDD radios
    public void selectHDD(String text) {
        sendTextToElement(hdd, text);
    }

    //Select Product OS method
    public void selectOS(String text) {
        sendTextToElement(os, text);
    }

    //Select Product Software method
    public void selectSoftware(String text) {
        sendTextToElement(software, text);
    }

    //Click on Add to cart button
    public void clickOnAddToCartLink() {
        clickOnElement(addToCartLink);
    }

    //Verify "The product has been added to your shopping cart" message
    public void getMessageText(String text) {
        verifyThatTextIsDisplayed(message, text);
    }
}
