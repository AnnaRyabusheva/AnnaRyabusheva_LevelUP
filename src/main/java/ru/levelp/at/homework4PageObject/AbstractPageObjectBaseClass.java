package ru.levelp.at.homework4PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageObjectBaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPageObjectBaseClass(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
