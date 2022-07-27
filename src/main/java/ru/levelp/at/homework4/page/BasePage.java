package ru.levelp.at.homework4.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private static final String MAIL_URL = "https://mail.ru/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void fillInputField(final WebElement inputField, final String text) {
        wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys(text);
    }

    protected void clickToButton(final WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}
