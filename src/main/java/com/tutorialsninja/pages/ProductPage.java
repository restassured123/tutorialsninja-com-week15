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

public class ProductPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendar;
    By monthAndyear = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By nextIcon = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By alldates = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");

    By quantity = By.name("quantity");

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;

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

    public void changeQuantity(){
        WebElement qty = driver.findElement(quantity);
        qty.clear();
        sendTextToElement(quantity,"1");
    }
    public void clickOnAddToCart(){
        Reporter.log("click On Add To Cart" + addToCart.toString());
        CustomListeners.test.log(Status.PASS, "click On Add To Cart" + addToCart);
        clickOnElement(addToCart);
    }
    public void clickOnShoppingCart(){
        Reporter.log("click On Shopping Cart" + shoppingCart.toString());
        CustomListeners.test.log(Status.PASS, "click On Shopping Cart" + shoppingCart);
        clickOnElement(shoppingCart);
    }


}