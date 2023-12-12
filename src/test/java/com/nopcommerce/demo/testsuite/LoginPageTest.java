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
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {

        //Click on login link
        homePage.clickOnLoginLink();

        //verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.verifyWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage, "Login page not displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyErrorMessageWithInvalidCredentials() {

        //Click on login link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailInEmailField("abc123@gmail.com");

        //Enter Password
        loginPage.enterPasswordInPasswordField("abc123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.verifyErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {

        //click on Register Link
        homePage.clickOnRegisterLink();

        //Select Male or Female Btn
        registerPage.selectGender("Male");

        //Enter First Name
        registerPage.enterFirstName("Disha");

        //Enter Last Name
        registerPage.enterLastName("Patel");

        //Enter Date Of Birth
        registerPage.enterDayOfBirth("4");
        registerPage.enterMonthOfBirth("January");
        registerPage.enterYearOfBirth("1992");

        //Enter Email
        enterEmailAddress();

        //Enter Password
        registerPage.enterPassword("Disha@2023");

        //Enter Confirm Password
        registerPage.enterConfirmPassword("Disha@2023");

        //Click On Register Btn
        registerPage.clickOnRegisterButton();

        //Click on Login Link
        homePage.clickOnLoginLink();

        //Enter EmailId
        loginPage.enterEmailInEmailField(randomEmail);

        // Enter Password
        loginPage.enterPasswordInPasswordField("Disha@2023");

        // Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify that LogOut link is displayed
        Assert.assertEquals(homePage.verifyLogoutLinkIsDisplayed(), "Log out", "Logout Link is not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {

        verifyThatUserShouldLogInSuccessFullyWithValidCredentials();

        //Click on LogOut Link
        homePage.clickOnLogOutBtn();

        //Verify Login Link is displayed
        String expected1 = "Log in";
        String actual1 = loginPage.verifyLoginLink();
        Assert.assertEquals(actual1,expected1,"Log in link not displayed");
    }
}
