package com.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGSparkReportExample {

    private ExtentReports extent;
    private ExtentTest extentTest;

    @BeforeSuite
    public void setUp() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/SparkReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

    @Test
    public void testMethod1() {
        extentTest = extent.createTest("testMethod1");
        // Your test logic
    }

    @Test
    public void testMethod2() {
        extentTest = extent.createTest("testMethod2");
        // Your test logic
    }

    @Test
    public void testMethod3() {
        extentTest = extent.createTest("testMethod3");
        // Your test logic
    }
}

