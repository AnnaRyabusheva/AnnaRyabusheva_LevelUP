package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends BaseClassForExercise {

    @Test
    public void loginInMail()  {

        //        1.	Войти в почту
        driver.navigate().to("https://mail.ru/");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/div[1]/button"));
        loginButton.click();
        WebElement frame = driver.findElement((By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));
        driver.switchTo().frame(frame);

        WebElement userName = driver.findElement(
            By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/form/div[2]/div[2]/div[1]/div/div"));
        userName.click();
        WebElement userField = driver.findElement(By.xpath("//input[@name='username']"));

        userField.sendKeys("irushik1981" + Keys.ENTER);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("FirstPass159753" + Keys.ENTER);

        //        2.	Assert, что вход выполнен успешно

        //        WebElement buttonClic=driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]"));
        //        buttonClic.isDisplayed();

        //        3.	Создать новое письмо (заполнить адресата, тему письма и тело)
//        WebElement left=driver.findElement(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]"));
//        WebElement composBut = driver.findElement(By.xpath(
//            "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]/div[1]/div/div/div/div[1]/div/div/a"));
//        composBut.click();
    }
}

//        4.	Сохранить его как черновик
//        5.	Verify, что письмо сохранено в черновиках
//        6.	Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
//        7.	Отправить письмо
//        8.	Verify, что письмо исчезло из черновиков
//        9.	Verify, что письмо появилось в папке отправленные
//        10.	 Выйти из учётной записи
