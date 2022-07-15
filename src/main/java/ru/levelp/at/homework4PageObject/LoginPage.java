package ru.levelp.at.homework4PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseAbstractPageObjectClass {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"mailbox\"]/div[1]/button")
    private WebElement buttonForLoginFrame;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    public void clickLoginBtn() {
        buttonForLoginFrame.click();
    }

    public void inputLogin(String login) {

        //        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));
        loginField.sendKeys(login+Keys.ENTER);
    }

    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd + Keys.ENTER);
    }
}
