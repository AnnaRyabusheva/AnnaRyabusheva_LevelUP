package ru.levelp.at.homework4.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@id=\"mailbox\"]/div/button[@data-testid=\"enter-mail-primary\"]")
    protected WebElement loginButton;

    @FindBy(xpath = "//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")
    protected WebElement frame;

    @FindBy(xpath = "//input[@name='username']")
    protected WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    protected WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"ph-whiteline\"]//div[@aria-label=\"irushik1981@mail.ru\"]")
    protected WebElement rightSideBar;

    @FindBy(xpath = "//*[@aria-label=\"Ира Иванова\"]")
    protected WebElement textForVerifyTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm() {
        clickToButton(loginButton);
        driver.switchTo().frame(frame);
    }

    public void loginInEmail(String login) {

        loginField.sendKeys(login + Keys.ENTER);
    }

    public void putPassword(String password) {
        clickToButton(passwordField);
        passwordField.sendKeys(password + Keys.ENTER);
    }

    public String verifyTitle() {
        clickToButton(rightSideBar);
        return wait.until(ExpectedConditions.visibilityOf(textForVerifyTitle)).getText();
    }
}

