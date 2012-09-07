package com.ethertons.pages;

import java.util.List;

import com.ethertons.constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GedcomListPage extends OnsPage {

    private static final String GEDCOM_LIST_URL = Urls.HOST + "/gedcoms";

    public GedcomListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GedcomListPage load() {
        driver.get(GEDCOM_LIST_URL);
        return this;
    }

    public boolean hasGedcoms() {
        List<WebElement> gedcoms = driver.findElements(By.id("gedcom"));
        if (((gedcoms.size() > 0) ? true : false)) return true;
        else return false;
    }

}
