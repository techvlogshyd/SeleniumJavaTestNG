package com.tests;

import com.pages.BasePage;
import com.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;
    public Page page;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setupTest(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("ff")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("No browser is defined in XML...");
        }
//        driver.get("https://app.hubspot.com/");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.manage().window().maximize();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        page = new BasePage(driver);
        System.out.println("Before test is called");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("After test is called");
    }

}
