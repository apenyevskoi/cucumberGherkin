package com.cucumber.gherkin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.cucumber.gherkin.RunningDrivers.driver;

/**
 * Mail Page of user's mail account. Describe elements of processes of creating, sending
 * and removing letter, Sent box, Trash box, letter choosing,
 */
public class MailPage {

    @FindBy(css = "a[class='Button2 Button2_type_link Button2_view_action Button2_size_m Layout-m__compose--pTDsx qa-LeftColumn-ComposeButton ComposeButton-m__root--fP-o9']")
    WebElement writeLetterBtn;

    @FindBy(css = "div.composeYabbles[data-class-bubble='yabble-compose js-yabble']")
    WebElement toField;

    @FindBy(css = "div[class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder']")
    WebElement letterBody;

    @FindBy(css = "button.Button2.Button2_view_action.Button2_size_l")
    WebElement sendBtn;

    @FindBy(css = "a[href='#sent']")
    WebElement sentBin;

    @FindBy(css = "a[href='#trash']")
    WebElement trashBin;

    @FindBy(css = ".mail-Layout-Container .ns-view-container-desc.mail-MessagesList.js-messages-list>div>div>div")
    WebElement letter;

    @FindBy(css = ".mail-Layout-Container .ns-view-container-desc.mail-MessagesList.js-messages-list>div>div>div label[data-nb='checkbox']")
    WebElement firstLetter;

    @FindBy(css = "div.mail-Toolbar-Content.js-toolbar-content.js-toolbar .ns-view-container-desc div")
    List<WebElement> listOfToolbarBtns;

    /**
     * Mail Page constructor
     */
    public MailPage(){
        PageFactory.initElements(driver, this);
    }

    /**
     * Click "Write" button to create letter
     */
    public void clickWriteLetterBtn(){
        new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOf(writeLetterBtn));
        writeLetterBtn.click();
    }

    /**
     * Insert "email" to field ToWhom
     * @param email
     */
    public void insertEmail(String email){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(toField));
        toField.sendKeys(email);
    }

    /**
     * Insert "email body" to field body
     * @param body
     */
    public void insertLetterBody(String body){
        letterBody.sendKeys(body);
    }

    /**
     * Click "Send" button
     */
    public void clickSendBtn(){
        sendBtn.click();
    }

    /**
     * Click on Sent box
     */
    public void clickOnSentBin(){
        new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOf(sentBin));
        sentBin.click();
    }

    /**
     * Click on Trash box
     */
    public void clickOnTrashBin(){
        new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOf(writeLetterBtn));
        trashBin.click();
    }

    /**
     * Extract letter's attribute from the first letter in the list of letters
     * @return String of attribute of picked letter
     */
    public String sentLetterContain(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(letter));
        return letter.getAttribute("aria-label");
    }

    /**
     * Pick the first letter using check mark
     * @return String of attribute of picked letter
     */
    public String pickFirstLetter(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(firstLetter));
        String attrib = firstLetter.getAttribute("aria-label");
        firstLetter.click();
        return attrib;
    }

    /**
     * Remove the first letter from the Incoming box
     */
    public void removeLetter(){
        listOfToolbarBtns.get(4).click();
    }
}