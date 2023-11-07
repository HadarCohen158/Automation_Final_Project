package tests.loginTests.negativeTests;

import com.github.javafaker.Faker;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class username_empty_password_correct {




    public static void main(String[] args) throws InterruptedException {

        Faker fakeDataGenerator = new Faker();
// הגדרת הכרום כדפדפן
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

//Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("");

//Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();


        // Validate (using if-else statement) the text of the error message:

        String  errorbutton =driver.findElement(By.cssSelector("[class=\"error-message-container error\"]")).getText();

        String expectedErrorButtonPage = "Epic sadface: Username is required";
        System.out.println( expectedErrorButtonPage);

        if (errorbutton.equals(expectedErrorButtonPage)) {
            System.out.println( expectedErrorButtonPage+" "+"the messages is correct  ");
        }
        else {
            System.out.println(expectedErrorButtonPage+" "+"the messages is  not correct ");
        }

        driver.close();
        driver.quit();

    }


}
