package ru.levelp.at.homework3;

import java.awt.DisplayMode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseClassForExercise {

    @Test
    public void loginInMail() {

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
        driver.switchTo().defaultContent();

        //        2.	Assert, что вход выполнен успешно

        WebElement buttonClicK = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]"));
        buttonClicK.click();
        String txtUserName = driver.findElement(By.xpath("//*[@aria-label=\"Ира Иванова\"]")).getText();
        softly.assertThat(txtUserName).isEqualTo("Ира Иванова");

        //        3.	Создать новое письмо (заполнить адресата, тему письма и тело)

        WebElement composBut = driver.findElement(By.xpath(
            "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]/div[1]/div/div/div/div[1]/div/div/a"));
        composBut.click();
        WebElement to = driver.findElement((By.xpath("//div[@class=\"input--3slxg\"]")));
        to.click();
        WebElement colum = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        colum.sendKeys("irushik1981@mail.ru");
        WebElement tem = driver.findElement(By.xpath(
            "//div[@class=\"container--3QXHv\"]//input[@class=\"container--H9L5q size_s--3_M-_\"]"));
        tem.click();
        tem.sendKeys("Тестовое письмо");
        WebElement body = driver.findElement(By.xpath("//div[@role=\"textbox\"]"));
        body.click();
        body.sendKeys("Первое мое письмо для автотеста");

        //        4.	Сохранить его как черновик
        WebElement buttonSave = driver.findElement(By.xpath("//div//button[@data-test-id=\"save\"]"));
        buttonSave.click();
        WebElement close = driver.findElement(By.xpath("//div//button[@title=\"Закрыть\"]"));
        close.click();

        //        5.	Verify, что письмо сохранено в черновиках

        WebElement korzina = driver.findElement(
            By.xpath("//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]"));
        korzina.click();

        WebElement verifyKorzina = driver.findElement(By.xpath(
            "//span[contains(@class, \"ll-sp__normal\") and text()=\"Первое письмо для автотеста-- "
                + "Ира Иванова Отправлено из Почты Mail.ru\"]"));
        verifyKorzina.isDisplayed();

        //        6.	Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}
        String titleLetter = driver.findElement(By.xpath(
                                       "//span[contains(@class, \"ll-sp__normal\") and text()=\"Первое письмо "
                                           + "для автотеста -- Ира Иванова Отправлено из Почты Mail.ru\"]"))
                                   .getText();
        softly.assertThat(titleLetter)
              .isEqualTo("Первое письмо для автотеста -- Ира Иванова Отправлено из Почты Mail.ru");
        String adressLetter = driver.findElement(By.xpath(
                                        "//span[@title=\"irushik1981@mail.ru\"]"))
                                    .getText();
        softly.assertThat(adressLetter)
              .isEqualTo("irushik1981@mail.ru");

        String otpravitelLetter = driver.findElement(By.xpath(
                                            "//span[contains(@class, \"ll-sj__normal\") "
                                                + "and text()=\"Тестовое письмо\"]"))
                                        .getText();
        softly.assertThat(otpravitelLetter)
              .isEqualTo("Тестовое письмо");

        //        7.	Отправить письмо
        WebElement sendLetter = driver.findElement(
            By.xpath("//span[contains(@class,\"ll-sp__normal\") and text()=\"Первое письмо для автотеста -- "
                + "Ира Иванова Отправлено из Почты Mail.ru\"]"));
        sendLetter.click();
        WebElement sendButton= driver.findElement(By.xpath("//button[@data-test-id=\"send\"]"));
        sendButton.click();

        //        8.	Verify, что письмо исчезло из черновиков
//        driver.navigate().refresh();
//        WebElement sendLetterwo = driver.findElement(
//            By.xpath("//span[contains(@class,\"ll-sp__normal\") and text()=\"Первое письмо для автотеста -- "
//                + "Ира Иванова Отправлено из Почты Mail.ru\"]"));
//        softly.assertThat(sendLetterwo.isDisplayed()).isFalse();
        WebElement vhod = driver.findElement(By.xpath("//*[@id=\"sideBarContent\"]/div/nav/a[1]/div/div[2]/div"));
        vhod.click();

        //        9.	Verify, что письмо появилось в папке отправленные
        WebElement otpr = driver.findElement(By.xpath("//a[@href=\"/sent/\"]"));
        otpr.click();

        WebElement otpravlevoe=driver.findElement(By.xpath("//span[contains(@class, \"ll-sp__normal\") and "
            + "text()=\"Первое письмо для автотеста -- Ира Иванова Отправлено из Почты Mail.ru\"]"));
        otpravlevoe.isDisplayed();

        softly.assertAll();
    }
}



//        10.	 Выйти из учётной записи
