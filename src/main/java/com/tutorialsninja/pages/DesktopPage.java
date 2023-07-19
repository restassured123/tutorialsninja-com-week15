package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

import static com.tutorialsninja.browserfactory.ManageBrowser.driver;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByAToZ;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hPLP3065;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendar;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndyear;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextIcon;
    By alldates = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantity;
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;


    public void selectSorting(String text) {
        Reporter.log("select Sort By Option  " + sortByAToZ.toString());
        CustomListeners.test.log(Status.PASS, "select Sort By Option " + sortByAToZ);
        selectByVisibleTextFromDropDown(sortByAToZ, text);
    }

    public void selectHPLP3065() {
        Reporter.log("select HPLP3065  " + hPLP3065.toString());
        CustomListeners.test.log(Status.PASS, "select HPLP3065  " + hPLP3065);
        clickOnElement(hPLP3065);
    }

    public void datePicker(String y, String m, String d) {
        String year = y;
        String month = m;
        String date = d;
        clickOnElement(calendar);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndyear);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextIcon);
            }
        }
        List<WebElement> allDates = driver.findElements(alldates);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clearQuantity() {
        Reporter.log("clear Quantity " + quantity.toString());
        CustomListeners.test.log(Status.PASS, "clear Quantity " + quantity);
        sendTextToElement(quantity, "1");
    }

    public void clickOnAddToCart() {
        Reporter.log("click On Add To Cart" + addToCart.toString());
        CustomListeners.test.log(Status.PASS, "click On Add To Cart " + addToCart);
        clickOnElement(addToCart);
    }

    public void clickOnShoppingCartLink() {
        Reporter.log("click On Shopping Cart Link" + shoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS, "click On Shopping Cart Link " + shoppingCartLink);
        clickOnElement(shoppingCartLink);
    }


}

