package tests.loginTests.negativeTests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsernameEmptyPasswordEmpty {

    @Test(testName = "TestUsernameEmptyPasswordEmpty", priority = 1)
    public void TestUsernameEmptyPasswordEmpty() {


// הגדרת הכרום כדפדפן
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

//Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("");

//Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("");

        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();


        String  errorbutton =driver.findElement(By.cssSelector("[class=\"error-message-container error\"]")).getText();
        String exectedErrorButtonPage = "Epic sadface: Username is required";

        Assert.assertEquals(errorbutton,exectedErrorButtonPage);




    }



}

