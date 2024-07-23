package com.kotan4ik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By FAQ_BUTTON_XPATH = By.xpath("//div[@class='accordion__button']");
    private static final By FAQ_ANSWER_XPATH = By.xpath("//div[@class='accordion__panel']");
    private static final By ORDER_BUTTON_XPATH = By.xpath("//div[contains(@class, 'Header')]//button[@class='Button_Button__ra12g']");



    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(MAIN_PAGE_URL);
    }

    public void clickFaqButton(int buttonNumber) {
        WebElement element = driver.findElements(FAQ_BUTTON_XPATH).get(buttonNumber - 1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public boolean isDisplayedFaqAnswer(int buttonNumber) {
        return driver.findElements(FAQ_ANSWER_XPATH).get(buttonNumber - 1).isDisplayed();
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON_XPATH).click();
    }
}
