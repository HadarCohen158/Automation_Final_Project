package tests.sanityTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SanityScenarioTest {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = setupWebDriver();
        String titleCssSelector = "[class=\"title\"]";
        String domainName = "www.saucedemo.com";

        login(driver);

        validateLoginURL(driver);

        validatePageTitle(driver, titleCssSelector, "Products");

        addAndVerifyTwoProducts(driver);

        urlCheckByCssSelector(driver, "[class=\"shopping_cart_link\"]", domainName, "cart.html");

        validatePageTitle(driver, titleCssSelector, "Your Cart");

        validateProductNumberInCart(driver);

        urlCheckById(driver, "checkout", domainName, "checkout-step-one.html");

        validatePageTitle(driver, titleCssSelector, "Checkout: Your Information");

        fillPersonalDetailsForm(driver);

        checkout2UrlCheck(driver);

        validatePageTitle(driver, titleCssSelector, "Checkout: Overview");

        urlCheckById(driver, "finish", domainName, "checkout-complete.html");

        validatePageTitle(driver, titleCssSelector, "Checkout: Complete!");

        validateUserCompleteMessage(driver);
    }

    private static void urlCheckByCssSelector(WebDriver driver, String cssSelector, String domain, String url) {
        // Click the icon to navigate to the next step.
        driver.findElement(By.cssSelector(cssSelector)).click();

        // url check
        String cartUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + url);
        String doaminName = domain + "/" + url;
        String theCartUrl = String.format("https://%s", doaminName);

        if (cartUrl.equals(theCartUrl)) {
            System.out.println(cartUrl +" "+ "the url is corect");
        } else {
            System.out.println(cartUrl +" "+ "the url is worng");
        }
    }

    private static void urlCheckById(WebDriver driver, String id, String domain, String url) {
        // Click the icon to navigate to the next step.
        driver.findElement(By.id(id)).click();

        // url check
        String cartUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + url);
        String doaminName = domain + "/" + url;
        String theCartUrl = String.format("https://%s", doaminName);

        if (cartUrl.equals(theCartUrl)) {
            System.out.println(cartUrl +" "+ "the url is corect");
        } else {
            System.out.println(cartUrl +" "+ "the url is worng");
        }
    }

    private static void validatePageTitle(WebDriver driver, String cssSelector, String pageTitle ) {
        //• Validate (using if-else statement) the title of the page
        String productTitle = driver.findElement(By.cssSelector(cssSelector)).getText();
        System.out.println(productTitle);

        if (productTitle.equals(pageTitle)) {
            System.out.println(pageTitle + " this is the correct title ");
        } else {
            System.out.println(pageTitle + "this is  not the correct ");
        }
    }

    private static void validateUserCompleteMessage(WebDriver driver) {
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

    private static void checkout2UrlCheck(WebDriver driver) {
        // Validate an URL: https://www.saucedemo.com/checkout-step-two.html
        String theOverviewUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + theOverviewUrl);

        String theOverviewUrlOfTHePage = "https://www.saucedemo.com/checkout-step-two.html";

        if (theOverviewUrl.equals(theOverviewUrlOfTHePage)) {
            System.out.println("the url is corect");
        } else {
            System.out.println("the url is worng");
        }
    }

    private static void fillPersonalDetailsForm(WebDriver driver) {
        Faker fakeDataGenerator = new Faker();

        //Fill The Form first name
        driver.findElement(By.id("first-name")).sendKeys(fakeDataGenerator.name().firstName());

        //Fill The Form last name
        driver.findElement(By.id("last-name")).sendKeys(fakeDataGenerator.name().lastName());

        //Fill The Form zip code
        driver.findElement(By.id("postal-code")).sendKeys(fakeDataGenerator.address().zipCode());

        //• Click the Continue button to navigate to the next step
        driver.findElement(By.id("continue")).click();
    }

    private static void validateProductNumberInCart(WebDriver driver) {
        // Validate a correct number of items (2)
        WebElement cartItemList = driver.findElement(By.cssSelector("[class=\"cart_list\"]"));
        java.util.List<WebElement> cartItems = cartItemList.findElements(By.className("cart_item"));
        int itemCount = cartItems.size();
        System.out.println("the number of the items is: " + itemCount);
    }

    private static void addAndVerifyTwoProducts(WebDriver driver) {
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
    }

    private static void validateLoginURL(WebDriver driver) {
        // Validate (using if-else statement) the URL of the page: https://www.saucedemo.com/inventory.html
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        if (currentUrl.equals(expectedUrl)) {
            System.out.println("the url is corect");
        } else {
            System.out.println("the url is worng");
        }
    }

    private static void login(WebDriver driver) {
        //Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        //Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();
    }

    private static WebDriver setupWebDriver() {
        // WebDriver setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        return driver;
    }
}
