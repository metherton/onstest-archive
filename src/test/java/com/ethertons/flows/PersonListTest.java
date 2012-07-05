package com.ethertons.flows;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import com.ethertons.domain.Person;
import com.ethertons.pages.PersonListPage;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matchers;
import org.junit.Test;

public class PersonListTest extends SeleniumTest {

    @Test
    public void listOfPersonsShouldBeShown() throws Exception {
        PersonListPage personListPage = new PersonListPage(driver).load();
        assertThat(personListPage.getPersons().size(), is(greaterThan(0)));
        
        assertThat(personListPage.getPersons().get(0), allOf(hasFullName("Father(London) Etherton"),
                                                             hasId(11)));
        
    }

    private FeatureMatcher<Person, String> hasAddress(String address) {
        return new FeatureMatcher<Person, String>(Matchers.is(address), "Persion with address", "address") {
            @Override
            protected String featureValueOf(Person actual) {
                return actual.getAddress();
            }
        };
    }

    private FeatureMatcher<Person, Integer> hasId(int id) {
        return new FeatureMatcher<Person, Integer>(Matchers.is(id), "Person with id", "id") {
            @Override
            protected Integer featureValueOf(Person actual) {
                return actual.getId();
            }
        };
    }

    private FeatureMatcher<Person, String> hasFullName(String fullName) {
        return new FeatureMatcher<Person, String>(Matchers.is(fullName), "Person with fullname", "fullname") {
            @Override
            protected String featureValueOf(Person actual) {
                return actual.getFullname();
            }
        };
    }

}

/*

      public static Matcher<ListingResult> withPrice(String price) {
        return new FeatureMatcher<ListingResult, String>(is(price), "LrResult with price", "price") {
            @Override
            protected String featureValueOf(ListingResult actual) {
                return actual.getPrice().replaceAll(EURO_SIGN, "").replaceAll(" ", "");
            }
        };
    }
    
*/