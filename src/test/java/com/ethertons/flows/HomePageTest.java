package com.ethertons.flows;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.ethertons.pages.HomePage;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class HomePageTest extends SeleniumTest {

    @Test
    public void homePageShouldShowWelcomeMessage() {
        HomePage homePage = new HomePage(driver).load();
        assertThat(homePage.getWelcomeMessage(), is("Welcome to the Etherton One Name Study") );
        assertThat(homePage.getWebSiteAuthorMessage() , is("Site is maintained by Martin Etherton"));
    }

}
