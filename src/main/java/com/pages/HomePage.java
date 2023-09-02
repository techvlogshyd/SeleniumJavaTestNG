package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By header = By.xpath("//*[@data-key='setup-guide-components.consolidatedUserGuide.progressIndicator.title.service']");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public String getHomePageTitle(){
        return getPageTitle();
    }
    public String getHomePageHeader(){
        return getPageHeader(header);
    }
}
