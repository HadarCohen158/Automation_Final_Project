package tests.loginTests.posativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorUserTest {

    @Test(testName = "TestErrorUser", priority = 1)
    public void  TestErrorUser() {
// הגדרת הכרום כדפדפן
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

//Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("error_user");

//Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");


        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();


        //url check
        String currentUrl = driver.getCurrentUrl();
        String Expected = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(currentUrl,Expected);




        String  productsTitle =driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String  expectedProductsTitlePage = "Products";

        Assert.assertEquals(productsTitle, expectedProductsTitlePage);



    }
}




