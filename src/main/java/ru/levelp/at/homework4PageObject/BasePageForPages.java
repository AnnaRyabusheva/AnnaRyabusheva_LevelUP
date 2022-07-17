package ru.levelp.at.homework4PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageForPages {
    public BasePageForPages(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]")
    private static WebElement profileButton;

    @FindBy(xpath = "//*[@aria-label=\"Ира Иванова\"]")
    private WebElement stringForVerifyProfile;

    @FindBy(xpath = "//div[@class=\"ph-sidebar svelte-3hgv3e\"]/*//div[@class=\"ph-item ph-item__hover-active svelte-6ia8p0\"]")
    private static WebElement exitButton;

    @FindBy(xpath = "//button[@data-test-id=\"send\"]")
    private static WebElement sentLetter;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")
    private static WebElement saveLettersFolder;

    @FindBy(xpath = "//div//a[@class=\"compose-button compose-button_white compose-button_base"
        + " compose-button_with-dropdown js-shortcut\"]")
    private static WebElement createNewLetterButton;

    @FindBy(xpath = "//div[@data-type]//div/input[@type=\"text\"]")
    private static WebElement colum;

    @FindBy(xpath = "//div/input[@name=\"Subject\"]")
    private static WebElement tem;

    @FindBy(xpath = "//div[@class=\"container--3QXHv\"]/div[@class=\"inputContainer--nsqFu\" ]/input")//div[@class="container--3QXHv"]/div/input
    private static WebElement subject;

    @FindBy(xpath = "//div[contains(@class, 'editable-container')]/div/div") //div[@class="editable-container-jx2a"]
    private static WebElement postField;

    @FindBy(xpath = "//button[@data-test-id=\"save\"]")
    private static WebElement buttonForSaveInDraft;

    @FindBy(xpath = "//div//button[@title=\"Закрыть\"]")
    public static WebElement ButtonForCloseOnLetter;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")
    private static WebElement draftsButton;

    @FindBy(xpath = "//a[@href=\"/sent/\"]")
    private static WebElement folderOfSendLetters;

    @FindBy(xpath = "//div[@class=\"nav__folder-name nav__folder-name_shared\" ]/div[contains(@class, \"nav__folder-name__txt\") and text()=\"Отправленные\"]")
    private static WebElement folderSentLennerNew;

    @FindBy(xpath = "//div[@class=\"js-helper js-readmsg-msg\"]//div[@class]/div")
    private static WebElement verifyBodyInLetter;

       public static void entryMenu() {
        profileButton.click();
    }

    public String getUserName() {
        return stringForVerifyProfile.getText();
    }

    public static void createNewLetter() {
        createNewLetterButton.click();
    }

    public static void sendTem() {
        tem.sendKeys("\"Тестовое письмо\"");
    }
    public String verifySubject(){
        return subject.getText();
    }
//    public  static void verifyLetterSenders(){
//           tem.isDisplayed();
//    }
    public static void sendColum() {
        colum.sendKeys("irushik1981@mail.ru");
    }
    public static void sendTopic() {
        postField.sendKeys("Первое тестовое письмо для теста. Лети.");
    }
    public String verifyPostField(){
        return verifyBodyInLetter.getText();
    }

    public static void saveButtonForDraft() {
        buttonForSaveInDraft.click();
    }

    public static void closeButtonOnLetter() {
        ButtonForCloseOnLetter.click();
    }

    public static void clickToDraftsButton() {
        draftsButton.click();
    }

    public static void exitFromMail() {
        profileButton.click();
        exitButton.click();
    }

    public static void buttonForSentLetter() {
        sentLetter.click();
    }

    public static void buttonOfFolderOfSendLetters() {
//        folderOfSendLetters.click();
        folderSentLennerNew.click();
    }
}


