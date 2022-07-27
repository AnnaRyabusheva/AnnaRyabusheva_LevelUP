package ru.levelp.at.homework4.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAndSentPage extends BasePage {

    public CreateAndSentPage(WebDriver driver) {
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

    @FindBy(xpath = "//button[@data-test-id=\"send\"]")
    protected WebElement elementForSent;

    @FindBy(xpath = "//button[@data-test-id=\"send\"]")
    protected WebElement buttonToSent;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")
    protected WebElement draftButton;

    @FindBy(xpath = "//div[contains(@class, \"focus-zone\")]//button[@data-test-id]")
    protected WebElement sentButton;

    @FindBy(xpath = "//div//button[@title=\"Закрыть\"]")
    protected WebElement closeLetterWindow;

    @FindBy(xpath = "/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[1]")
    protected WebElement windowOfLetterClose;

    @FindBy(xpath = "//div[contains(@class, \"ph-sidebar\")]//div[contains(@data-testid, \"whiteline-account-exit\")]")
    protected WebElement exitButton;

    @FindBy(xpath = "//*[@id=\"app-canvas\"]/*//span[contains(@class, \"ll-sp__normal\") and text()=\"Первое письмо"
        + " для Page Object -- Ира Иванова Отправлено из Почты Mail.ru\"]")
    protected WebElement verifyLetterInDraft;

    @FindBy(xpath = "//div[contains(@class, \"scrollview--SiHhk\")]//div[contains(@title, \"irushik1981@mail.ru\")]/span")
    protected WebElement verifySender;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div[1]/div[2]/div")//div[contains(@class, \"scrollview--SiHhk\")]//div[@class=\"subject__container--HWnat\"]"
//        + "//input[contains(@value, \"Тестовое письмо\")]
    protected WebElement topicVer;

    @FindBy(xpath = "//*[@id=\"style_16589126651251381899_BODY\"]/div/div[1]")//div[contains(@class, \"scrollview--SiHhk\")]//div[@class=\"editor_container--3Rj-8\"]"
//        + "//div[@class=\"cl_944064\"]/div
    protected WebElement bodyVerify;

    public void tabToNewLetterButton() {
        clickToButton(newLetterButton);
    }

    public void fillSender(String sender, String topic, String bodyOfLetter) {
        wait.until(ExpectedConditions.visibilityOf(senderField)).sendKeys(sender);
        wait.until(ExpectedConditions.visibilityOf(topicField)).sendKeys(topic);
        wait.until(ExpectedConditions.visibilityOf(bodyOfLetterField)).sendKeys(bodyOfLetter);
    }

    public void saveLetter() {
        clickToButton(buttonToSaveLetter);
    }
    public  void exitLetter(){
        clickToButton(closeLetterWindow);
    }

    public void draftButtonClick() {
        clickToButton(draftButton);
        wait.until(ExpectedConditions.elementToBeClickable(draftButton));
    }

    public boolean verifyLetterInDraft() {
        wait.until(ExpectedConditions.visibilityOf(verifyLetterInDraft)).isDisplayed();
        return true;
    }

    public void clickToLetterInDraft() {
        clickToButton(verifyLetterInDraft);
    }

    public void sentLetter() {
        clickToButton(sentButton);
    }

    public String sender() {
        return wait.until(ExpectedConditions.visibilityOf(verifySender)).getText();
    }

    public String topicVerify() {
        return wait.until(ExpectedConditions.visibilityOf(topicVer)).getText();
    }

    public String bodyToVarify() {
        return wait.until(ExpectedConditions.visibilityOf(bodyVerify)).getText();
    }
}