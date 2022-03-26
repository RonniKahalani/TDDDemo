package com.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTest {

    private static ChromeDriver driver;
    private WebElement element;

    /**
     * Opens the driver browser.
     * Is done once, before all the tests run.
     */
    @BeforeAll
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Tests a UI interface, by pushing an add button twice, asserting two new objects with a special class attribute.
     */
    @Test
    public void chrome_Elements_AddAdd_ReturnsTwo(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));

        addButton.click();
        addButton.click();

        int size = driver.findElements(By.xpath("//*[@class='added-manually']")).size();
        Assert.assertTrue( size == 2);
    }

    /**
     * Tests a web shop by adding the first product to the shopping cart, asserting a product in the cart.
     */
    @Test
    public void chrome_ShoppingCart_AddFirstProduct_ReturnsOneInCart(){

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user\t");
        driver.findElement(By.id("password")).sendKeys("secret_sauce\t");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addButton.click();

        String items = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();

        Assert.assertTrue( "1".equals(items));
    }


    @AfterAll
    public void closeBrowser(){
       driver.quit();
    }
}
