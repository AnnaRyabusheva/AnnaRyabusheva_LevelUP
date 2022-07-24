package ru.levelp.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsForVerify extends BasePageForPages{
    public ElementsForVerify(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    protected WebElement elementForVerifyInDraft;

    @FindBy(xpath = "")
    protected WebElement elementInSenderFolder;

    @FindBy(xpath = "")
    protected WebElement topicVerify;

    @FindBy(xpath = "//span[@title=\"irushik1981@mail.ru\"]")
    protected WebElement senderVerify;

    @FindBy(xpath = "")
    protected WebElement verifyBodyOfLetter;

//    @FindBy(xpath = "")
//    protected WebElement ;

}
