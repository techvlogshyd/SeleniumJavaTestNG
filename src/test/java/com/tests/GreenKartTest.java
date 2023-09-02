package com.tests;

import com.pages.GreenKartPage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GreenKartTest extends BaseTest{

    @Test(priority = 1, enabled = true)
    public void verifyLoginPageTitleTest(){
        GreenKartPage green = page.getInstance(GreenKartPage.class).addItemsToCartAndCheckOut();
        Assert.assertTrue(green.getSuccessMsg().isDisplayed());
    }

}
