package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Computers text, DesktopsLink, NotebooksLink, SoftwareLink Locators and
 * Create appropriate methods for it.
 */

public class ComputerPage extends Utility {
    //Computer Title
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement verifyComputerTitle;

    //Desktops Link
    @CacheLookup
    @FindBy(css = "h1[shub-ins='1']")
    WebElement desktopsLink;

    //NotebooksLink
    @CacheLookup
    @FindBy(css = "a[href='/notebooks'][shub-ins='1']")
    WebElement noteBooksLink;

    //SoftwareLink
    @CacheLookup
    @FindBy(css = "a[href='/software'][shub-ins='1']")
    WebElement softwareLink;

//======================================================================================================//
public String verifyComputerText(){
    CustomListeners.test.log(Status.PASS, "Verify Computer Text");
   return getTextFromElement(verifyComputerTitle);
}
    public void clickOnDesktopsLink(){
        CustomListeners.test.log(Status.PASS, "Click on Desktops link");
        clickOnElement(desktopsLink);
    }
    public void clickOnNoteBooksLink(){
        CustomListeners.test.log(Status.PASS, "Click on Notebooks link");
        clickOnElement(noteBooksLink);
    }
    public void clickOnSoftwareLink(){
        CustomListeners.test.log(Status.PASS, "Click on Software link");
        clickOnElement(softwareLink);
    }
}
