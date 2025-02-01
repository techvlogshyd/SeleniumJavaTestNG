package com.tests;

import org.testng.annotations.*;

public class TestNGAnnotationOrder {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite - Setup global environment for the entire suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - Clean up global environment for the entire suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Setup for a specific test within a suite");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test - Teardown for a specific test within a suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class - Setup for a test class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Teardown for a test class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Setup specific to each test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Teardown specific to each test method");
    }

    @Test
    public void testMethod1() {
        System.out.println("Test Method 1 - Actual test logic");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test Method 2 - Actual test logic");
    }

    @Test
    public void testMethod3() {
        System.out.println("Test Method 3 - Actual test logic");
    }
}
