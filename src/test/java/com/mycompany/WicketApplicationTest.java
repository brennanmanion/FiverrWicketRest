package com.mycompany;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.pages.HomePage;


@SpringBootTest
class WicketApplicationTest {
    private WicketTester wicketTester;
    @Autowired
    private WicketApplication wicketApplication;
    @BeforeEach
    public void setUp() {
        wicketTester = new WicketTester(wicketApplication);
    }
    @Test
    public void homepageRendersSuccessfully() {
        //start and render the test page
        wicketTester.startPage(HomePage.class);
        //assert rendered page class
        wicketTester.assertRenderedPage(HomePage.class);
    }
}