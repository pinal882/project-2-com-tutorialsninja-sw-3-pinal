package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void getTextFromAlert() {
        driver.switchTo().alert().getText();
    }

    public void sendTextFromAlert() {
        driver.switchTo().alert().sendKeys("Text");
    }

    //*****************************Select Class Methods*****************************************************
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create the object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    //****************************Action method*****************************************************
    public void mouseHoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //*********************************************************************
    public void productInDescendingOrder() {
        List<WebElement> price = driver.findElements(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=p.price&order=DESC']"));
        List<String> prices = new ArrayList<>();//get prices from the price elements and store in a list
        for (WebElement e : price) {
            prices.add(e.getText());
        }
        List<String> sortedPrices = new ArrayList<String>(prices);//make a copy of the list
        Collections.sort(sortedPrices);//sort the list
        System.out.println(sortedPrices.equals(prices));//true if prices are sorted
    }

    //_________________________________________________________________________________________________
/*
    This method will select dropdown option using text displayed
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    }
