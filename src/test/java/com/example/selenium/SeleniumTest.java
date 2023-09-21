package com.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTest {

    private static FirefoxDriver driver;
    
    /**
     * Opens the driver browser.
     * Is done once, before all the tests run.
     */
    @BeforeAll
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Tests a UI interface, by pushing an add button twice, asserting two new objects with a special class attribute.
     */
    @Test
    public void firefox_Elements_AddAdd_ReturnsTwo(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));

        addButton.click();
        addButton.click();

        saveScreenshot(driver, "selenium-elements-" + LocalDate.now() +".png");

        int size = driver.findElements(By.xpath("//*[@class='added-manually']")).size();
        Assert.assertTrue( size == 2);
    }

    /**
     * Tests a web shop by adding the first product to the shopping cart, asserting a product in the cart.
     */
    @Test
    public void firefox_ShoppingCart_AddFirstProduct_ReturnsOneInCart(){

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addButton.click();

        String items = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();

        saveScreenshot(driver, "selenium-shoppingcart-" + LocalDate.now() +".png");

        Assert.assertTrue( "1".equals(items));
    }

    /**
     * Tests finding Hitchhikers Guide To The Galaxy on saxo.com.
     */
    @Test
    public void firefox_ShoppingCart_SearchHitchHikersGuide_ReturnsAResult(){

        driver.get("https://www.saxo.com/");

        driver.findElement(By.id("CybotCookiebotDialogBodyButtonDecline")).click();
        driver.findElement(By.id("new-search-query")).sendKeys("Hitchhikers guide to the galaxy");
        driver.findElement(By.className("search-form")).submit();
        WebElement anchor = driver.findElement(By.xpath("//a[starts-with(@title,'The Hitchhiker')]"));



        saveScreenshot(driver, "selenium-shoppingcart-" + LocalDate.now() +".png");

        Assert.assertTrue( !anchor.equals(null));
    }

    private void saveScreenshot(RemoteWebDriver driver, String fileName) {
        File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotFileName = fileName;
            FileUtils.copyFile(s, new File(screenshotFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public void closeBrowser(){
       driver.quit();
    }
}
