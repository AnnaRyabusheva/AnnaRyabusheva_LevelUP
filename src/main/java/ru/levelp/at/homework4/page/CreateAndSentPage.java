package ru.levelp.at.homework4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAndSentPage extends BasePage {

    public CreateAndSentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type=\"text\"]")
    protected WebElement senderField;

    @FindBy(xpath = "//div[@class=\"container--3QXHv\"]//input[@name=\"Subject\"]")
    protected WebElement topicField;

    @FindBy(xpath = "//div[contains(@class, 'editable-container')]/div/div")
    protected WebElement bodyOfLetterField;

    @FindBy(xpath = "//button[@data-test-id=\"save\"]")
    protected WebElement buttonToSaveLetter;

    @FindBy(xpath = "//div[@class=\"dataset-letters__empty\"]")
    protected WebElement emptyFolderTrash;

    @FindBy(xpath = "//div[contains(@class, \"focus-zone\")]//button[@data-test-id]")
    protected WebElement sentButton;

    @FindBy(xpath = "//div//button[@title=\"Закрыть\"]")
    protected WebElement closeLetterWindow;

    @FindBy(xpath = "/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[1]")
    protected WebElement windowOfLetterClose;

    @FindBy(xpath = "//div[contains(@data-testid, \"whiteline-account-exit\")]")
    protected WebElement exitButton;

    @FindBy(xpath = "//*[@id=\"app-canvas\"]/*//span[contains(@class, \"ll-sp__normal\") and text()=\"Первое письмо"
        + " для Page Object -- Ира Иванова Отправлено из Почты Mail.ru\"]")
    protected WebElement verifyLetterIn;

    @FindBy(xpath = "//div[contains(@class, \"scrollview--SiHhk\")]//div[contains(@title,"
        + " \"irushik1981@mail.ru\")]/span")
    protected WebElement verifySender;

    @FindBy(xpath = "//div/input[@name=\"Subject\"]")
    protected WebElement topicVer;

    @FindBy(xpath = "//div[@class=\"js-helper js-readmsg-msg\"]//div[text()='Первое письмо для Page Object']")
    protected WebElement bodyVerify;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Отправленные\"]")
    protected WebElement senderFolder;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Тест\"]")
    protected WebElement folderTest;

    @FindBy(xpath = "//span[contains(@class, \"ph-project__user-name\")]")
    protected WebElement folderToVerifyPerson;

    @FindBy(xpath = "//span[contains(@class, \"ll-sj__normal\") and text()=\"Self: Тест\"]")
    protected WebElement elementForVerifyInSender;

    @FindBy(xpath = "//span[contains(@class, \"ll-sj__normal\") and text()=\"Тест\"]")
    protected WebElement elementVerifyInTestF;

    @FindBy(xpath = "//span[@title=\"irushik1981@mail.ru\"]")
    protected WebElement emailInFolderTest;

    @FindBy(xpath = "//h2[@class=\"thread-subject\"]")
    protected WebElement topicInFolderTest;

    @FindBy(xpath = "//div[@class=\"js-helper js-readmsg-msg\"]//div[text()=\"Второе письмо для Page Object\"]")
    protected WebElement bodyInFolderTest;

    @FindBy(xpath = "//span[text()=\"Во входящие\"]")
    protected WebElement elementInIncoming;

    @FindBy(xpath = "//span[ text()=\"Удалить\"]")
    protected WebElement buttonToDeleteLetter;

    @FindBy(xpath = "//div[text()=\"Третье письмо для Page Object\"]")
    protected WebElement bodyInIncoming;

    public void fillSender(String sender, String topic, String bodyOfLetter) {
        wait.until(ExpectedConditions.visibilityOf(senderField)).sendKeys(sender);
        wait.until(ExpectedConditions.visibilityOf(topicField)).sendKeys(topic);
        wait.until(ExpectedConditions.visibilityOf(bodyOfLetterField)).sendKeys(bodyOfLetter);
    }

    public void saveLetter() {
        clickToButton(buttonToSaveLetter);
    }

    public void exitLetter() {
        clickToButton(closeLetterWindow);
    }

    public boolean verifyLetterInDraft() {
        wait.until(ExpectedConditions.visibilityOf(verifyLetterIn)).isDisplayed();
        return true;
    }

    public void clickToLetterInDraft() {
        clickToButton(verifyLetterIn);
    }

    public void sentLetter() {
        clickToButton(sentButton);
        wait.until(ExpectedConditions.visibilityOf(sentButton)).click();
    }

    public String sender() {
        return wait.until(ExpectedConditions.visibilityOf(verifySender)).getText();
    }

    public String topicVerify() {

        return wait.until(ExpectedConditions.visibilityOf(topicVer)).getAttribute("value");
    }

    public String bodyToVerify() {

        return wait.until(ExpectedConditions.visibilityOf(bodyVerify)).getText();
    }

    public String letterNotVisible() {
        return wait.until(ExpectedConditions.visibilityOf(emptyFolderTrash)).getText();
    }

    public void closeWindowA() {
        clickToButton(windowOfLetterClose);
    }

    public void clickToSenderFolder() {
        clickToButton(senderFolder);
    }

    public void clickToFolderTest() {
        clickToButton(folderTest);
    }

    public void exit() {
        clickToButton(folderToVerifyPerson);
        clickToButton(exitButton);
    }

    public String verifyLetterInSenderFolder() {

        return wait.until(ExpectedConditions.visibilityOf(elementForVerifyInSender)).getText();
    }

    public String verifyLetterInTestFolder() {

        return wait.until(ExpectedConditions.visibilityOf(elementVerifyInTestF)).getText();
    }

    public String verifyEmailInTestFolder() {
        clickToButton(elementVerifyInTestF);
        return wait.until(ExpectedConditions.visibilityOf(emailInFolderTest)).getText();
    }

    public String verifyTopicInTestFolder() {
        return wait.until(ExpectedConditions.visibilityOf(topicInFolderTest)).getText();
    }

    public String verifyBodyInTestFolder() {
        return wait.until(ExpectedConditions.visibilityOf(bodyInFolderTest)).getText();
    }

    public void enterToIncoming() {
        clickToButton(incomingButton);
        clickToButton(letterToMySelf);
    }

    public void verifyLetterInIncoming() {
        wait.until(ExpectedConditions.textToBe((By.xpath("//span[text()=\"Во входящие\"]")), "Во входящие"));
    }

    public void clickToElementInIncoming() {
        clickToButton(elementInIncoming);
    }

    public void deleteLetter() {
        clickToButton(buttonToDeleteLetter);
    }

    public String verifyEmailInIncomingLetter() {

        return wait.until(ExpectedConditions.visibilityOf(emailInFolderTest)).getText();
    }

    public String verifyBodyInIncoming() {
        return wait.until(ExpectedConditions.visibilityOf(bodyInIncoming)).getText();
    }

    public String verifyLetterInBasket() {
        return wait.until(ExpectedConditions.visibilityOf(elementInIncoming)).getText();
    }
}
