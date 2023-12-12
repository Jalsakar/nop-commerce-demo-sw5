package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Desktops text, Sort by, Display, selectProductList Locators and it's actions
 */

public class DesktopsPage extends Utility {

    //Verify Desktops Text
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement verifyDeskTopsText;

    //Sort By
    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement sortBy;

    //Display
    @CacheLookup
    @FindBy(id = "products-pagesize")
    WebElement display;

    //selectProductList
    @CacheLookup
    @FindBy(css = "a[title='List']")
    WebElement selectProductList;

    //Desktops Link
    @CacheLookup
    @FindBy(css = "h2[class='title'] a[title='Show products in category Desktops']")
    WebElement desktopsLink;

    //Click on product name "Build your own computer"
    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement clickOnBuildYourOwnComputer;

//=========================================================================================================//

    public String verifyDeskTopsText(){
        CustomListeners.test.log(Status.PASS, "Verify DeskTops Text");
        return getTextFromElement(verifyDeskTopsText);
    }
    public void sortBy(String value){
        CustomListeners.test.log(Status.PASS, "Select Sort By");
        selectByValueFromDropDown(sortBy, value);
    }
    public void display(String value){
        CustomListeners.test.log(Status.PASS, "Select display");
        selectByValueFromDropDown(display, value);
    }
    public void selectProductList(String value){
        CustomListeners.test.log(Status.PASS, "Select Product List");
        selectByValueFromDropDown(selectProductList,value);
    }
    public void clickOnDesktopsLink(){
        CustomListeners.test.log(Status.PASS, "Click on Desktops Link");
        clickOnElement(desktopsLink);
    }
    public void clickOnBuildYourOwnComputer(){
        CustomListeners.test.log(Status.PASS, "Click on Build Your Own Computer");
        clickOnElement(clickOnBuildYourOwnComputer);
    }
}
