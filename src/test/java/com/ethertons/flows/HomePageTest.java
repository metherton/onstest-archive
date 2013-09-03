package com.ethertons.flows;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.ethertons.pages.HomePage;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class HomePageTest extends SeleniumTest {

    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        homePage = new HomePage(driver).load();
    }

    @Test
    public void homePageShouldShowWelcomeMessage() {
        assertThat(homePage.getWelcomeMessage(), is("Welcome to the Etherton One Name Study") );
        assertThat(homePage.getWebSiteAuthorMessage() , is("Site is maintained by Martin Etherton"));
        assertThat(homePage.inTheNewsFeedHasElements(), is(true));
    }

    @Test
    public void uploadGedcomLinkShouldBeShownInLeftHandMenu() throws Exception {
        assertThat(homePage.showGedcoms(), is("Gedcoms"));
    }
}
