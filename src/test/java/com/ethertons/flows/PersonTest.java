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
    public void personDetailsShownCorrectly() {
        driver.get("http://localhost:8080/persons/1");
        WebElement firstName = driver.findElement(By.id("firstName"));
        assertThat(firstName.getText(), is("martin"));
        WebElement surname = driver.findElement(By.id("surname"));
        assertThat(surname.getText(), is("etherton"));
        WebElement father = driver.findElement(By.id("father"));
        assertThat(father.getText(), is("sydney etherton"));
        WebElement mother = driver.findElement(By.id("mother"));
        assertThat(mother.getText(), is("nora wilkinson"));
    }
    
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
        WebElement surname = driver.findElement(By.id("surname"));
        firstName.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

    }
}
