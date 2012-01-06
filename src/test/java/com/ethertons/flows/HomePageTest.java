package com.ethertons.flows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class HomePageTest extends SeleniumTest {

    @Test
    public void homePageShouldShowWelcomeMessage() {
        driver.get("http://localhost:8080/");
        WebElement welcomeHeader = driver.findElement(By.id("welcome"));
        assertThat(welcomeHeader.getText(), is("Welcome to the Etherton One Name Study"));
        WebElement webSiteAuthor = driver.findElement(By.id("website-author"));
        assertThat(webSiteAuthor.getText(), is("Site is maintained by Martin Etherton"));
    }

}
