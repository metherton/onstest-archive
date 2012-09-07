package com.ethertons.flows;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GedcomTest extends SeleniumTest {


    @BeforeClass
    public static void setUpTest() {
        driver.get("http://localhost:8080/gedcoms/new");
        login();
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/gedcoms/new");
    }

    @Test
    public void uploadGedcomFilePageShouldBeShown() throws Exception {
        assertThat(driver.findElement(By.id("chooseFile")).getText(), is("Choose a gedcom file to upload"));
    }

    @Test
    public void gedcomFileDetailsShouldBeShownAfterAddingGedcomFile() throws Exception {
        WebElement name = driver.findElement(By.id("title"));
        name.sendKeys("test gedcom file" );
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        assertThat(driver.findElement(By.id("title")).getText(), CoreMatchers.is("test gedcom file"));
    }
}
