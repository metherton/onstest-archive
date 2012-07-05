package com.ethertons.pages;

import java.util.Date;
import java.util.List;

import com.ethertons.constants.Urls;
import com.ethertons.domain.Person;
import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonListPage extends OnsPage {

    public PersonListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PersonListPage load() {
        driver.get(Urls.HOST + "/persons");
        return this;
    }

    public List<Person> getPersons() {
        List<Person> persons = Lists.newArrayList();
        List<WebElement> personSnippets = driver.findElements(By.xpath("//div[@class='person']"));
        for (WebElement personSnippet : personSnippets) {
            Person person = new Person();
            person.setId(Integer.parseInt(personSnippet.getAttribute("id")));
            person.setFullname(personSnippet.findElement(By.xpath("div[@id='personFullName']")).getText().trim());
            String birthDate = personSnippet.findElement(By.xpath("div[@id='personBirthDate']")).getText();
            if (!birthDate.trim().equals("")) {
                person.setBirthDate(new Date(birthDate));
            }
            person.setAddress(personSnippet.findElement(By.xpath("div[@id='personAddress']")).getText().trim());
            persons.add(person);
        }
        return persons;
    }
}
