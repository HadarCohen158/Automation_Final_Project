package tests.loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsernameCorrectAndPasswordIncorrectTest {


    @Test(testName = "TestUsernameCorrectAndPasswordIncorrect", priority = 1)
    public void  TestUsernameCorrectAndPasswordIncorrect(){

// הגדרת הכרום כדפדפן
        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

//Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

//Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce_incorect");

        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();

        String errorbutton = driver.findElement(By.cssSelector("[class=\"error-message-container error\"]")).getText();
        String expectedErrorButtonPage = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(errorbutton, expectedErrorButtonPage);


        }


    }
