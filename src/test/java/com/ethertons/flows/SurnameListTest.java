package com.ethertons.flows;


import static org.junit.Assert.assertThat;


import java.util.List;

import com.ethertons.constants.Urls;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SurnameListTest extends SeleniumTest {

    @Test
    public void listOfSurnamesShouldBeShown() throws Exception {
        driver.get(Urls.HOST + "/surnames");
        List<WebElement> surnames = driver.findElements(By.id("surname"));
        assertThat(surnames.size(), Matchers.is(Matchers.greaterThan(0)));
    }

}
