package com.ethertons.flows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUpTests() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDownTests() {
//        driver.quit();
    }

}
