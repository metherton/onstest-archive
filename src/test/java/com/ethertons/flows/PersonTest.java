package com.ethertons.flows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class PersonTest extends SeleniumTest {

    @Test
    public void addPersonFormShouldBeShown() {
        driver.get("http://localhost:8080/persons/new");
        WebElement firstName = driver.findElement(By.id("firstName"));
        assertNotNull(firstName);
    }

    @Test
    public void personDetailsShouldBeShownAfterAddingPerson() throws Exception {
        driver.get("http://localhost:8080/persons/new");
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Martin");
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='etherton']"));
        surname.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        assertThat(driver.findElement(By.id("firstName")).getText(), is("Martin"));
    }
}
