package ru.levelp.at.homework4PageObject;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageForTest extends AbstractPageObjectBaseClass {
        public HomePageForTest(WebDriver driver,
                               WebDriverWait wait) {
            super(driver, wait);
        }
    @FindBy(xpath = "//*[@id=\"mailbox\"]/div[1]/button")
    private WebElement buttonForLoginFrame;

    @FindBy(xpath = "//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")
    private WebElement loginFrame;



//    @FindBy(xpath = "")

}
