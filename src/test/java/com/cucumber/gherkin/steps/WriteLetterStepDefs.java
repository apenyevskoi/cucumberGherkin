package com.cucumber.gherkin.steps;

import com.cucumber.gherkin.RunningDrivers;
import com.cucumber.gherkin.pages.BasePage;
import com.cucumber.gherkin.pages.LoginPage;
import com.cucumber.gherkin.pages.MailPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

/**
 * "Write_letter.feature" Cucumber Steps: open base page, open login page,
 * login as user, click create letter and mail it to, then check
 * whether it has been sent in Sent box
 */
public class WriteLetterStepDefs {

    BasePage basePage;

    LoginPage loginPage;

    MailPage mailPage;

    /**
     * initialize WebDriver and Pages
     */
    @Before("@write_letter")
    public void initPage(){
        RunningDrivers.setUp();
        basePage = new BasePage();
        loginPage = new LoginPage();
        mailPage = new MailPage();
    }

    /**
     * Cucumber "Given()" from "Write_letter.feature". User login
     * @param arg0 username
     * @param arg1 password
     */
    @Given("^user login to url, with \"([^\"]*)\", and \"([^\"]*)\"$")
    public void loginPage(String arg0, String arg1){
        basePage.loadPage();
        basePage.clickFirstLoginBtn();

        loginPage.clickEmailBtn();
        loginPage.inputEmail(arg0);
        loginPage.clickLoginBtn();
        loginPage.setInputPassw(arg1);
        loginPage.clickLoginBtn();
    }

    /**
     * Cucumber "When()" from "Write_letter.feature". Click on create letter,
     * insert to whome email, insert email body and send
     */
    @When("^user send letter to \"([^\"]*)\"$")
    public void sendLetter(String arg0){
        mailPage.clickWriteLetterBtn();
        mailPage.insertEmail(arg0);
        mailPage.insertLetterBody("you should read this letter!");
        mailPage.clickSendBtn();
    }

    /**
     * Cucumber "Then()" from "Write_letter.feature". Go to Sent box and check whether letter was sent
     */
    @Then("^letter should have been sent$")
    public void letterIsSent(){
        mailPage.clickOnSentBin();
        Boolean actual = mailPage.sentLetterContain().contains("you should read this letter");
        Assertions.assertTrue(actual);
    }

    /**
     * Logout and remove WebDrivers
     */
    @And("^user logout$")
    public void logout(){
        RunningDrivers.tearDown();
    }
}
