package tests.sanityTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {

    WebDriver driver = new ChromeDriver();
    String domain = "www.saucedemo.com";
    Faker fakeDataGenerator = new Faker();

    @Test(testName = "testLogin", priority = 1)
    public void testLogin() {

        driver.manage().window().maximize();
        driver.get(String.format("https://%s", domain));
        // הגדרת הכרום כדפדפן
        //WebDriverManager.chromedriver().setup();


        //Login with the user standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        //Login with the password   secret_sauce
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");


        driver.findElement(By.cssSelector("[class=\"submit-button btn_action\"]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), String.format("https://%s/inventory.html", domain));

    }

    @Test(testName = "testInventoryUrl", priority = 2)
    public void testInventoryUrl() {


//url check
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        String expectedUrl = String.format("https://%s/inventory.html",domain);

        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @Test(testName = "testProductsTitle", priority = 3)
    public void testProductsTitle() {

        //Validate (using if-else statement) the title of the page. בעיה
        String productTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedTitle = "Products";
        Assert.assertEquals(productTitle, expectedTitle);
    }


    @Test(testName = "TestAddTwoProducts", priority = 4)
    public void TestAddTwoProducts() {

        WebElement buttonElement1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        buttonElement1.click();

        WebElement buttonElement2 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        buttonElement2.click();

        String numberOfItems = driver.findElement(By.cssSelector("[class=\"shopping_cart_badge\"]")).getText();

        String expectedNumberOfItemsText = "2";

        Assert.assertEquals(numberOfItems, expectedNumberOfItemsText);
    }

    @Test(testName = "testShoppingCartLink", priority = 5)
    public void testShoppingCartLink() {

        // Click the icon to navigate to the next step.
        driver.findElement(By.cssSelector("[class=\"shopping_cart_link\"]")).click();

        //url check
        String cartUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + cartUrl);
        String theCartUrl = String.format("https://%s/cart.html",domain);

        Assert.assertEquals(cartUrl, theCartUrl);
    }

    @Test(testName = "testTitleOfCart", priority = 6)
    public void testTitleOfCart() {
        String title = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String titleOfCart = "Your Cart";
        System.out.println(titleOfCart);

        Assert.assertEquals(title, titleOfCart);
    }

    @Test(testName = "testItemCount", priority = 7)
    public void testItemCount() {

        //    Validate a correct number of items (2)
        WebElement cartItemList = driver.findElement(By.cssSelector("[class=\"cart_list\"]"));

        java.util.List<WebElement> cartItems = cartItemList.findElements(By.className("cart_item"));
        int itemCount = cartItems.size();
        System.out.println("the number of the items is: " + itemCount);

        Assert.assertEquals(itemCount ,2);
    }

    @Test(testName = "testCheckOutButton", priority = 8)
    public void testCheckOutButton() {

        driver.findElement(By.id("checkout")).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        String checkoutUrl = String.format("https://%s/checkout-step-one.html", domain);

        Assert.assertEquals(currentUrl, checkoutUrl);

    }

    @Test(testName = "testCheckOutTitle", priority = 9)
    public void checkOutTitle() {
        String CheckoutTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedCheckoutTitle = "Checkout: Your Information";

        Assert.assertEquals(CheckoutTitle, expectedCheckoutTitle);
    }

    @Test(testName = "PersonalDetails", priority = 10)
    public void FirstName() {
        driver.findElement(By.id("first-name")).sendKeys(fakeDataGenerator.name().firstName());
        driver.findElement(By.id("last-name")).sendKeys(fakeDataGenerator.name().lastName());
        driver.findElement(By.id("postal-code")).sendKeys(fakeDataGenerator.address().zipCode());
        driver.findElement(By.id("continue")).click();
        String currentUrlOverviewUrl = driver.getCurrentUrl();
        String expectedOverviewUrlOfTHePage = String.format("https://%s/checkout-step-two.html",domain);

        Assert.assertEquals(currentUrlOverviewUrl, expectedOverviewUrlOfTHePage);
    }

    @Test(testName = "testOverviewTitle", priority = 11)
    public void testOverviewTitle() {
        String currentOverviewTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        String expectedOverviewTitlePage = "Checkout: Overview";

        Assert.assertEquals(currentOverviewTitle ,expectedOverviewTitlePage);
    }

    @Test(testName = "testFinishButton", priority = 12)
    public void testFinishButton() {
        driver.findElement(By.id("finish")).click();
        String currentcompleteUrl = driver.getCurrentUrl();
        String expectedcompleteUrl = String.format("https://%s/checkout-complete.html",domain);

        Assert.assertEquals(currentcompleteUrl ,expectedcompleteUrl);
    }

    @Test(testName = "testCompleteTitle", priority = 13)
    public void testCompleteTitle() {

        String testCompleteTitle = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();

        String expectedCompleteTitleTitlePage = "Checkout: Complete!";
        System.out.println(expectedCompleteTitleTitlePage);
        Assert.assertEquals(testCompleteTitle ,expectedCompleteTitleTitlePage);

        String testThankYouTitle = driver.findElement(By.cssSelector("[class=\"complete-header\"]")).getText();
        String expectedThankYouTitle = "Thank you for your order!";
        Assert.assertEquals(testThankYouTitle ,expectedThankYouTitle);

        String  testCompleteText = driver.findElement(By.cssSelector("[class=\"complete-text\"]")).getText();
        String expectedCompleteTextPage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(testCompleteText ,expectedCompleteTextPage);
    }
}

















