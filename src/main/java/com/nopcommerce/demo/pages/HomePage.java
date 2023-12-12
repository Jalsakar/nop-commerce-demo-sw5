package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account link
 * and LogOut link locators and create appropriate methods for it.
 */

public class HomePage extends Utility {
    //Seven Menu Tab with Page Title
    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']")
    WebElement topMenuBar;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronicsTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Electronics')]")
    WebElement electronicsPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    WebElement apparelTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Apparel')]")
    WebElement apparelPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloadTab;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Apparel')]")
    WebElement digitalDownloadPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
    WebElement booksTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Books')]")
    WebElement booksPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
    WebElement jewelryTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Jewelry')]")
    WebElement jewelryPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
    WebElement giftCardsTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Gift Cards')]")
    WebElement giftCardsPageTitle;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Welcome to our store']")
    WebElement welcomeToOurStoreMessage;

    // Verify Login link
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement verifyLoginLink;

    //Register Link
    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    //Nopcommerce Logo
    @CacheLookup
    @FindBy(css = "img[alt='nopCommerce demo store']")
    WebElement nopcommerceLogo;

    //My Account Logo
    @CacheLookup
    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    //Logout Link
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement verifyLogoutLinkIsDisplayed;

//===================================================================================================//

    //Click on Login link
    public void clickOnLoginLink() {
        CustomListeners.test.log(Status.PASS, "Click on  Login Link");
        mouseHoverToElementAndClick(verifyLoginLink);
    }

    //Click on Register Link
    public void clickOnRegisterLink() {
        CustomListeners.test.log(Status.PASS, "Click On Register Link");
        clickOnElement(registerLink);
    }

    //Verify Nopcommerce Logo
    public String verifyNopcommerceLogo() {
        CustomListeners.test.log(Status.PASS, "Verify Nopcommerce Logo");
        return getTextFromElement(nopcommerceLogo);
    }

    //Click on MyAccountLink
    public void clickOnMyAccountLink() {
        CustomListeners.test.log(Status.PASS, "Click On MyAccount Link");
        clickOnElement(myAccountLink);
    }

    //Verify LogoutLink is displayed
    public String verifyLogoutLinkIsDisplayed(){
        CustomListeners.test.log(Status.PASS, "Logout link is displayed.");
        return getTextFromElement(verifyLogoutLinkIsDisplayed);
    }
    public void clickOnLogOutBtn(){
        CustomListeners.test.log(Status.PASS, "Click On Logout Link");
        clickOnElement(logoutLink);
    }

    //Verify LoginLink is displayed
    public String verifyLoginLink(){
        CustomListeners.test.log(Status.PASS, "Log in link is displayed.");
        return getTextFromElement(verifyLoginLink);
    }

    //Click on Computer Tab
    public void clickOnComputerTab(){
        CustomListeners.test.log(Status.PASS, "Click on Computer Tab");
        clickOnElement(computerTab);
    }

}
