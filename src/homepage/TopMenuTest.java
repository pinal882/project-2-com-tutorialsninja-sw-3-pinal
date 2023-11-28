package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Create the package homepage
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 * ● Create the package name desktops
 */
public class TopMenuTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {
        if (menu == "Desktops") {
            //Find Desktop tab, hover and click on "Show All Desktops
            mouseHoverElement(By.xpath("//a[normalize-space()='Desktops']"));
            clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
            String actualText = driver.getTitle();
            String expectedText = "Desktops";
            Assert.assertEquals(expectedText, actualText);
        } else if (menu == "Laptops & Notebooks") {
            mouseHoverElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
            clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
            String actualText = driver.getTitle();
            String expectedText = "Laptops & Notebooks";
            Assert.assertEquals(expectedText, actualText);
        } else if (menu == "Components") {
            mouseHoverElement(By.xpath("//a[normalize-space()='Components']"));
            clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
            String actualText = driver.getTitle();
            String expectedText = "Components";
            Assert.assertEquals(expectedText, actualText);
        } else {
            System.out.println("Elements not found");
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        selectMenu("Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        selectMenu("Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        selectMenu("Components");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

