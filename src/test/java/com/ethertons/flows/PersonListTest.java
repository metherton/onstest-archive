package com.ethertons.flows;

import com.ethertons.constants.Urls;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PersonListTest extends SeleniumTest {

    @Test
    public void listOfPersonsShouldBeShown() throws Exception {
        driver.get(Urls.HOST + "/persons");
        List<WebElement> persons = driver.findElements(By.id("person"));
        assertThat(persons.size(), is(Matchers.greaterThan(0)));
    }
}
