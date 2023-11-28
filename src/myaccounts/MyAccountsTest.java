package myaccounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        //This method should click on the options whatever name is passed as parameter.
        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));//list with two options(do multi select)
        for (WebElement option1 : registerList) {
            if (option1.getText().equals(option)) {
                option1.click();
                break;
            }

    }


    }

        @Test
                public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
            //1.1 Click on My Account Link.
            clickOnElement(By.xpath("//i[@class='fa fa-user']"));
            //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
            selectMyAccountOptions("Register");
            //1.3 Verify the text “Register Account”.
            String expectedText = "Register Account";
            String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
            Assert.assertEquals(expectedText,actualText);
    }
@Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
   //2.1 Click on My Account Link.
    clickOnElement(By.xpath("//i[@class='fa fa-user']"));
    //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
    selectMyAccountOptions("Login");
    //2.3 Verify the text “Returning Customer”.
    String expectedTextLogin = "Returning Customer";
    String actualTextLogin = getTextFromElement(By.xpath("//div[@class='well']/h2[text()='Returning Customer']"));
    Assert.assertEquals("not on login page", expectedTextLogin, actualTextLogin);

    }
    @Test
    public void verifyThatUserRegisterAccountsSuccessfully(){
   //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"ABC");
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"ch");
        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"abc@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"07965432987");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"abc123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"abc123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText = "Your Account Has Been Created!";
        String actualText = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals(expectedText,actualText);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        String expectedTextLogout = "Account Logout";
        String actualTextLogout = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals("not logged out", expectedTextLogout, actualTextLogout);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }
    public void tearDown(){
        closeBrowser();
    }
    }

