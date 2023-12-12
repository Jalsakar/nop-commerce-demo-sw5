package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }
    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Verify "Register" text
        String actualRegisterText = registerPage.getRegisterTitle();
        String expectedRegisterText = "Register";
        Assert.assertEquals(actualRegisterText, expectedRegisterText, "Text is not correct");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){

        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify the error message "First name is required."
        String actualFirstNameIsRequiredMessage = registerPage.errorInFirstName();
        String expectedFirstNameIsRequiredMessage = "First name is required.";
        Assert.assertEquals(actualFirstNameIsRequiredMessage, expectedFirstNameIsRequiredMessage, "First name is required.");

        //Verify the error message "Last name is required."
        String actualLastNameIsDisplayedMessage = registerPage.errorInLastName();
        String expectedLastNameIsDisplayedMessage = "Last name is required.";
        Assert.assertEquals(actualLastNameIsDisplayedMessage, expectedLastNameIsDisplayedMessage, "Last name is required.");

        //Verify the error message "Email is required."
        String actualEmailIsRequired = registerPage.errorInEmailField();
        String expectedEmailIsRequired = "Email is required.";
        Assert.assertEquals(actualEmailIsRequired, expectedEmailIsRequired, "Email is required.");

        //Verify the error message "Password is required."
        String actualPasswordIsRequired = registerPage.errorInPasswordField();
        String expectedPasswordIsRequired = "Password is required.";
        Assert.assertEquals(actualPasswordIsRequired, expectedPasswordIsRequired, "Password is required.");

        //Verify the error message "Password is required."
        String actualConfirmPasswordIsRequired = registerPage.errorInConfirmPasswordField();
        String expectedConfirmPasswordIsRequired = "Password is required.";
        Assert.assertEquals(actualConfirmPasswordIsRequired, expectedConfirmPasswordIsRequired, "Password is required.");
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully(){

        //Click on Register Link
        homePage.clickOnRegisterLink();

        //Select gender "Female"
        registerPage.selectGender("Female");

        //Enter firstname
        registerPage.enterFirstName("Disha");

        //Enter lastname
        registerPage.enterLastName("Patel");

        //Select day
        registerPage.enterDayOfBirth("4");

        //Select month
        registerPage.enterMonthOfBirth("January");

        //Select year
        registerPage.enterYearOfBirth("1992");

        //Enter email
        enterEmailAddress();

        //Enter password
        registerPage.enterPassword("Disha@2023");

        //Enter Confirm Password
        registerPage.enterConfirmPassword("Disha@2023");

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify message "Your registration completed"
        String actualYourRegistrationCompletedMessage = registerPage.verifyRegistrationCompletedMessage();
        String expectedYourRegistrationCompletedMessage = "Your registration completed";
        Assert.assertEquals(actualYourRegistrationCompletedMessage, expectedYourRegistrationCompletedMessage, "Error message is displayed.");
    }
}
