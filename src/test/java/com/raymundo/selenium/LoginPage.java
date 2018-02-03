package com.raymundo.selenium;

import org.openqa.selenium.By;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class LoginPage extends BasePage {

    private By recoverEmailLink = By.linkText("Recover Your Account");

    public String getRecoverAccountLinkText() {
        return getTextFromElement(recoverEmailLink);
    }
}

