package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Wrappers {
    private WebDriver driver;
    private JavascriptExecutor executor;
    private Actions actions;
    private WebDriverWait wait;


    public Wrappers(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void click(By by) {
        waitForElementToBeClickable(by);
        findElement(by).click();
    }

    public void typeText(By by, String text) {
        waitForElementToBePresent(by);
        WebElement element = findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public void typeText(WebElement element, String text) {
        waitForElementToBePresent((By) element);
        element.clear();
        element.sendKeys(text);
    }

    public void checkCheckbox(By by) {
        WebElement checkbox = findElement(by);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheckCheckbox(By by) {
        WebElement checkbox = findElement(by);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectRadioButton(By by) {
        WebElement radioButton = findElement(by);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public void selectDropdownByVisibleText(By by, String visibleText) {
        WebElement dropdown = findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    public void selectDropdownByValue(By by, String value) {
        WebElement dropdown = findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void selectDropdownByIndex(By by, int index) {
        WebElement dropdown = findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    // You can add more control type-specific functions as needed.

    public void waitFor(int milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void executeScript(String script) {
        executor.executeScript(script);
    }

    public void clickElement(WebElement element) {
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void highlightElement(WebElement element) {
        String originalStyle = element.getAttribute("style");
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
        try {
            sleep(1000); // Add a delay to see the highlighted element
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
    }

    public void scrollToTop() {
        executor.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void click(WebElement element) {
        actions.click(element).perform();
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    public void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    public void release(WebElement element) {
        actions.release(element).perform();
    }

    public void keyDown(CharSequence key) {
        actions.keyDown(key).perform();
    }

    public void keyUp(CharSequence key) {
        actions.keyUp(key).perform();
    }

    public void moveByOffset(int xOffset, int yOffset) {
        actions.moveByOffset(xOffset, yOffset).perform();
    }

    public void moveToElementAndClick(WebElement element) {
        moveToElement(element);
        click(element);
    }

    public void moveAndClickByOffset(WebElement element, int xOffset, int yOffset) {
        moveToElement(element);
        moveByOffset(xOffset, yOffset);
        actionsClick();
    }

    public void perform() {
        actions.perform();
    }

    public void clearActions() {
        actions.release().build().perform();
    }

    private void actionsClick() {
        actions.click().perform();
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForTextToBePresentInElement(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitForUrlToContain(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void waitForUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForTitleToContain(String partialTitle) {
        wait.until(ExpectedConditions.titleContains(partialTitle));
    }

    public void waitForTitleToBe(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void setImplicitWait(int timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
        /*
        *  Usage :: WebDriverWait wait = new WebDriverWait(driver, 0); // Temporarily set to 0 seconds to check for element presence immediately
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        setImplicitWait(10); // Reset implicit wait to its original value (e.g., 10 seconds)
        return element;
        * */
    }

    public WebElement fluentWaitForElement(By locator, int timeoutInSeconds, int pollingIntervalInSeconds) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds)).pollingEvery(Duration.ofSeconds(pollingIntervalInSeconds)).ignoring(org.openqa.selenium.NoSuchElementException.class);

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement fluentWaitForElement(WebElement element, int timeoutInSeconds, int pollingIntervalInSeconds) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds)).pollingEvery(Duration.ofSeconds(pollingIntervalInSeconds)).ignoring(org.openqa.selenium.NoSuchElementException.class);

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}

