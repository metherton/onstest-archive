package com.ethertons.flows;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.ethertons.domain.Person;
import com.ethertons.pages.TreeViewPage;
import com.google.common.collect.Lists;
import org.junit.Test;

public class TreeViewTest extends SeleniumTest {

    @Test
    public void familyTreeShouldBeShown() {
        Person father = new Person();
        father.setId(5);
        father.setFullname("Sydney Arthur (Jr) Etherton");
        Person mother = new Person();
        mother.setId(9);
        mother.setFullname("Nora Wilkinson");
        Person firstSon = new Person();
        firstSon.setId(8);
        firstSon.setFullname("Mark Howard Etherton");
        Person secondSon = new Person();
        secondSon.setId(6);
        secondSon.setFullname("Martin Etherton");
        Person secondSonWife = new Person();
        secondSonWife.setId(10);
        secondSonWife.setFullname("Erna De Roo");
        Person firstDaughter = new Person();
        firstDaughter.setId(13);
        firstDaughter.setFullname("Rhonda Etherton");
        Person firstSonForSecondSon = new Person();
        firstSonForSecondSon.setId(7);
        firstSonForSecondSon.setFullname("Dylan Etherton");
        TreeViewPage treeViewPage = new TreeViewPage(driver, secondSon).load();
        List<Person> firstGeneration = newArrayList();
        firstGeneration.add(father);
        firstGeneration.add(mother);
        List<Person> secondGeneration = Lists.newArrayList();
        secondGeneration.add(firstSon);
        secondGeneration.add(secondSon);
        secondGeneration.add(firstDaughter);
        List<Person> thirdGeneration = newArrayList();
        thirdGeneration.add(firstSonForSecondSon);
        List<Person> firstGenerationReturned = treeViewPage.firstGeneration();
        assertThat(firstGenerationReturned, hasItems(father, mother));
        List<Person> secondGenerationReturned = treeViewPage.secondGeneration();
        assertThat(secondGenerationReturned, contains(firstSon, secondSon, firstDaughter, secondSonWife));
        List<Person> thirdGenerationReturned = treeViewPage.thirdGeneration();
        assertThat(thirdGenerationReturned, contains(firstSonForSecondSon));
    }

    @Test
    public void unknownParentsShouldBeShownIfTheyAreNotKnown() throws Exception {
        Person firstSon = new Person();
        firstSon.setId(5);
        Person unknownFather = new Person();
        unknownFather.setFullname("Sydney Arthur (Sr) Etherton");
        unknownFather.setId(4);
        Person unknownMother = new Person();
        unknownMother.setFullname("Mary Bell");
        unknownMother.setId(14);
        TreeViewPage treeViewPage = new TreeViewPage(driver, firstSon).load();
        List<Person> firstGeneration = newArrayList();
        firstGeneration.add(unknownFather);
        firstGeneration.add(unknownMother);
        List<Person> firstGenerationReturned = treeViewPage.firstGeneration();
        assertThat(firstGenerationReturned, contains(unknownFather, unknownMother));
    }

    @Test
    public void personShouldShowInSecondGenerationIfParentsNotKnown() throws Exception {
        Person firstSon = new Person();
        firstSon.setId(5);
        firstSon.setFullname("Sydney Arthur (Jr) Etherton");
        TreeViewPage treeViewPage = new TreeViewPage(driver, firstSon).load();
        List<Person> secondGeneration = newArrayList();
        secondGeneration.add(firstSon);
        List<Person> secondGenerationReturned = treeViewPage.secondGeneration();
        assertThat(secondGenerationReturned, hasItem(firstSon));
    }

    @Test
    public void childrenShouldBeShownWhenFemaleIsActivePerson() throws Exception {
        Person secondSonWife = new Person();
        secondSonWife.setId(10);
        secondSonWife.setFullname("Erna De Roo");
        TreeViewPage treeViewPage = new TreeViewPage(driver, secondSonWife).load();
        Person firstSonForSecondSon = new Person();
        firstSonForSecondSon.setId(7);
        firstSonForSecondSon.setFullname("Dylan Etherton");
        List<Person> thirdGeneration = newArrayList();
        thirdGeneration.add(firstSonForSecondSon);
        List<Person> thirdGenerationReturned = treeViewPage.thirdGeneration();
        assertThat(thirdGenerationReturned, contains(firstSonForSecondSon));
    }
}
