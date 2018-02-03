package com.raymundo.selenium;

import org.openqa.selenium.By;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class LandingPage extends BasePage{

    private By emailTextField = By.id("email");
    private By passTextField = By.id("pass");
    private By loginButton = By.id("loginbutton");
    public By maleRadioButton = By.id("u_0_c");
    private By signUp = By.xpath("//*[@id=\"js_0\"]/table/tbody/tr[1]/td[1]/a");
    private By errorMessage = By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div");
    private By first = By.name("firstname");
    private By last = By.name("lastname");
    private By mobileNumber = By.name("reg_email__");
    private By newPass = By.name("reg_passwd__");
    private By birthMonth = By.id("month");
    private By birthDay = By.id("day");
    private By birthYear = By.id("year");
    private By createAccount = By.name("websubmit");
    private By policy = By.id("privacy-link");
    //Methods //*[@id="globalContainer"]/div[7]/div

    public void clickSignUp() {
        clickOn(signUp);
    }

    public void enterEmail(String email) {
        setValueToInputField(emailTextField, email);
    }

    public void enterPassword(String password) {
        setValueToInputField(passTextField, password);
    }

    public void clickOnLoginButton() {
        clickOn(loginButton);
    }

    public void selectGender() {
        clickOn(maleRadioButton);
    }

    public void loginToApp(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }

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

    public void enterBirthMonth(String month) {
        selectFromDropDown(birthMonth, month);
    }

    public void enterBirthDay(int index) {
        selectFromDropDown(birthDay, index);
    }

    public void enterBirthYear(String year) {
        selectFromDropDown(birthYear, year);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public void clickOnCreateAccount() {
        clickOn(createAccount);
    }

    public void createNewAccount(String firstName, String lastName, String mobile, String newPassword, String month, int index, String year) throws InterruptedException {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPhoneNumber(mobile);
        enterNewPassword(newPassword);
        enterBirthMonth(month);
        enterBirthDay(index);
        enterBirthYear(year);
        clickOnCreateAccount();
    }

    public void goToOtherWindow(int index) {
        switchToWindow(index);
    }

    public void switchToRootWindow() {
        switchToRootWindowCloseCurrentBrowser();
    }

    public void clickDataPolicy() {
        clickOn(policy);
    }
}
