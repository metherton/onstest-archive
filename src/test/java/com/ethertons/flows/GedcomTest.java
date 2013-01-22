package com.ethertons.flows;

import static com.ethertons.constants.Urls.HOST;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ethertons.constants.Urls;

public class GedcomTest extends SeleniumTest {

    private static final String ADD_NEW_GEDCOM_PATH = "/gedcoms/new";

    @BeforeClass
    public static void setUpTest() {
        driver.get(HOST + ADD_NEW_GEDCOM_PATH);
        login();
    }

    @Before
    public void setUp() {
        driver.get(HOST + ADD_NEW_GEDCOM_PATH);
    }

    @Test
    public void uploadGedcomFilePageShouldBeShown() throws Exception {
        assertThat(driver.findElement(By.id("submit")), Matchers.notNullValue());
    }

    @Test
    public void gedcomFileDetailsShouldBeShownAfterAddingGedcomFile() throws Exception {
        WebElement name = driver.findElement(By.id("title"));
        name.sendKeys("test gedcom file" );
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        assertThat(driver.findElement(By.id("title")).getText(), CoreMatchers.is("test gedcom file"));
        assertThat(driver.findElement(By.xpath("//a[@class='mergegedcom']")).getText(), is("Merge Gedcom Contents"));
    }
    
    
}
