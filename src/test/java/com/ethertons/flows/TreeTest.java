package com.ethertons.flows;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TreeTest extends SeleniumTest {

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/trees/new");
        login();
        driver.get("http://localhost:8080/trees/new");
    }

    @Test
    public void addTreeFormShouldBeShown() throws Exception {
        WebElement description = driver.findElement(By.name("description"));
        Assert.assertNotNull(description);
    }

    @Test
    public void treeDetailsShouldBeShownAfterAddingTree() throws Exception {
        WebElement description = driver.findElement(By.name("description"));
        description.sendKeys("test tree 1");
        WebElement person = driver.findElement(By.xpath("//select[@id='person']/option[normalize-space(text())='samuel etherton']"));
        person.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        assertThat(driver.findElement(By.id("description")).getText(), is("test tree 1"));
    }
}
