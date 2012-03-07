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

public class SurnameTest extends SeleniumTest {

    public static final String ADD_NEW_SURNAME_PATH = "/surnames/new";

    @BeforeClass
    public static void setUpTest() {
        driver.get(Urls.HOST + ADD_NEW_SURNAME_PATH);
        login();
    }

    @Before
    public void setUp() throws Exception {
        driver.get(Urls.HOST + ADD_NEW_SURNAME_PATH);
    }

    @Test
    public void addSurnameFormShouldBeShown() throws Exception {
        WebElement surname = driver.findElement(By.id("name"));
        assertNotNull(surname);
    }

    @Test
    public void surnameDetailsShouldBeShownAfterAddingSurname() throws Exception {
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("testname" );
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        assertThat(driver.findElement(By.id("name")).getText(), is("testname"));
    }
}
