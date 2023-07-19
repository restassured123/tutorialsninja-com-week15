package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement radioYes;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement policy;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;



    public void enterFirstName(String text){
        Reporter.log("enter First Name" + firstName.toString());
        CustomListeners.test.log(Status.PASS, "enter First Name" + firstName);
        sendTextToElement(firstName,text + getAlphaNumericString(4));
    }
    public void enterLastName(String text){
        Reporter.log("enter last Name" + lastName.toString());
        CustomListeners.test.log(Status.PASS, "enter last Name" + lastName);
        sendTextToElement(lastName,text + getAlphaNumericString(4));
    }
    public void enterEmail(String text){
        Reporter.log("enter email Name" + email.toString());
        CustomListeners.test.log(Status.PASS, "enter email Name" + email);
        sendTextToElement(email,text + getAlphaNumericString(4) + "@gmail.com");
    }
    public void enterTelephone(String text){
        Reporter.log("enter ph No." + telephone.toString());
        CustomListeners.test.log(Status.PASS, "enter ph No." + telephone);
        sendTextToElement(telephone,text);
    }
    public void enterPassword(String text){
        Reporter.log("enter password" + password.toString());
        CustomListeners.test.log(Status.PASS, "enter password" + password);
        sendTextToElement(password,text);
    }
    public void enterConfirmPassword(String text){
        Reporter.log("enter confirm password" + confirmPassword.toString());
        CustomListeners.test.log(Status.PASS, "enter confirm password" + confirmPassword);
        sendTextToElement(confirmPassword,text);
    }
    public void clickOnSubscribe(){
        Reporter.log("click On Subscribe" + radioYes.toString());
        CustomListeners.test.log(Status.PASS, "click On Subscribe" + radioYes);
        clickOnElement(radioYes);
    }
    public void clickOnPolicy(){
        Reporter.log("click On policy" + policy.toString());
        CustomListeners.test.log(Status.PASS, "click On policy" + policy);
        clickOnElement(policy);
    }
    public void clickOnContinueButton(){
        Reporter.log("click On continue tab" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "click On continue tab" + continueButton);
        clickOnElement(continueButton);
    }

}
