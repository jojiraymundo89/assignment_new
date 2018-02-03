package com.raymundo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by joselitowilliamraymundo on 2/1/18.
 */
public class BasePage {

    public void clickOn(By locator) {
        DriverWrapper.getDriver().findElement(locator).click();
    }

    public void setValueToInputField(By locator, String value) {
        DriverWrapper.getDriver().findElement(locator).sendKeys(value);
    }

    public String getTextFromElement(By locator) {
        return DriverWrapper.getDriver().findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return DriverWrapper.getDriver().findElement(locator).isDisplayed();
    }

    public boolean isEnablead(By locator) {
        return DriverWrapper.getDriver().findElement(locator).isEnabled();
    }

    public boolean isSelected(By locator) {
        return DriverWrapper.getDriver().findElement(locator).isSelected();
    }

    public void selectFromDropDown(By locator, String month) {
        Select monthDropDown = new Select(DriverWrapper.getDriver().findElement(locator));
        monthDropDown.selectByVisibleText(month);
    }

    public void selectFromDropDown(By locator, int index) {
        Select monthDropDown = new Select(DriverWrapper.getDriver().findElement(locator));
        monthDropDown.selectByIndex(index);
    }

    public String getAttribute(By locator, String value) {
        return DriverWrapper.getDriver().findElement(locator).getAttribute(value);
    }

    public static void switchToWindow(int index) {
        List<String> listOfWindows = new ArrayList<String>(DriverWrapper.getDriver().getWindowHandles());
        DriverWrapper.getDriver().switchTo().window(listOfWindows.get(index));
    }

    public static void switchToRootWindowCloseCurrentBrowser() {
        List<String> listOfWindows = new ArrayList<String>(DriverWrapper.getDriver().getWindowHandles());
        for (int i = 1; i < listOfWindows.size(); i++) {
            DriverWrapper.getDriver().switchTo().window(listOfWindows.get(i));
            DriverWrapper.getDriver().close();
        }
        DriverWrapper.getDriver().switchTo().window(listOfWindows.get(0));
    }

    public void autoComplete(By locator, By locator2,String searchKey, String choice )  {

        DriverWrapper.getDriver().findElement(locator).sendKeys(searchKey);
        List<WebElement> list = DriverWrapper.getDriver().findElements(locator2);
        for (WebElement element : list) {
            if (element.getText().contains(choice)) {
                element.click();
                break;
            }
        }
    }

    public void selectCurrentDateFromCalendar(By locator, By locator2){
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Date date = new Date();
        String todayDate=sdf.format(date);
        DriverWrapper.getDriver().findElement(locator);
        List<WebElement> days=DriverWrapper.getDriver().findElements(locator2);
        for (WebElement day:days){
            String expectedDay=day.getText();
            if (expectedDay.equals(todayDate)){
                day.click();
                break;
            }
        }

    }
    public static void mouseOver(By locator, By locator2)/*throws InterruptedException*/{
        WebElement element = DriverWrapper.getDriver().findElement(locator);
        Actions action = new Actions(DriverWrapper.getDriver());
        action.moveToElement(element).build().perform();
        //Thread.sleep(2000);
        DriverWrapper.getDriver().findElement(locator2).click();
        //Thread.sleep(2000);

    }

    public static void switchToFrame (String value){
        DriverWrapper.getDriver().switchTo().frame(value);
    }
    public static void alertAccept () {
        DriverWrapper.getDriver().switchTo().alert().accept();
    }

    public static void alertDismiss () {
        DriverWrapper.getDriver().switchTo().alert().dismiss();
    }

    public static void alertGetText () {
        DriverWrapper.getDriver().switchTo().alert().getText();
    }

    public static void alertSendtext (String value) {
        DriverWrapper.getDriver().switchTo().alert().sendKeys(value);
    }
}


