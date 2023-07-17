package com.cucumber.gherkin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.cucumber.gherkin.RunningDrivers.driver;

/**
 * Login Page of user's mail account. Describe elements of processes of login,
 * input, buttons elements
 */
public class LoginPage extends BasePage{

    @FindBy(css = ".AuthLoginInputToggle-type button")
    WebElement emailBtn;

    @FindBy(css = "[placeholder*='Логин или email']")
    WebElement inputEmail;

    @FindBy(css = "button[type='submit']")
    WebElement loginBth;

    @FindBy(css = "input[type='password']")
    WebElement inputPassw;

    /**
     * Login Page constructor
     */
    public void LoginPage(){
        PageFactory.initElements(driver, this);
    }

    /**
     * Select way what login to use: email or phone number. Selecting email and button to do it
     */
    public void clickEmailBtn(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(emailBtn));
        emailBtn.click();
    }

    /**
     * Insert email to input field
     * @param email
     */
    public void inputEmail(String email){
        inputEmail.sendKeys(email);
    }

    /**
     * General button to insert login and password
     */
    public void clickLoginBtn() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(loginBth));
        loginBth.click();
    }

    /**
     * Insert passwort to input field
     * @param password
     */
    public void setInputPassw(String password){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(inputPassw));
        inputPassw.sendKeys(password);
    }
}
