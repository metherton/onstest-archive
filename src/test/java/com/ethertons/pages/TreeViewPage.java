package com.ethertons.pages;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.ethertons.constants.Urls;
import com.ethertons.domain.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TreeViewPage {

    private static final String TREE_VIEW_URL = Urls.HOST + "/trees/";
    private final WebDriver driver;

    public TreeViewPage(WebDriver driver) {
        this.driver = driver;
    }

    public TreeViewPage loadTreeFor(Person selectedPerson) {
        driver.get(TREE_VIEW_URL + selectedPerson.getId() + "/view");
        return this;
    }

    public List<Person> firstGeneration() {
        List<Person> firstGeneration = newArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@style,'top: 0em')]//div[@class='fullname']"));
        for (WebElement element: elements) {
            int personId = Integer.parseInt(element.getAttribute("id"));
            Person person = new Person();
            person.setId(personId);
            person.setFullname(element.getText());
            firstGeneration.add(person);
        }
        return firstGeneration;
    }

    public List<Person> secondGeneration() {
        List<Person> secondGeneration = newArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@style,'top: 8em')]//div[@class='fullname']"));
        for (WebElement element: elements) {
            int personId = Integer.parseInt(element.getAttribute("id"));
            Person person = new Person();
            person.setId(personId);
            person.setFullname(element.getText());
            secondGeneration.add(person);
        }
        return secondGeneration;
    }

    public List<Person> thirdGeneration() {
        List<Person> thirdGeneration = newArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@style,'top: 16em')]//div[@class='fullname']"));
        for (WebElement element: elements) {
            int personId = Integer.parseInt(element.getAttribute("id"));
            Person person = new Person();
            person.setId(personId);
            person.setFullname(element.getText());
            thirdGeneration.add(person);
        }
        return thirdGeneration;
    }


}
