package com.ethertons.flows;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.ethertons.constants.Urls;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PersonTest extends SeleniumTest {

    public static final String ADD_NEW_PERSON_PATH = "/persons/new";

    @BeforeClass
    public static void setUpGlobalData() {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
        login();
        addPerson("father", "gender2");
        addPerson("mother", "gender1");
    }

    @Before
    public void setUp() throws Exception {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
    }

    @Test
    public void addPersonFormShouldBeShown() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        assertNotNull(firstName);
    }

    @Test
    public void personDetailsShouldBeShownAfterAddingPerson() throws Exception {
        addNewPerson();
        assertThat(driver.findElement(By.id("birthDate")).getText(), is("Date of Birth:\nMar 4, 1963"));
    }

    @Test
    public void personDetailsShouldBeChangedAfterEditingPerson() throws Exception {
        gotoEditBirthForm();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("MartinChange");
        WebElement birthDate = driver.findElement(By.id("birthDate"));
        birthDate.clear();
        birthDate.sendKeys("03/04/1963");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        assertThat(driver.findElement(By.id("fullName")).getText(), is("Details for MartinMartinChange Etherton"));
    }

    @Test
    public void editBirthFormShouldHaveTitleEditBirth() {
        gotoEditBirthForm();
        assertThat(driver.findElement(By.className("innercontentmiddleheader")).getText(), is("Edit Birth") );
    }

    private void gotoEditBirthForm() {
        addNewPerson();
        String currentUrl = driver.getCurrentUrl();
        int personId = extractPersonIdFrom(currentUrl);
        driver.get(Urls.HOST + "/persons/" + personId + "/edit");
    }


    private int extractPersonIdFrom(String currentUrl) {
        String[] urlParts = currentUrl.split("/");
        return Integer.parseInt(urlParts[4]);
    }

    private void addNewPerson() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Martin");
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='Etherton']"));
        surname.click();
        WebElement father = driver.findElement(By.xpath("//select[@id='father']/option[normalize-space(text())='Samuel James Etherton']"));
        father.click();
        WebElement mother = driver.findElement(By.xpath("//select[@id='mother']/option[normalize-space(text())='Nora Wilkinson']"));
        mother.click();
        WebElement gender = driver.findElement(By.id("gender2"));
        gender.click();
        WebElement birthDate = driver.findElement(By.id("birthDate"));
        birthDate.sendKeys("04/03/1963");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    private static void addPerson(String firstNameValue, String genderSelection) {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(firstNameValue);
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='Etherton']"));
        surname.click();
        WebElement gender = driver.findElement(By.id(genderSelection));
        gender.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();        
    }

    private static void addMother() {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("mother");
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='etherton']"));
        surname.click();
        WebElement gender = driver.findElement(By.id("gender1"));
        gender.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    private static void addFather() {
        driver.get(Urls.HOST + ADD_NEW_PERSON_PATH);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("father");
        WebElement surname = driver.findElement(By.xpath("//select[@id='surname']/option[normalize-space(text())='etherton']"));
        surname.click();
        WebElement gender = driver.findElement(By.id("gender2"));
        gender.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

}
