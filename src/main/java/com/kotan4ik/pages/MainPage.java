package com.kotan4ik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By FAQ_BUTTON_XPATH = By.xpath("//div[@class='accordion__button']");
    private static final By FAQ_ANSWER_XPATH = By.xpath("//div[@class='accordion__panel']");
    private static final By TOP_ORDER_BUTTON_XPATH = By.xpath("//div[contains(@class, 'Header')]//button[@class='Button_Button__ra12g']");
    private static final By BOTTOM_ORDER_BUTTON_XPATH = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(MAIN_PAGE_URL);
    }

    public void acceptCookies() {
        driver.findElement(By.id("rcc-confirm-button")).click();
    }

    public int getNumberOfFaqButtons() {
        return driver.findElements(FAQ_BUTTON_XPATH).size();
    }

    public void clickFaqButton(int buttonNumber) {
        WebElement element = driver.findElements(FAQ_BUTTON_XPATH).get(buttonNumber - 1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean isDisplayedFaqAnswer(int buttonNumber) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElements(FAQ_ANSWER_XPATH).get(buttonNumber - 1);
        js.executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void clickOrderButton(String isTopButton) {
        By locator;
        if (Boolean.parseBoolean(isTopButton)) {
            locator = TOP_ORDER_BUTTON_XPATH;
        } else {
            locator = BOTTOM_ORDER_BUTTON_XPATH;
        }
        WebElement button = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", button);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
}
