package com.tutorialsninja.testbase;

import com.tutorialsninja.propertyreader.PropertyReader;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.tutorialsninja.browserfactory.ManageBrowser.driver;


public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }
    public void verifyTwoStrings(By by, String text){
        String expected =text;
        String actual = getTextFromElement(by);
        Assert.assertEquals(actual,expected);
    }
    public void selectMethod(By by){
        WebElement components = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(components).click().build().perform();

    }
}
