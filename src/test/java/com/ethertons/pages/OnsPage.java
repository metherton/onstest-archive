package com.ethertons.pages;

import org.openqa.selenium.WebDriver;

public abstract class OnsPage {
    protected final WebDriver driver;

    public OnsPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract OnsPage load();
}
