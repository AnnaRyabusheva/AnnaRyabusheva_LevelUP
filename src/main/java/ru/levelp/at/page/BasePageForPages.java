package ru.levelp.at.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageForPages {

    protected WebDriverWait wait;
    protected WebDriver driver;

    public BasePageForPages() {

    }

    public BasePageForPages(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]")
    private  WebElement profileButton;

    @FindBy(xpath = "//*[@aria-label=\"Ира Иванова\"]")
    private WebElement stringForVerifyProfile;

    @FindBy(xpath = "//div[@class=\"ph-sidebar svelte-3hgv3e\"]/*//div[@class="
        + "\"ph-item ph-item__hover-active svelte-6ia8p0\"]")
    private  WebElement exitButton;

    @FindBy(xpath = "//button[@data-test-id=\"send\"]")
    private  WebElement sentLetter;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")
    private  WebElement saveLettersFolder;

    @FindBy(xpath = "//div//a[@class=\"compose-button compose-button_white compose-button_base"
        + " compose-button_with-dropdown js-shortcut\"]")
    private  WebElement createNewLetterButton;

    @FindBy(xpath = "//div[@data-type]//div/input[@type=\"text\"]")
    private  WebElement colum;

    @FindBy(xpath = "//div/input[@name=\"Subject\"]")
    private  WebElement tem;

    @FindBy(xpath = "//div[@class=\"container--3QXHv\"]/div/input[@value]")
    private WebElement subject;

    @FindBy(xpath = "//div[contains(@class, 'editable-container')]/div/div")
    private  WebElement postField;

    @FindBy(xpath = "//button[@data-test-id=\"save\"]")
    private  WebElement buttonForSaveInDraft;

    @FindBy(xpath = "//div//button[@title=\"Закрыть\"]")
    public  WebElement ButtonForCloseOnLetter;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")
    private  WebElement draftsButton;

    @FindBy(xpath = "//a[@href=\"/sent/\"]")
    private  WebElement folderOfSendLetters;

    @FindBy(xpath = "//div[@class=\"nav__folder-name nav__folder-name_shared\" ]/div[contains(@class,"
        + " \"nav__folder-name__txt\") and text()=\"Отправленные\"]")
    private  WebElement folderSentLetterNew;

    @FindBy(xpath = "//div[@class=\"js-helper js-readmsg-msg\"]//div[@class]/div")
    private  WebElement verifyBodyInLetter;

    @FindBy(xpath = "//a[@href=\"/inbox/\"]//div[@class=\"nav__folder-name__txt\"]")
    private  WebElement incomingButton;

    @FindBy(xpath = "//div[@class=\"mt-h-c__content\"]/div/span")
    private  WebElement letterToMySelf;



    public void entryMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();

    }

    public String getUserName() {
        return stringForVerifyProfile.getText();
    }

    public  void createNewLetter() {
        createNewLetterButton.click();
    }

    public  void sendTem() {
        tem.sendKeys("\"Тестовое письмо\"");
    }

    public  boolean verifySubject() {
        subject.isDisplayed();
        return true;
    }

    //    public  static void verifyLetterSenders(){
    //           tem.isDisplayed();
    //    }
    public  void sendColum() {
        colum.sendKeys("irushik1981@mail.ru");
    }

    public  void sendTopic() {
        postField.sendKeys("Первое тестовое письмо для теста. Лети.");
    }

    public String verifyPostField() {
        return verifyBodyInLetter.getText();
    }

    public  void saveButtonForDraft() {
        buttonForSaveInDraft.click();
    }

    public  void closeButtonOnLetter() {
        ButtonForCloseOnLetter.click();
    }

    public  void clickToDraftsButton() {
        draftsButton.click();
    }

    public  void exitFromMail() {
        profileButton.click();
        exitButton.click();
    }

    public  void buttonForSentLetter() {
        sentLetter.click();
    }

    public  void buttonOfFolderOfSendLetters() {
        //        folderOfSendLetters.click();
        folderSentLetterNew.click();
    }

    public  void enterToIncomingLetterFolder() {
        incomingButton.click();
        letterToMySelf.click();
    }

    //    public static boolean verifySubject(){
    //        subject.isDisplayed();
    //        return true;
    //    }
}


