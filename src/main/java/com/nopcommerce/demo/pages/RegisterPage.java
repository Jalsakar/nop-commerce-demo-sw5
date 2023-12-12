package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {
    /**
     * Register Text, male female radio, Firstname, lastname, Date of Birth drop down,
     * email, Password, Confirm Password, Register Button, "First name is required.","Last name is required.",
     * "Email is required.","Password is required.", "Password is required."
     * error message, "Your registration completed" message, "CONTINUE" button Locators and it's actions
     */
    //Register Title
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register']")
    WebElement registerTitle;

    //Male Radio Btn
    @CacheLookup
    @FindBy(id = "gender-male")
    WebElement genderMale;

    //Female Radio Btn
    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement genderFemale;

    //First Name
    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameField;

    //First Name Error
    @CacheLookup
    @FindBy(css = "#FirstName-error")
    WebElement firstNameError;

    //Last Name
    @CacheLookup
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameField;

    //Last Name Error
    @CacheLookup
    @FindBy(id = "LastName-error")
    WebElement lastNameError;

    //Day of Birth
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dayOfBirth;

    //Month of Birth
    @CacheLookup
    @FindBy(css = "select[name='DateOfBirthMonth']")
    WebElement monthOfBirth;

    //Year of Birth
    @CacheLookup
    @FindBy(css = "select[name='DateOfBirthYear']")
    WebElement yearOfBirth;

    //Email Field
    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    //Email Field error
    @CacheLookup
    @FindBy(css = "#Email-error")
    WebElement emailFieldError;

    //Password Field
    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordField;

    //Password Field Error
    @CacheLookup
    @FindBy(css = "#Password-error")
    WebElement passwordFieldError;

    //Confirm Password Field
    @CacheLookup
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasswordField;

    //Confirm Password Field Error
    @CacheLookup
    @FindBy(css = "#ConfirmPassword-error")
    WebElement confirmPasswordFieldError;

    //Register button
    @CacheLookup
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerBtn;

    //Registration complete message
    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement registrationCompletedMessage;

    //Continue button on Registration complete message
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButtonAfterRegistrationCompletedMessage;


    //=====================================================================================================//
    public String getRegisterTitle() {
        return getTextFromElement(registerTitle);
    }

    public void selectGender(String maleOrFemale) {
        CustomListeners.test.log(Status.PASS, "Select gender." + maleOrFemale);
        switch (maleOrFemale) {
            case "Male":
                clickOnElement(genderMale);
                break;
            case "Female":
                clickOnElement(genderFemale);
                break;
            default:
                break;
        }
    }

    public void enterFirstName(String name) {
        CustomListeners.test.log(Status.PASS, "Enter First Name");
        sendTextToElement(firstNameField, name);
    }

    public String errorInFirstName() {
        CustomListeners.test.log(Status.PASS, "Enter First Error");
        return getTextFromElement(firstNameError);
    }

    public void enterLastName(String lastName) {
        CustomListeners.test.log(Status.PASS, "Enter Last Name");
        sendTextToElement(lastNameField, lastName);
    }

    public String errorInLastName() {
        CustomListeners.test.log(Status.PASS, "Error Last Name");
        return getTextFromElement(lastNameError);
    }

    public void enterDayOfBirth(String day) {
        CustomListeners.test.log(Status.PASS, "Enter Day Of Birth");
        selectByVisibleTextFromDropDown(dayOfBirth, day);
    }

    public void enterMonthOfBirth(String month) {
        CustomListeners.test.log(Status.PASS, "Enter Month Of Birth");
        selectByVisibleTextFromDropDown(monthOfBirth, month);
    }

    public void enterYearOfBirth(String year) {
        CustomListeners.test.log(Status.PASS, "Enter Year Of Birth");
        selectByVisibleTextFromDropDown(yearOfBirth, year);
    }
    public String errorInEmailField(){
        CustomListeners.test.log(Status.PASS, "Error in Email Field");
        return getTextFromElement(emailFieldError);
    }

    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS, "Enter Password");
        sendTextToElement(passwordField, password);
    }
    public String errorInPasswordField(){
        CustomListeners.test.log(Status.PASS, "Error in Password Field");
       return getTextFromElement(passwordFieldError);
    }

    public void enterConfirmPassword(String confirmPassword) {
        CustomListeners.test.log(Status.PASS, "Enter Confirm Password");
        sendTextToElement(confirmPasswordField, confirmPassword);
    }
    public String errorInConfirmPasswordField(){
        CustomListeners.test.log(Status.PASS, "Error in Confirm Password Field");
        return getTextFromElement(confirmPasswordFieldError);
    }

    public void clickOnRegisterButton() {
        CustomListeners.test.log(Status.PASS, "Click on Register Button");
        clickOnElement(registerBtn);
    }

    public String verifyRegistrationCompletedMessage() {
        CustomListeners.test.log(Status.PASS, "Get Registration Completed Message");
        return getTextFromElement(registrationCompletedMessage);
    }

    public void clickOnContinueButtonAfterRegistrationCompletedMessage() {
        CustomListeners.test.log(Status.PASS, "Click on ContinueButton after Registration Completed Message");
        clickOnElement(continueButtonAfterRegistrationCompletedMessage);
    }
}
