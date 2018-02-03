package com.raymundo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class LandingPageDarkSky extends BasePage {

    private By timeLabel = By.className("hour");

    public void checkTimeLine() {

        List<String> baseTime = new ArrayList<>();
        List<String> skyTime = new ArrayList<>();
        DateFormat sdf = new SimpleDateFormat("haa");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
        baseTime.add("Now");
        for (int i = 1; i < 12; i++) {
            calendar.add(10, 2);
            calendar.getTime();
            String gap = sdf.format(calendar.getTime()).toLowerCase();
            baseTime.add(gap);
        }

        List<WebElement> list = DriverWrapper.getDriver().findElements(timeLabel);
        for (WebElement element : list) {
            if (!element.getText().isEmpty())
                skyTime.add(element.getText());
        }

        for (int i = 0; i < baseTime.size(); i++)
            System.out.println("           " + skyTime.get(i) + "           " + baseTime.get(i));

        System.out.println("");
        System.out.println("          ACTUAL       EXPECTED");

        Assert.assertEquals(skyTime, baseTime);
    }
}
