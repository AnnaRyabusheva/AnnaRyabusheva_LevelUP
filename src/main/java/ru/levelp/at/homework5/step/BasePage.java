package ru.levelp.at.homework5.step;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final String MAIL_URL = "https://mail.ru/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//span[contains(@class, \"compose-button__txt\") and text()=\"Написать письмо\"]")
    protected WebElement newLetterButton;

    @FindBy(xpath = "//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")
    protected WebElement draftButton;

    @FindBy(xpath = "//div[contains(@data-testid, \"whiteline-account-exit\")]")
    protected WebElement exitButton;

    @FindBy(xpath = "//span[contains(@class, \"ph-project__user-name\")]")
    protected WebElement folderToVerifyPerson;

    @FindBy(xpath = "//a[@href=\"/inbox/\"]")
    protected WebElement incomingButton;

    @FindBy(xpath = "//div[@class=\"mt-h-c__item mt-h-c__item_title\"]")
    protected WebElement letterToMySelf;

    @FindBy(xpath = "//div[@class=\"nav-folders\"]//div[text()=\"Корзина\"]")
    protected WebElement basket;

    public void clickToBasket() {
        clickToButton(basket);
    }

    public void enterToIncoming() {
        clickToButton(incomingButton);
        clickToButton(letterToMySelf);
    }

    public void exit() {
        clickToButton(folderToVerifyPerson);
        clickToButton(exitButton);
    }

    public void draftButtonClick() {
        clickToButton(draftButton);
        wait.until(ExpectedConditions.elementToBeClickable(draftButton));
    }

    public void tabToNewLetterButton() {
        clickToButton(newLetterButton);
    }

    protected void clickToButton(final WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}
