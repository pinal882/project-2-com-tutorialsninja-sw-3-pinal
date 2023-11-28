package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverElement(By.xpath("//a[normalize-space()='Desktops']"));
        clickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        productInDescendingOrder();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        mouseHoverElement(By.xpath("//i[@class='fa fa-caret-down']"));
        clickOnElement(By.xpath("//i[@class='fa fa-caret-down']"));
        //2.2 Mouse hover on £Pound Sterling and click
        mouseHoverElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        clickOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        //2.3 Mouse hover on Desktops Tab.
        mouseHoverElement(By.xpath("//a[normalize-space()='Desktops']"));
        //2.4 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //2.5 Select Sort By position "Name: A to Z"
        //selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"),"20");
        //2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        //2.7 Verify the Text "HP LP3065"
        // String expectedText = "HP LP3065";
        //String  actualText = getTextFromElement(By.xpath("//title[text()='HP LP3065']"));
        //Assert.assertEquals(expectedText,actualText);
        //2.8 Select Delivery Date "2023-11-27"
        String year = "2023";
        String month = "11";
        String date = "27";
        clickOnElement(By.xpath("//label[normalize-space()='Delivery Date']"));//open the calendar
        while (true) {
            String monthYear = getTextFromElement(By.xpath("//label[normalize-space()='Delivery Date']"));
            System.out.println(monthYear);
            String[] a = monthYear.split("");

            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//input[@id='input-option225']"));
            }
            //2.9.Enter Qty "1” using Select class.
            driver.findElement(By.xpath("//input[@id='input-quantity']"));
            sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
            //2.10 Click on “Add to Cart” button
            clickOnElement(By.xpath("//button[@id='button-cart']"));
            //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
            String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!\n";
            String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            String[] actualmsg = actualText1.split("×");
           // Assert.assertEquals(expectedText1, actualText1);
            //2.12 Click on link “shopping cart” display into success message
            clickOnElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

            //2.13 Verify the text "Shopping Cart"
            //String expectedText2 = "Shopping Cart  (1.00kg)";
            //String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
            //Assert.assertEquals(expectedText2,actualText2);
            //2.14 Verify the Product name "HP LP3065"
            String expectedText3 = "HP LP3065";
            String actualText3 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
            Assert.assertEquals(expectedText3, actualText3);
            //2.15 Verify the Delivery Date "2023-11-27"
            selectDate("30", "November", "2022");
            //String expectedText4 = "Delivery Date:2023-11-27";
            //String actualText4 = getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"));
            //Assert.assertEquals(expectedText4, actualText4);
            //2.16 Verify the Model "Product21"
            String expectedText5 = "Product 21";
            String actualText5 = getTextFromElement(By.xpath("//td[normalize-space()='Product 21']"));
            Assert.assertEquals(expectedText5, actualText5);
            //2.17 Verify the Todat "£74.73"
            String expectedText6 = "£74.73";
            String actualText6 = getTextFromElement(By.xpath("//tbody//tr//td[6]"));
            Assert.assertEquals(expectedText6, actualText6);

        }
    }

    public void selectDate(String date, String month, String year) throws InterruptedException {
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
            }
        }

        Thread.sleep(1000);
        // Select the date
        List<WebElement> allDates = driver.findElements(By.xpath("//*[@class='datepicker-days']//tbody//tr//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}



