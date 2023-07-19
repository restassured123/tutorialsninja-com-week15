package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tutorialsninja.browserfactory.ManageBrowser.driver;

@Listeners(CustomListeners.class)

public class DesktopsPageTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ShoppingCartPage shoppingCartPage;
    RegisterPage registerPage;
    AccountPage accountPage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        registerPage = new RegisterPage();
        accountPage = new AccountPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.clickOnDesktop();
        Thread.sleep(3000);
        homePage.clickOnShowAllDesktops();
        //desktopPage.setSortZToA();
        Thread.sleep(2000);

        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        // Sort By Reverse order
        Collections.reverse(originalProductsName);

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        Thread.sleep(3000);
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        Assert.assertEquals(afterSortByZToAProductsName, originalProductsName, "Product not arrange in descending order.");

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.clickOnDesktop();
        homePage.clickOnShowAllDesktops();
        Thread.sleep(2000);
        desktopPage.selectSorting("Name (A - Z)");
        Thread.sleep(5000);
        desktopPage.selectHPLP3065();
        Thread.sleep(3000);
        verifyTwoStrings(By.xpath("//a[contains(text(),'HP LP3065')]"), "HP LP3065");
        Thread.sleep(2000);
        desktopPage.datePicker("2022", "November", "30");
        Thread.sleep(2000);
        desktopPage.clearQuantity();
        desktopPage.clickOnAddToCart();
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"), "Success: You have added HP LP3065 to your shopping cart!\n" + "×");
        Thread.sleep(2000);
        desktopPage.clickOnShoppingCartLink();
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart  (11.00kg)");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "HP LP3065");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"), "Delivery Date:2022-11-30");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//td[contains(text(),'Product 21')]"), "Product 21");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//tbody/tr[1]/td[6]"), "$1,342.00");
        Thread.sleep(2000);

    }
}
