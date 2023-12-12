package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Email, password, Login Button and "Welcome, Please Sign In!" text Locators
 * Create appropriate methods for it.
 */

public class LoginPage extends Utility {

    //Enter EmailId
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    //Enter Password
    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    //Click on Login Button
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginButton;

    //Verify that the Error message
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logout;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement verifyLogoutLinkIsDisplayed;

    //verify that "Welcome, Please Sign In!" message display
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    //Verify Login Link is displayed
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement verifyLoginLink;

//=========================================================================================================//

    //verify that "Welcome, Please Sign In!" message display
    public String verifyWelcomeText() {
        CustomListeners.test.log(Status.PASS, "Verify WelcomeText");
        return getTextFromElement(welcomeText);
    }

    //Enter EmailId
    public void enterEmailInEmailField(String email) {
        Reporter.log("Enter email  " + email + " to Email  field " + emailField.toString());
        CustomListeners.test.log(Status.PASS, "Enter email  " + email);
        sendTextToElement(emailField, email);
    }

    //Enter Password
    public void enterPasswordInPasswordField(String password) {
        Reporter.log("Enter Password  " + password + " to Password  field " + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter Password  " + password);
        sendTextToElement(passwordField, password);
    }

    //Click on Login Button
    public void clickOnLoginButton() {
        Reporter.log("Click On Login Button");
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    //Verify that the Error message
    public String verifyErrorMessage() {
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS, "Verify errorMessage");
        return message;
    }

    //Verify Login Link is displayed
    public String verifyLoginLink() {
        CustomListeners.test.log(Status.PASS, "Log in link is displayed.");
        return getTextFromElement(verifyLoginLink);
    }
}