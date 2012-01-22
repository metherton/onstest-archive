package com.ethertons.flows;

import com.ethertons.constants.Urls;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class PersonTest extends SeleniumTest {

    public static final String ADD_NEW_PERSON_PATH = "/persons/new";

    @BeforeClass
    public static void setUpGlobalData() {
        addPerson("father", "gender2");
        addPerson("mother", "gender1");
    }

    @Before
    public void setUp() throws Exception {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
    }

    @Test
    public void addPersonFormShouldBeShown() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        assertNotNull(firstName);
    }

    @Test
    public void personDetailsShouldBeShownAfterAddingPerson() throws Exception {
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Martin");
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='etherton']"));
        surname.click();
        WebElement father = driver.findElement(By.xpath("//select[@id='father']/option[normalize-space(text())='father etherton']"));
        father.click();
        WebElement mother = driver.findElement(By.xpath("//select[@id='mother']/option[normalize-space(text())='mother etherton']"));
        mother.click();
        WebElement gender = driver.findElement(By.id("gender2"));
        gender.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        assertThat(driver.findElement(By.id("firstName")).getText(), is("Martin"));
        assertThat(driver.findElement(By.id("gender")).getText(), is("Male"));
        assertThat(driver.findElement(By.id("father")).getText(), is("father etherton"));
        assertThat(driver.findElement(By.id("mother")).getText(), is("mother etherton"));
    }

    private static void addPerson(String firstNameValue, String genderSelection) {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(firstNameValue);
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='etherton']"));
        surname.click();
        WebElement gender = driver.findElement(By.id(genderSelection));
        gender.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();        
    }

    private static void addMother() {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("mother");
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='etherton']"));
        surname.click();
        WebElement gender = driver.findElement(By.id("gender1"));
        gender.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    private static void addFather() {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("father");
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='etherton']"));
        surname.click();
        WebElement gender = driver.findElement(By.id("gender2"));
        gender.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

}
