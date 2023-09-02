package com.tests;

import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(priority = 1, enabled = true)
    public void verifyLoginPageTitleTest(){
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "HubSpot Login");
    }
    @Test(priority = 2, enabled = true)
    public void verifyLoginPageHeaderTest(){
        String header;
        header = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(header);
        Assert.assertEquals(header, "Don't have an account?");
    }

    @Test(priority = 3, enabled = true)
    public void doLoginTest(){
        HomePage homePage;
        homePage = page.getInstance(LoginPage.class).doLogin("calmenani@gmail.com","Test@1234567");
//        String headerHome = homePage.getHomePageHeader();
//        System.out.println(headerHome);
//        Assert.assertEquals(headerHome,"Getting started with HubSpot");
    }
}
