package com.ethertons.pages;

import com.ethertons.constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends OnsPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage load() {
        driver.get(Urls.HOST);
        return this;
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.id("welcome")).getText();
    }

    public String getWebSiteAuthorMessage() {
        return driver.findElement(By.id("website-author")).getText();
    }

    public String showGedcoms() {
        return driver.findElement(By.id("upload-gedcom")).getText();
    }
}
