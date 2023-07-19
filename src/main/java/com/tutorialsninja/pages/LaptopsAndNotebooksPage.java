package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortOption;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbook;



    public void selectSorting(String text) {
        Reporter.log("select Sorting" + sortOption.toString());
        CustomListeners.test.log(Status.PASS, "select Sorting" + sortOption);
        selectByVisibleTextFromDropDown(sortOption, text);
    }
    public void clickOnMacbook(){
        Reporter.log("click On Macbook" + macbook.toString());
        CustomListeners.test.log(Status.PASS, "click On Macbook" + macbook);
        clickOnElement(macbook);
    }

}