package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNoteBooksTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // 1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        // 1.4 Verify the Product price will arrange in High to Low order.
        productInDescendingOrder();
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //2.3 Select Sort By "Price (High > Low)"
        // selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"),"20");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook Pro']"));
        //2.5 Verify the text “MacBook”
        String expectedText = "MacBook Pro";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook Pro']"));
        Assert.assertEquals(expectedText, actualText);
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText2 = "Success: You have added MacBook Pro to your shopping cart!\n×";
        String actualText2 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedText2, actualText2);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.9 Verify the text "Shopping Cart"
        String expectedText3 = "Shopping Cart  (0.00kg)";
        String actualText3 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h1[1]"));
        Assert.assertEquals(expectedText3, actualText3);
        //2.10 Verify the Product name "MacBook"
        String expectedText4 = "MacBook";
        String actualText4 = getTextFromElement(By.xpath("//div[@id='content']/form/div/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals(expectedText4, actualText4);
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//div[@class='input-group btn-block']//span[@class='input-group-btn']"));
        getTextFromElement(By.xpath("//div[@class='input-group btn-block']//span[@class='input-group-btn']"));
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedText5 = "Success: You have modified your shopping cart!";
        String actualText5 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedText5, actualText5);
        //2.14 Verify the Total £737.45
        String expectedText6 = "£737.45";
        String actualText6 = getTextFromElement(By.xpath("//tbody//tr//td[6]"));
        Assert.assertEquals(expectedText6, actualText6);
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //2.16 Verify the text “Checkout”
        String expectedText7 = "Checkout";
        String actualText7 = getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        Assert.assertEquals(expectedText7, actualText7);
        //2.17 Verify the Text “New Customer”
        String expectedText8 = "New Customer";
        String actualText8 = getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']"));
        Assert.assertEquals(expectedText8, actualText8);
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "ABC");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "xy");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "abc@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "07896564321");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "21, Drury Lane");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "Harrow");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "ha3 6df");
        sendTextToElement(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        sendTextToElement(By.xpath("//select[@id='input-payment-zone']"), "Bedfordshire");
//2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//div[@class='panel-body']/p[2]/textarea[@name='comment']"), "Deliver ASAP");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        String expectedText9 = "Warning: Payment method required!";
        String actualText9 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals(expectedText9, actualText9);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

