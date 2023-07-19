package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class HomePageTest extends BaseTest {
        HomePage homePage = new HomePage();


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnDesktop();
        homePage.clickOnShowAllDesktops();
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.clickOnLaptopsAndNotebooks();
        homePage.clickShowAllLaptopsAndNotebooks("Show AllLaptops & Notebooks");
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }
    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        selectMethod(By.linkText("Components"));
        selectMethod(By.linkText("Show AllComponents"));
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Components')]"),"Components");

    }
}
