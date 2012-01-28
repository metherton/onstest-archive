package com.ethertons.flows;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.ethertons.constants.Urls;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TreeListTest extends SeleniumTest {

    @Test
    public void listOfTreesShouldBeShown() throws Exception {
        driver.get(Urls.HOST + "/trees");
        List<WebElement> trees = driver.findElements(By.id("tree"));
        assertThat(trees.size(), is(Matchers.greaterThan(0)));
    }
}
