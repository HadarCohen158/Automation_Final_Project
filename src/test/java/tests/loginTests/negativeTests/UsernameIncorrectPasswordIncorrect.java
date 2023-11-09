package tests.loginTests.negativeTests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsernameIncorrectPasswordIncorrect {



    @Test(testName = "TestUsernameIncorrectPasswordIncorrect", priority = 1)
    public void  TestUsernameIncorrectPasswordIncorrect(){
// הגדרת הכרום כדפדפן
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

//Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("locked_out_user_incorrect");

//Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce_incorrectr");

        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();

        String  errorbutton =driver.findElement(By.cssSelector("[class=\"error-message-container error\"]")).getText();
        String expectedErrorButtonPage = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(errorbutton ,expectedErrorButtonPage);





    }
}


