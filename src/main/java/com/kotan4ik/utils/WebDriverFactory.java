package com.kotan4ik.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private static final String BROWSER_NAME_ENV = "BROWSER";

    public static WebDriver getDriver() {
        String browserName = System.getenv(BROWSER_NAME_ENV);
        if (browserName == null || browserName.isEmpty())
            browserName = "chrome";
        browserName = browserName.toLowerCase();
        switch (browserName) {
            case "firefox":
                return getFirefoxDriver();
            case "chrome":
            default:
                return getChromeDriver();
        }
    }

    private static ChromeDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
        firefoxOptions.addArguments("--headless");
        return new FirefoxDriver(firefoxOptions);
    }
}
