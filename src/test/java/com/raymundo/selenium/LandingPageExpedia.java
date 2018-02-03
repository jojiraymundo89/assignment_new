package com.raymundo.selenium;

import org.openqa.selenium.By;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class LandingPageExpedia extends BasePage{

    private By flightButton=By.xpath("//*[@id='tab-flight-tab-hp']");
    private By origin = By.xpath("//*[@id='flight-origin-hp-flight']");
    private By searchResult = By.className("results-item");

    public void clickFlightButton (){
        clickOn(flightButton);
    }

    public void enterPointOfOrigin(String searchCriteria,String choice){
        autoComplete(origin,searchResult,searchCriteria,choice);
    }
}
