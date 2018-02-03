package com.raymundo.selenium;

import org.openqa.selenium.By;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class LandingPageAmazon extends BasePage{

    private By signIn = By.id("nav-link-accountList");
    private By loginButton = By.cssSelector("#nav-flyout-ya-signin > a > span");
    private By email = By.name("email");
    private By passwrd = By.name("password");
    private By submit = By.id("signInSubmit");
    private By errorMessage = By.xpath("//*[@id=\"auth-error-message-box\"]");
    private By messageError = By.className("a-list-item");

    public boolean isErrorMessageDisplayed(){return isDisplayed(errorMessage);}

    public void loginToAmazon(String emailAdd, String password) {
        mouseOver(signIn, loginButton);
        setValueToInputField(email, emailAdd);
        setValueToInputField(passwrd, password);
        clickOn(submit);
        System.out.println(getTextFromElement(messageError));
    }

}
