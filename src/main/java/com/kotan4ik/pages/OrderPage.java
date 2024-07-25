package com.kotan4ik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage {
    private static final By NAME_FIELD_XPATH = By.xpath("//div[@class='Input_InputContainer__3NykH']//input[@placeholder='* Имя']");
    private static final By LAST_NAME_FIELD_XPATH = By.xpath("//input[@placeholder='* Фамилия']");
    private static final By ADDRESS_FIELD_XPATH = By.xpath("//input[contains(@placeholder,'Адрес')]");
    private static final By PHONE_NUMBER_FIELD_XPATH = By.xpath("//input[contains(@placeholder,'Телефон')]");
    private static final By SUBWAY_STATION_FILED_CLASS = By.className("select-search__input");
    private static final By SUBWAY_STATION_OPTION_CSS = By.cssSelector(".select-search__row");
    private static final By BUTTON_NEXT_CLASS = By.className("Button_Middle__1CSJM");
    private static final By DATE_FIELD_CSS = By.cssSelector(".react-datepicker__input-container input");
    private static final By RENTAL_DURATION_CSS = By.cssSelector(".Dropdown-control");
    private static final By RENTAL_DURATION_DROPDOWN_CSS = By.cssSelector(".Dropdown-option");
    private static final By COLOR_SELECT_GREY_ID = By.id("grey");
    private static final By ORDER_BUTTON_XPATH = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");
    private static final By CONFIRM_BUTTON_XPATH = By.xpath("//button[contains(@class,'Button_Middle__1CSJM') and text()='Да']");
    private static final By CONFIRMATION_HEADER_CLASS = By.className("Order_ModalHeader__3FDaJ");

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(NAME_FIELD_XPATH).sendKeys(name);
    }

    public void inputLastName(String lastname) {
        driver.findElement(LAST_NAME_FIELD_XPATH).sendKeys(lastname);
    }

    public void inputAddress(String address) {
        driver.findElement(ADDRESS_FIELD_XPATH).sendKeys(address);
    }

    public void inputPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER_FIELD_XPATH).sendKeys(phoneNumber);
    }

    public void chooseSubwayStation(int itemNumber) {
        driver.findElement(SUBWAY_STATION_FILED_CLASS).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SUBWAY_STATION_OPTION_CSS));
        options.get(itemNumber-1).click();
    }

    public void clickButtonNext(){
        driver.findElement(BUTTON_NEXT_CLASS).click();
    }

    public void setRentDate(String date) {
        driver.findElement(DATE_FIELD_CSS).sendKeys(date);
        driver.findElement(By.cssSelector("body")).click();
    }

    public void chooseDaysForRent(int numberOfDays) {
        if (numberOfDays < 1)
            numberOfDays = 1;
        if (numberOfDays > 7)
            numberOfDays =7;
        driver.findElement(RENTAL_DURATION_CSS).click();
        List<WebElement> elements = driver.findElements(RENTAL_DURATION_DROPDOWN_CSS);
        elements.get(numberOfDays-1).click();
    }

    public void chooseGreyColor() {
        driver.findElement(COLOR_SELECT_GREY_ID).click();
    }

    public void orderScooter() {
        driver.findElement(ORDER_BUTTON_XPATH).click();
    }

    public void confirmOrder() {
        driver.findElement(CONFIRM_BUTTON_XPATH).click();
    }

    public boolean checkOrderConfirmed() {
        return driver.findElement(CONFIRMATION_HEADER_CLASS).getText().contains("Заказ оформлен");
    }
}
