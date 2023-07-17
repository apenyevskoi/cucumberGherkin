package com.cucumber.gherkin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Setting up WebDrivers and browser options
 */
public class RunningDrivers {


    public static EventFiringWebDriver driver;

    public static ChromeOptions chromeOptions;

    public static WebDriverWait wait;

    /**
     * setting up Chrome WebDriver and Options. Register logger reporter
     */

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
//        driver.register(new CustomReports());
    }

    /**
     * Close WebDriver
     */
    public static void tearDown(){
        WebDriverManager.chromedriver().quit();
        driver.close();
        driver.quit();
    }
}
