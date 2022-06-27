package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseClassForExercise {

    @Test
    public void loginInMail() {

        //1.	Войти в почту

        //2.	Assert, что вход выполнен успешно

        WebElement buttonClicK = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]"));
        buttonClicK.click();
        String txtUserName = driver.findElement(By.xpath("//*[@aria-label=\"Ира Иванова\"]")).getText();
        softly.assertThat(txtUserName).isEqualTo("Ира Иванова");

        //3.	Создать новое письмо (заполнить адресата, тему письма и тело)

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

        WebElement postField = driver.findElement(By.xpath("//div[contains(@class, 'editable-container')]/div/div"));
        postField.sendKeys("АААААА найдись поле блин");

        //        4.	Сохранить его как черновик
        WebElement buttonSave = driver.findElement(By.xpath(
            "/html/body/div[1]/div/div[2]/div/div/div/div[3]/div[1]/div[2]/div/button"));
        buttonSave.click();
        WebElement close = driver.findElement(By.xpath("//div//button[@title=\"Закрыть\"]"));
        close.click();

        //        //        5.	Verify, что письмо сохранено в черновиках

        WebElement korzina = driver.findElement(
            By.xpath("//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]"));
        korzina.click();
        //
        String verifyKorzina = driver.findElement(By.xpath(
                                         " //*[@id=\"app-canvas\"]/*//span[contains(@class, \"ll-sp__normal\") "
                                             + "and text()=\"АААААА найдись поле блин -- Ира"
                                             + " Иванова Отправлено из Почты Mail.ru\"]  "))
                                     .getText();
        softly.assertThat(verifyKorzina)
              .contains("АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru");

        //6.	Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}

        String adressLetter = driver.findElement(By.xpath(
                                        "//span[@title=\"irushik1981@mail.ru\"]"))
                                    .getText();
        softly.assertThat(adressLetter)
              .isEqualTo("irushik1981@mail.ru");
        //
        String otpravitelLetter = driver.findElement(By.xpath(
                                            "//span[contains(@class, \"ll-sj__normal\") "
                                                + "and text()=\"Тестовое письмо\"]"))
                                        .getText();
        softly.assertThat(otpravitelLetter)
              .isEqualTo("Тестовое письмо");

        //        //        7.	Отправить письмо
        WebElement sendLetter = driver.findElement(
            By.xpath(
                "//span[contains(@class,\"ll-sp__normal\") and text()=\"АААААА найдись поле блин -- "
                    + "Ира Иванова Отправлено из Почты Mail.ru\"]"));
        sendLetter.click();
        WebElement sendButton = driver.findElement(By.xpath("//button[@data-test-id=\"send\"]"));
        sendButton.click();

        //8.	Verify, что письмо исчезло из черновиков

        //9.	Verify, что письмо появилось в папке отправленные
        WebElement otpr = driver.findElement(By.xpath("//*[@id=\"sideBarContent\"]/div/nav/a[6]"));//a[@href="/sent/"]
        otpr.click();

        WebElement otpravlevoe = driver.findElement(By.xpath("//span[contains(@class, \"ll-sp__normal\") and "
            + "text()=\"АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru\"]"));
        otpravlevoe.isDisplayed();

        //10.	 Выйти из учётной записи

        buttonClicK.click();
        WebElement buttonExit = driver.findElement(By.xpath(
            "//div[@class=\"ph-sidebar svelte-3hgv3e\"]/*//div[@class=\"ph-item "
                + "ph-item__hover-active svelte-6ia8p0\"]"));
        buttonExit.click();

        softly.assertAll();
    }
}


