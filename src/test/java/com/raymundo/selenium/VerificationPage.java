package com.raymundo.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class VerificationPage extends DriverWrapper {

    @Test
    public void verifyLogin() {

        LandingPage landingPage = new LandingPage();
        LoginPage loginPage = new LoginPage();
        landingPage.enterEmail("jojiraymundo50@yahoo.com");
        landingPage.enterPassword("12345");
        landingPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getRecoverAccountLinkText(), "Recover Your Account");
    }

    @Test
    public void selectGender() throws Exception {
        LandingPage landingPage = new LandingPage();
        landingPage.selectGender();
        Assert.assertEquals(driver.findElement(landingPage.maleRadioButton).isSelected(), true);
        Thread.sleep(5000);
        System.out.println(driver.findElement(landingPage.maleRadioButton).isSelected());
    }

    @Test
    public void verifyInvalidPhoneNumber() throws Exception {
        LandingPage landingPage = new LandingPage();
        SignUpScreen signUpScreen = new SignUpScreen();
        landingPage.clickSignUp();
        signUpScreen.loginToApp("Joselito", "Raymundo", "25423a08431000", "Secret");
        signUpScreen.clickNewAccount();
        Thread.sleep(5000);
        Assert.assertEquals(signUpScreen.isMessageDisplayed(), true);

    }

    @Test
    public void verifyMissingGenderError() throws Exception {
        LandingPage landingPage = new LandingPage();
        landingPage.createNewAccount("Joselito", "Raymundo", "1234567890", "Secret", "Feb", 11, "1967");
        Thread.sleep(5000);
        Assert.assertEquals(landingPage.isErrorMessageDisplayed(), true);
    }

    @Test
    public void navigateToOtherWindow() throws Exception {
        LandingPage landingPage = new LandingPage();
        landingPage.clickDataPolicy();
        Thread.sleep(3000);
        landingPage.goToOtherWindow(1);
        Thread.sleep(3000);
        getDriver().findElement(By.cssSelector("#u_0_4 > div._yl8 > a")).click();
        Thread.sleep(3000);
        landingPage.switchToRootWindow();
    }

    @Test
    public void flightAutoComplete() throws InterruptedException {
        LandingPageExpedia landingPageExpedia = new LandingPageExpedia();
        landingPageExpedia.clickFlightButton();
        landingPageExpedia.enterPointOfOrigin("New York", "John F. Kennedy Intl.");
    }


    @Test
    public void loginAmazon() throws InterruptedException {
        LandingPageAmazon landingPageAmazon = new LandingPageAmazon();
        landingPageAmazon.loginToAmazon("Nickson@yahoo.com", "I dont know");
        Assert.assertEquals(landingPageAmazon.isErrorMessageDisplayed(), true, "Error Message not displayed");
    }


    @Test
    public void verifyDarkskyTime() {
        LandingPageDarkSky landingPageDarkSky = new LandingPageDarkSky();
        landingPageDarkSky.checkTimeLine();
    }
}
