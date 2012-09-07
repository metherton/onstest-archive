package com.ethertons.flows;

import static org.junit.Assert.assertTrue;

import com.ethertons.pages.GedcomListPage;
import org.junit.Test;

public class GedcomListTest extends SeleniumTest {

    @Test
    public void listOfGedcomsShouldBeShown() throws Exception {
        GedcomListPage gedcomListPage = new GedcomListPage(driver).load();
        assertTrue(gedcomListPage.hasGedcoms());
    }

}
