package com.tests;

import com.pages.GreenKartPage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreenKartTest extends BaseTest{

    @Test(priority = 1, enabled = true)
    public void verifyLoginPageTitleTest(){
        GreenKartPage green = page.getInstance(GreenKartPage.class).addItemsToCartAndCheckOut();
        Assert.assertTrue(green.getSuccessMsg().isDisplayed());
    }


    @Test(priority = 2, enabled = true)
    public void searchItemAndUpdateQuantity(){
        List<String> items=new ArrayList<>();
        items.add("Walnuts - 1/4 Kg");
        items.add("Tomato - 1 Kg");
        items.add("Beetroot - 1 Kg");
        //GreenKartPage green = page.getInstance(GreenKartPage.class).searchItemAndToCart(items, 10);
        GreenKartPage green = page.getInstance(GreenKartPage.class).searchItemAndToCart(List.of("Walnuts - 1/4 Kg", "Tomato - 1 Kg", "Beetroot - 1 Kg"), 10);
        //Assert.assertTrue(green.getSuccessMsg().isDisplayed());
    }

    @Test(priority = 2, enabled = true)
    public void searchItemAndAddDifferentQuantity(){
//        List<String> items=new ArrayList<>();
//        items.add("Walnuts - 1/4 Kg");
//        items.add("Tomato - 1 Kg");
//        items.add("Beetroot - 1 Kg");
        Map<String, Integer> items = new HashMap<>();
        items.put("Walnuts - 1/4 Kg", 5);
        items.put("Tomato - 1 Kg", 7);
        items.put("Beetroot - 1 Kg", 11);


        //GreenKartPage green = page.getInstance(GreenKartPage.class).searchItemAndToCart(items, 10);
        //GreenKartPage green = page.getInstance(GreenKartPage.class).searchItemAndToCart(List.of("Walnuts - 1/4 Kg", "Tomato - 1 Kg", "Beetroot - 1 Kg"), 10);
        GreenKartPage green = page.getInstance(GreenKartPage.class).searchItemAndToCart(items);
        //Assert.assertTrue(green.getSuccessMsg().isDisplayed());
    }
}
