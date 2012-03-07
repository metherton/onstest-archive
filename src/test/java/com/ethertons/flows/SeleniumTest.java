package com.ethertons.flows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUpTests() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDownTests() {
        driver.quit();
    }

    protected static void login() {
        try {
            WebElement userName = driver.findElement(By.name("j_username"));
            userName.sendKeys("admin");
            WebElement password = driver.findElement(By.name("j_password"));
            password.sendKeys("dylan1889");
            WebElement submit = driver.findElement(By.name("submit"));
            submit.click();
        }   catch (Exception e) {
            //
        }
    }

}
