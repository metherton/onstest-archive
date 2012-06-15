package com.ethertons.flows;

import static org.junit.Assert.assertTrue;

import com.ethertons.pages.TreeListPage;
import org.junit.Test;

public class TreeListTest extends SeleniumTest {

    @Test
    public void listOfTreesShouldBeShown() throws Exception {
        TreeListPage treeListPage = new TreeListPage(driver).load();
        assertTrue(treeListPage.hasTrees());
    }
}
