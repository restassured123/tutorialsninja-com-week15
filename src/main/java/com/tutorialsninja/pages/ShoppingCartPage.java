package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import static com.tutorialsninja.browserfactory.ManageBrowser.driver;

public class ShoppingCartPage extends Utility {
    By quantity = By.xpath("//input[contains(@name, 'quantity')]");

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement update;


    public void changeQuantity(String text) {
        WebElement qty = driver.findElement(quantity);
        qty.clear();
        sendTextToElement(quantity, text);
    }
    public void clickOnUpdate(){
        Reporter.log("click On Update" + update.toString());
        CustomListeners.test.log(Status.PASS, "click On Update" + update);
        clickOnElement(update);
    }

}