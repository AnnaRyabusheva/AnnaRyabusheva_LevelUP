package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends BaseClassForExercise {

    @Test
    public void loginInMail() {

        driver.navigate().to("https://mail.ru/");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/div[1]/button"));
        loginButton.click();
        WebElement frame = driver.findElement((By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));
        driver.switchTo().frame(frame);

        WebElement userName = driver.findElement(
            By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/form/div[2]/div[2]/div[1]/div/div"));
        userName.click();
        WebElement userField = driver.findElement(By.xpath("//*[@class=\"base-0-2-58 first-0-2-64 focus-0-2-61\"]"));
        userField.sendKeys("angel18.87");
    }
}
