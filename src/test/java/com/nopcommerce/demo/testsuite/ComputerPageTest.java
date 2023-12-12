package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {

        //Click on Computer tab
        homePage.clickOnComputerTab();

        //Verify "Computer" text
        String actualComputerText = computerPage.verifyComputerText();
        String expectedComputerText = "Computers";
        Assert.assertEquals(actualComputerText, expectedComputerText, "Computers text is not displayed.");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //Click on Computer tab
        homePage.clickOnComputerTab();

        //Click on Desktops link
        desktopsPage.clickOnDesktopsLink();

        //Verify "Desktops" text
        String actualDesktopsText = desktopsPage.verifyDeskTopsText();
        String expectedDesktopsText = "Desktops";
        Assert.assertEquals(actualDesktopsText, expectedDesktopsText, "Desktops text is not displayed.");

    }

    @Test(groups = {"regression"}, dataProvider = "Build your own computer", dataProviderClass = TestData.class)

    public void verifyThatUserShouldBuildYouOwnComputer(String processor, String ram,
                                                        String hdd, String os, String software) throws InterruptedException {

        // Click on Computer tab
        homePage.clickOnComputerTab();

        // Click on Desktops link
        desktopsPage.clickOnDesktopsLink();

        // Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();

        // Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);

        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);
        Thread.sleep(2000);

        // Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);

        // Select OS "os"
        buildYourOwnComputerPage.selectOS(os);

        // Select Software "software"
        buildYourOwnComputerPage.selectSoftware(software);

        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartLink();

        //  Verify message "The product has been added to your shopping cart"
        buildYourOwnComputerPage.getMessageText("The product has been added to your shopping cart");

    }
}
