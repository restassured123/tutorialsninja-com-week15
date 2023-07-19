package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

import static com.tutorialsninja.browserfactory.ManageBrowser.driver;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllDesktops')]")
    WebElement clickOnShowAllDesktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllLaptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement pound;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;


    public void clickOnDesktop() {
        Reporter.log("click On Desktop" + desktop.toString());
        CustomListeners.test.log(Status.PASS, "click On Desktop " + desktop);
        mouseHoverToElementAndClick(desktop);
    }

    public void clickOnShowAllDesktops() {
        Reporter.log("click On Show All Desktops" + clickOnShowAllDesktop.toString());
        CustomListeners.test.log(Status.PASS, "click On Show All Desktops" + clickOnShowAllDesktop);
        clickOnElement(clickOnShowAllDesktop);
    }

    public void selectMenu(String menu) {
        Reporter.log("select Menu" + showAllLaptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "select Menu" + showAllLaptopsAndNotebooks);
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void clickOnLaptopsAndNotebooks() {
        Reporter.log("click On Laptops And Notebooks" + laptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "click On Laptops And Notebooks" + laptopsAndNotebooks);
        clickOnElement(laptopsAndNotebooks);
    }

    public void clickShowAllLaptopsAndNotebooks(String menu) {
        Reporter.log("click Show All Laptops And Notebooks" + showAllLaptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "click Show All Laptops And Notebooks" + showAllLaptopsAndNotebooks);
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void mouseHoverOnLaptopsAndClick() {
        Reporter.log("mouse Hover On Laptops And Click" + laptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "mouse Hover On Laptops And Click" + laptopsAndNotebooks);
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public void selectCurrency() {
        Reporter.log("click on currency" + currency.toString());
        CustomListeners.test.log(Status.PASS, "click on currency" + currency);
        clickOnElement(currency);
        Reporter.log("select pound" + pound.toString());
        CustomListeners.test.log(Status.PASS, "select pound" + pound);
        clickOnElement(pound);
    }

    public void clickOnMyAccount() {
        Reporter.log("click on my account" + myAccount.toString());
        CustomListeners.test.log(Status.PASS, "click on my account" + myAccount);
        clickOnElement(myAccount);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }

    }
}


