package com.cucumber.gherkin.pages;

import static com.cucumber.gherkin.RunningDrivers.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.gherkin.utils.Configuration;

/**
 * Base Page to have a right reference to 
 */
public class BasePage{

    @FindBy(css = "a#header-login-button")
    WebElement firstLoginBtn;

    /**
     * Base Page constructor
     */
    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    /**
     * Get configuration from Configuration class
     * @return
     */
    protected Configuration getConfig(){
        return Configuration.getInstance();
    }

    /**
     * Get "url" from properties file using configuration class
     */
    public void loadPage(){
        driver.get(getConfig().getBase());
    }

    /**
     * Click on "Войти" button on the page "https://mail.yandex.ru/"
     */
    public void clickFirstLoginBtn(){
        firstLoginBtn.click();
    }
}