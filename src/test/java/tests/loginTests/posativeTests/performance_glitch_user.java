package tests.loginTests.posativeTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class performance_glitch_user {

    public static void main(String[] args) throws InterruptedException {

        Faker fakeDataGenerator = new Faker();
// הגדרת הכרום כדפדפן
      //  WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

//Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("performance_glitch_user");

//Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");


        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();


        //url check
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        String Expected = "https://www.saucedemo.com/inventory.html";

        if (currentUrl.equals(Expected)) {
            System.out.println("the url is currect");
        } else {
            System.out.println("the url is worng");
        }

//Validate (using if-else statement) the title of the page.

        String  productsTitle =driver.findElement(By.cssSelector("[class=\"title\"]")).getText();

        String  expectedProductsTitlePage = "Products";
        System.out.println(expectedProductsTitlePage);

        if (productsTitle.equals(expectedProductsTitlePage)) {
            System.out.println(expectedProductsTitlePage+" "+"this is the correct  Mmessage");
        }
        else {
            System.out.println(expectedProductsTitlePage+" "+ "this is  not the correct Mmessage ");
        }


    }
}

