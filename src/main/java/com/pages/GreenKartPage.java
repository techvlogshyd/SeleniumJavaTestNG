package com.pages;

import com.utils.Wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

public class GreenKartPage extends BasePage{
    private Wrappers common;
    private String itemAddToCart = "//*[contains(text(),'%s')]/following-sibling::div/button";

    private By iconCart = By.className("cart-icon");
    private By btnProceed = By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]");
    private By txtPromo = By.className("promoCode");
    private By btnPromo = By.className("promoBtn");
    private By btnPlaceOrder = By.xpath("//*[contains(text(),'Place Order')]");
    private By ddlCountry = By.xpath("//*[contains(text(),'Choose Country')]/following-sibling::div[1]/select");
    private By chkAgree = By.className("chkAgree");
    private By btnProceedCountry = By.xpath("//*[contains(text(),'Proceed')]");

    private By labelSuccessMsg = By.xpath("//*[contains(text(),'Thank you, your order has been placed successfully')]");

    public GreenKartPage(WebDriver driver) {
        super(driver);
        common = new Wrappers(driver);
    }
    public WebElement getSuccessMsg() {
       return common.findElement(labelSuccessMsg);
    }
    public GreenKartPage addItemsToCartAndCheckOut(){
        List<String> items = new ArrayList<>();
        items.add("Brocolli - 1 Kg");
        items.add("Carrot - 1 Kg");
        items.add("Capsicum");
        for (String item:items) {
            common.click(driver.findElement(By.xpath(String.format(itemAddToCart, item))));
        }
        common.click(iconCart);
        common.click(btnProceed);
        common.typeText(txtPromo,"rahulshettyacademy");
        common.click(btnPromo);
        common.click(btnPlaceOrder);
        common.selectDropdownByValue(ddlCountry,"India");
        common.click(chkAgree);
        common.click(btnProceedCountry);
//        Assert.assertTrue(common.findElement(labelSuccessMsg));
        return new GreenKartPage(driver);
    }

}
