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
 * "Move_letter.feature" Cucumber Steps: open base page, open login page,
 * login as user, move the first letter from Sent to Trash bin and check
 * whether it has happend
 */

public class MoveLetterStepDefs {

    private BasePage basePage;

    private LoginPage loginPage;

    private MailPage mailPage;

    // expected value from the sent letter in the Sent box
    private String sentLetterAttrib;

    /**
     * initialize WebDriver and Pages
     */
    @Before("@move_letter")
    public void initPage2(){
        RunningDrivers.setUp();
        basePage = new BasePage();
        loginPage = new LoginPage();
        mailPage = new MailPage();
    }

    /**
     * Cucumber "Given()" from "Move_letter.feature". User login
     * @param arg0 username
     * @param arg1 password
     */
    @Given("^log in user's mail service with \"([^\"]*)\", and \"([^\"]*)\"$")
    public void loginToMail(String arg0, String arg1){
        basePage.loadPage();
        basePage.clickFirstLoginBtn();
        loginPage.inputEmail(arg0);
        loginPage.clickLoginBtn();
        loginPage.setInputPassw(arg1);
        loginPage.clickLoginBtn();
    }

    /**
     * Cucumber "When()" from "Move_letter.feature". Go to Sent box, choose the first letter and remove it
     */
    @When("^user move first sent letter to Trash$")
    public void moveLetterToTrash(){
        mailPage.clickOnSentBin();
        sentLetterAttrib = mailPage.pickFirstLetter();
        mailPage.removeLetter();
    }

    /**
     * Cucumber "Then()" from "Move_letter.feature". Go to Trash and check if letter was removed
     */
    @Then("^user open Trash Page and check letter have been moved$")
    public void letterIsRemoved(){
        mailPage.clickOnTrashBin();
        boolean actual = mailPage.sentLetterContain().contains("you should read");
        boolean expected = sentLetterAttrib.contains("you should read");
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Logout and remove WebDrivers
     */
    @And("^user logout$")
    public void logout(){
        RunningDrivers.tearDown();
    }

}
