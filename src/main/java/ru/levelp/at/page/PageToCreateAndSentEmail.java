package ru.levelp.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageToCreateAndSentEmail extends BasePageForPages {

    public PageToCreateAndSentEmail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(@class, \"compose-button__txt\") and text()=\"Написать письмо\"]")
    protected WebElement newLetterButton;

    @FindBy(xpath = "//input[@type=\"text\"]")
    protected WebElement senderField;

    @FindBy(xpath = "//div[@class=\"container--3QXHv\"]//input[@name=\"Subject\"]")
    protected WebElement topicField;

    @FindBy(xpath = "//div[contains(@class, 'editable-container')]/div/div")
    protected WebElement bodyOfLetterField;

    @FindBy(xpath = "//button[@data-test-id=\"save\"]")
    protected WebElement buttonToSaveLetter;

    @FindBy(xpath = "")
    protected WebElement elementForSent;

    @FindBy(xpath = "//button[@data-test-id=\"send\"]")
    protected WebElement buttonToSent;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")
    protected WebElement draftButton;

    @FindBy(xpath = "//a[@href=\"/sent/\"]")
    protected WebElement sentButton;

    @FindBy(xpath = "//div//button[@title=\"Закрыть\"]")
    protected WebElement closeLetterWindow;

    @FindBy(xpath = "/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[1]")
    protected WebElement windowOfLetterClose;

    @FindBy(xpath = "//div[contains(@class, \"ph-sidebar\")]//div[contains(@data-testid, \"whiteline-account-exit\")]")
    protected WebElement exitButton;

    public void tabToNewLetterButton() {
        clickToButton(newLetterButton);
    }

    public void fillSender(String sender, String topic, String bodyOfLetter) {
        wait.until(ExpectedConditions.visibilityOf(senderField)).sendKeys(sender);
        wait.until(ExpectedConditions.visibilityOf(topicField)).sendKeys(topic);
        wait.until(ExpectedConditions.visibilityOf(bodyOfLetterField)).sendKeys(bodyOfLetter);
    }
    public void saveLetter(){
        clickToButton(buttonToSaveLetter);
    }
    public void draftButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(draftButton));
    }
}