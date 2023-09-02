package com.pages;

import com.utils.Wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private Wrappers common;
    private By emailId = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("loginBtn");
    private By header = By.xpath("//*[@data-key='login.signupLink.text']");

    public LoginPage(WebDriver driver) {
        super(driver);
        common = new Wrappers(driver);
    }
    public WebElement getEmailId() {
//        return getElement(emailId);
        return common.findElement(emailId);
    }

    public WebElement getPassword() {
        return common.findElement(password);
    }

    public WebElement getLoginButton() {
        return common.findElement(loginButton);
    }

    public WebElement getHeader() {
        return getElement(header);
    }

    public String getLoginPageTitle(){
        return getPageTitle();
    }
    public String getLoginPageHeader(){
        return getPageHeader(header);
    }

    public HomePage doLogin(String username, String password){
        common.typeText(getEmailId(),username);
        common.typeText(getPassword(),password);
        common.click(getLoginButton());
        return getInstance(HomePage.class);
    }

    public void doLogin(){
        getEmailId().sendKeys("");
        getPassword().sendKeys("");
    }
    public void doLogin(String userCreds){
        if (userCreds.contains("username")) {
            getEmailId().sendKeys(userCreds.split(":")[1]);
        }
        else if (userCreds.contains("password")) {
            getEmailId().sendKeys(userCreds.split(":")[1]);
        }
        getLoginButton().click();
    }

}
