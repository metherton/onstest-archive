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
        father.setId(169);
        father.setFullname("Sydney Arthur Etherton");
        Person mother = new Person();
        mother.setId(171);
        mother.setFullname("Nora Wilkinson");
        Person firstSon = new Person();
        firstSon.setId(170);
        firstSon.setFullname("Mark Etherton");
        Person secondSon = new Person();
        secondSon.setId(172);
        secondSon.setFullname("Martin Etherton");
        Person secondSonWife = new Person();
        secondSonWife.setId(176);
        secondSonWife.setFullname("Erna De Roo");
        Person firstDaughter = new Person();
        firstDaughter.setId(173);
        firstDaughter.setFullname("Rhonda Etherton");
        Person firstSonForSecondSon = new Person();
        firstSonForSecondSon.setId(175);
        firstSonForSecondSon.setFullname("Dylan Etherton");
        TreeViewPage treeViewPage = new TreeViewPage(driver).loadTreeFor(secondSon);
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
        firstSon.setId(169);
        Person unknownFather = new Person();
        unknownFather.setFullname("Sydney Arthur (sr) Etherton");
        Person unknownMother = new Person();
        unknownMother.setFullname("Mary Bell");
        TreeViewPage treeViewPage = new TreeViewPage(driver).loadTreeFor(firstSon);
        List<Person> firstGeneration = newArrayList();
        firstGeneration.add(unknownFather);
        firstGeneration.add(unknownMother);
        List<Person> firstGenerationReturned = treeViewPage.firstGeneration();
        assertThat(firstGenerationReturned, contains(unknownFather, unknownMother));
    }

    @Test
    public void personShouldShowInSecondGenerationIfParentsNotKnown() throws Exception {
        Person firstSon = new Person();
        firstSon.setId(169);
        firstSon.setFullname("Sydney Arthur Etherton");
        TreeViewPage treeViewPage = new TreeViewPage(driver).loadTreeFor(firstSon);
        List<Person> secondGeneration = newArrayList();
        secondGeneration.add(firstSon);
        List<Person> secondGenerationReturned = treeViewPage.secondGeneration();
        assertThat(secondGenerationReturned, hasItem(firstSon));
    }

    @Test
    public void childrenShouldBeShownWhenFemaleIsActivePerson() throws Exception {
        Person secondSonWife = new Person();
        secondSonWife.setId(174);
        secondSonWife.setFullname("Erna De Roo");
        TreeViewPage treeViewPage = new TreeViewPage(driver).loadTreeFor(secondSonWife);
        Person firstSonForSecondSon = new Person();
        firstSonForSecondSon.setId(175);
        firstSonForSecondSon.setFullname("Dylan Etherton");
        List<Person> thirdGeneration = newArrayList();
        thirdGeneration.add(firstSonForSecondSon);
        List<Person> thirdGenerationReturned = treeViewPage.thirdGeneration();
        assertThat(thirdGenerationReturned, contains(firstSonForSecondSon));
    }
}
