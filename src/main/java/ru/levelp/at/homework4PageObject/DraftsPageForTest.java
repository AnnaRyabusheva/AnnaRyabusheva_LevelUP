package ru.levelp.at.homework4PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftsPageForTest extends BaseAbstractPageObjectClass {

    public DraftsPageForTest(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class, \"ll-sp__normal\") and text()=\"Первое тестовое письмо для теста. "
        + "Лети. -- Ира Иванова Отправлено из Почты Mail.ru\"]")
    private static WebElement myFirstLetterForVerify;

    @FindBy(xpath = "//span[@title=\"irushik1981@mail.ru\"]")
    private static WebElement verifyMail;

    public static void verifyLetterInDrafts() {
        myFirstLetterForVerify.isDisplayed();
    }

    public static void enterInLetter() {
        myFirstLetterForVerify.click();
    }

    public String verifyMailString() {
        return verifyMail.getText();
    }
}
