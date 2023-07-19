package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class MyAccountsTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopsPage;
    ProductPage productPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ShoppingCartPage shoppingCartPage;
    RegisterPage registerPage;
    AccountPage accountPage;
    LogOutPage logOutPage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopPage();
        productPage = new ProductPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        registerPage = new RegisterPage();
        accountPage = new AccountPage();
        loginPage = new LoginPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Dhiren");
        registerPage.enterLastName("Ganvir");
        registerPage.enterEmail("prime");
        registerPage.enterTelephone("07666333111");
        registerPage.enterPassword("Prime@123");
        registerPage.enterConfirmPassword("Prime@123");
        registerPage.clickOnSubscribe();
        registerPage.clickOnPolicy();
        registerPage.clickOnContinueButton();
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");
        accountPage.clickOnContinue();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        logOutPage.clickOnLogout();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmail("prime1233@gmail.com");
        loginPage.enterPassword("test1234");
        loginPage.clickOnLogin();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        logOutPage.clickOnLogout();
    }

}

