package com.raymundo.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class DriverWrapper {

    public static WebDriver driver = null;
    public static String url ="https://darksky.net";//https://www.facebook.com/";//"https://www.expedia.com/",https://darksky.net/;https://www.amazon.com/

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void initializedWebDriver() {

        System.setProperty("webdriver.chrome.driver", "/Users/joselitowilliamraymundo/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
