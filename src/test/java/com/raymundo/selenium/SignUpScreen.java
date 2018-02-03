package com.raymundo.selenium;

import org.openqa.selenium.By;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class SignUpScreen extends BasePage{

    private By first = By.name("firstname");
    private By last = By.name("lastname");
    private By mobileNumber = By.name("reg_email__");
    private By newPass = By.name("reg_passwd__");
    private By createAccount = By.name("websubmit");
    private By message = By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div");
    private By maleRadioButton=By.id("u_0_c");//or u_0_9

    //Methods


    public void enterFirstName(String firstName) {
        setValueToInputField(first, firstName);
    }

    public void enterLastName(String lastName) {
        setValueToInputField(last, lastName);
    }

    public void enterPhoneNumber(String mobile) {
        setValueToInputField(mobileNumber, mobile);
    }

    public void enterNewPassword(String newPassword) {
        setValueToInputField(newPass, newPassword);
    }

    public void selectGender(){ clickOn(maleRadioButton);}

    public void clickNewAccount() {
        clickOn(createAccount);
    }

    public boolean isMessageDisplayed(){return isDisplayed(message);}



    public void loginToApp (String firstName, String lastName, String mobile, String newPassword) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPhoneNumber(mobile);
        enterNewPassword(newPassword);
        selectGender();
    }

    public String getInitialValue (String attribute){return getAttribute(first,attribute);}


}


