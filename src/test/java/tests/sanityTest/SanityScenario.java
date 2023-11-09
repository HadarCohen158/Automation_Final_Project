package tests.sanityTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SanityScenario {


    public static void main(String[] args) throws InterruptedException {

        Faker fakeDataGenerator = new Faker();
// הגדרת הכרום כדפדפן
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

//Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

//Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");


        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();

//Validate (using if-else statement) the URL of the page: https://www.saucedemo.com/inventory.html

//url check
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        if (currentUrl.equals(expectedUrl)) {
            System.out.println("the url is corect");
        } else {
            System.out.println("the url is worng");
        }


//• Validate (using if-else statement) the title of the page. בעיה


        String productTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        System.out.println(productTitle);

        if (productTitle.equals(expectedTitle)) {
            System.out.println(expectedTitle + " this is the correct title ");
        } else {
            System.out.println(expectedTitle + "this is  not the correct ");

        }
//  Add 2 products by using their names


            WebElement buttonElement1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            buttonElement1.click();


            WebElement buttonElement2 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
            buttonElement2.click();

// Validate the cart icon presents a correct number of items (2).

            String numberOfItems = driver.findElement(By.cssSelector("[class=\"shopping_cart_badge\"]")).getText();

            String expectedNumberOfItemsText = "2";


            if (numberOfItems.equals(expectedNumberOfItemsText)) {
                System.out.println(expectedNumberOfItemsText +" "+ "this is the correct number");
            } else {
                System.out.println(expectedNumberOfItemsText +" "+ "this is  not the correct number");
            }
            //     Click the icon to navigate to the next step.

            driver.findElement(By.cssSelector("[class=\"shopping_cart_link\"]")).click();

//url check
            String cartUrl = driver.getCurrentUrl();
            System.out.println("currentUrl = " + cartUrl);
            String theCartUrl = "https://www.saucedemo.com/cart.html";

            if (cartUrl.equals(theCartUrl)) {
                System.out.println(cartUrl +" "+ "the url is corect");
            } else {
                System.out.println(cartUrl +" "+ "the url is worng");
            }
            // Validate page title: Your Cart

            String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();

            String titleOfCart = "Your Cart";
            System.out.println(titleOfCart);

            if (title.equals(titleOfCart)) {
                System.out.println(titleOfCart +" " + "this is the correct title ");
            } else {
                System.out.println(titleOfCart +" " + "this is  not the correct ");
            }

            //    Validate a correct number of items (2)

            WebElement cartItemList = driver.findElement(By.cssSelector("[class=\"cart_list\"]"));

            java.util.List<WebElement> cartItems = cartItemList.findElements(By.className("cart_item"));

            int itemCount = cartItems.size();

            System.out.println("the number of the items is: " + itemCount);


//• Click the Checkout button to navigate to the next step

            driver.findElement(By.id("checkout")).click();


//Validate an URL: https://www.saucedemo.com/checkout-step-one.html


            String checkOutUrl = driver.getCurrentUrl();
            System.out.println("currentUrl = " + checkOutUrl);


            String theCheckoutUrl = "https://www.saucedemo.com/checkout-step-one.html";

            if (theCheckoutUrl.equals(checkOutUrl)) {
                System.out.println(theCheckoutUrl + "the url is corect");
            } else {
                System.out.println(theCheckoutUrl + "the url is worng");
            }

//  Validate page title: Checkout: Your Information

            String CheckoutTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();

            String expectedCheckoutTitle = "Checkout: Your Information";


            if (CheckoutTitle.equals(expectedCheckoutTitle)) {
                System.out.println(expectedCheckoutTitle + " " + "this is the correct message ");
            } else {
                System.out.println(expectedCheckoutTitle + " "+ "this is  not the correct ");
            }
//Fill The Form first name

            driver.findElement(By.id("first-name")).sendKeys(fakeDataGenerator.name().firstName());

//Fill The Form last name

            driver.findElement(By.id("last-name")).sendKeys(fakeDataGenerator.name().lastName());
//Fill The Form zip code

            driver.findElement(By.id("postal-code")).sendKeys(fakeDataGenerator.address().zipCode());

//• Click the Continue button to navigate to the next step

            driver.findElement(By.id("continue")).click();

// Validate an URL: https://www.saucedemo.com/checkout-step-two.html

            String theOverviewUrl = driver.getCurrentUrl();
            System.out.println("currentUrl = " + theOverviewUrl);


            String theOverviewUrlOfTHePage = "https://www.saucedemo.com/checkout-step-two.html";

            if (theOverviewUrl.equals(theOverviewUrlOfTHePage)) {
                System.out.println("the url is corect");
            } else {
                System.out.println("the url is worng");
            }

// Validate page title: Checkout: Overview

            String OverviewTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();

            String expectedOverviewTitlePage = "Checkout: Overview";
            System.out.println(expectedOverviewTitlePage);

            if (OverviewTitle.equals(expectedOverviewTitlePage)) {
                System.out.println(expectedOverviewTitlePage + " "+ "this is the correct massage ");
            } else {
                System.out.println(expectedOverviewTitlePage + " " + "this is  not the correct massage ");
            }


// Click the Finish button to navigate to the next step

            driver.findElement(By.id("finish")).click();

// Validate an URL: https://www.saucedemo.com/checkout-complete.html

            String completeUrl = driver.getCurrentUrl();
            System.out.println("currentUrl = " + completeUrl);


            String completeCheckoutUrl = "https://www.saucedemo.com/checkout-complete.html";

            if (completeUrl.equals(completeCheckoutUrl)) {
                System.out.println("the complete url is corect");
            } else {
                System.out.println("the complete url is worng");
            }

//Validate page title: Checkout: Complete!


            String CompleteTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();

            String expectedCompleteTitleTitlePage = "Checkout: Complete!";
            System.out.println(expectedCompleteTitleTitlePage);

            if (CompleteTitle.equals(expectedCompleteTitleTitlePage)) {
                System.out.println(expectedCompleteTitleTitlePage + " " + " this is the correct massage ");
            } else {
                System.out.println(expectedCompleteTitleTitlePage+ " "  + "this is not the correct massage ");
            }



// Validate a text of each one of the presented messages

            String thankYou = driver.findElement(By.cssSelector("[class=\"complete-header\"]")).getText();

            String expectedThankYouTitlePage = "Thank you for your order!";
            System.out.println(expectedThankYouTitlePage);

            if (thankYou.equals(expectedThankYouTitlePage)) {
                System.out.println(expectedThankYouTitlePage+ " " + "the messages is correct  ");
            } else {
                System.out.println(expectedThankYouTitlePage + " "+ "the messages is  notcorrect ");
            }



            String  completeText = driver.findElement(By.cssSelector("[class=\"complete-text\"]")).getText();

            String expectedCompleteTextPage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
            System.out.println(expectedCompleteTextPage);

            if (completeText.equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!")) {
                System.out.println(expectedCompleteTextPage+ " " + "the messages is correct  ");
            } else {
                System.out.println(expectedCompleteTextPage + "the messages is  notcorrect ");
            }
        }
    }
