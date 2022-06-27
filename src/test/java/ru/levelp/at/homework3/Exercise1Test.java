package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseClassForExercise {

    @Test
    public void loginInMail() {

        //        //        1.	Войти в почту

        //        2.	Assert, что вход выполнен успешно

        WebElement buttonClicK = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]"));
        buttonClicK.click();
        String txtUserName = driver.findElement(By.xpath("//*[@aria-label=\"Ира Иванова\"]")).getText();
        softly.assertThat(txtUserName).isEqualTo("Ира Иванова");

        //        //        3.	Создать новое письмо (заполнить адресата, тему письма и тело)
        //
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

        //        WebElement postField =driver.findElement(By.xpath("//div[@class=\"editor_container--3Rj-8\"]/*//div[@class=\"editable-container-xvph\"]/*//div"));
        //        postField.click();
        //        WebElement postField2 = driver.findElement(By.xpath("//*[@class=\"compose-app compose-app_fix compose-app_popup compose-app_window compose-app_fixed\"]/*//div[@class=\"editable-d0gu cke_editable cke_editable_inline cke_contents_true cke_show_borders cke_focus\"]"));
        //        postField2.sendKeys("АААААА найдись поле блин");//div[@class=\"editable-q092 cke_editable cke_editable_inline cke_contents_true cke_show_borders cke_focus\"]

        //        WebElement bodyOsn=driver.findElement(By.xpath("//div[@class=\"editor_container--3Rj-8\"]"));
        //        bodyOsn.click();
        //        WebElement body = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[5]/div/div/div[2]"));//div[@class="editable-d0gu cke_editable cke_editable_inline cke_contents_true cke_show_borders cke_focus"]
        //        body.click();
        //        WebElement body2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]/br"));
        //        body2.sendKeys("Первое мое письмо для автотеста");
        ////        body.sendKeys("");
        //
        //        4.	Сохранить его как черновик
        WebElement buttonSave = driver.findElement(By.xpath(
            "/html/body/div[1]/div/div[2]/div/div/div/div[3]/div[1]/div[2]/div/button"));//div//button[@data-test-id="save"]
        buttonSave.click();
        WebElement close = driver.findElement(By.xpath("//div//button[@title=\"Закрыть\"]"));
        close.click();
        //
        //        //        5.	Verify, что письмо сохранено в черновиках
        //
        WebElement korzina = driver.findElement(
            By.xpath("//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]"));
        korzina.click();
        //
        String verifyKorzina = driver.findElement(By.xpath(
                                         " //*[@id=\"app-canvas\"]/*//span[contains(@class, \"ll-sp__normal\") and text()=\"АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru\"]  "))
                                     .getText();//span[contains(@class, "ll-sp__normal") and text()="АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru"]
        softly.assertThat(verifyKorzina)
              .contains("АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru");
        //        verifyKorzina.isDisplayed();
        //
        //        //        6.	Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}
        ////        String titleLetter = driver.findElement(By.xpath("//span[contains(@class, 'll-sp__normal') and text()=\"Первое мое письмо для автотеста -- Ира Иванова Отправлено из Почты Mail.ru\"]"))
        //////                                       "//span[contains(@class, \"ll-sp__normal\") and text()=\"Первое письмо "
        //////                                           + "для автотеста -- Ира Иванова Отправлено из Почты Mail.ru\"]"))
        ////                                   .getText();
        ////        softly.assertThat(titleLetter)
        ////              .isEqualTo("Первое письмо для автотеста -- Ира Иванова Отправлено из Почты Mail.ru");
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
        //
        //        //        7.	Отправить письмо
        WebElement sendLetter = driver.findElement(
            By.xpath(
                "//span[contains(@class,\"ll-sp__normal\") and text()=\"АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru\"]"));
        sendLetter.click();
        WebElement sendButton = driver.findElement(By.xpath("//button[@data-test-id=\"send\"]"));
        sendButton.click();
        //
        //        //        8.	Verify, что письмо исчезло из черновиков
        //        driver.navigate().refresh();
        //        WebElement sendLetterwo = driver.findElement(
        //            By.xpath("//span[contains(@class,\"ll-sp__normal\") and text()=\"АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru\"]"));
        //        softly.assertThat(sendLetterwo.isDisplayed()).isFalse();
        //        WebElement vhod = driver.findElement(By.xpath("//*[@id=\"sideBarContent\"]/div/nav/a[1]/div/div[2]/div"));
        //        vhod.click();
        //
        //        //        9.	Verify, что письмо появилось в папке отправленные
        WebElement otpr = driver.findElement(By.xpath("//a[@href=\"/sent/\"]"));
        otpr.click();

        WebElement otpravlevoe = driver.findElement(By.xpath("//span[contains(@class, \"ll-sp__normal\") and "
            + "text()=\"АААААА найдись поле блин -- Ира Иванова Отправлено из Почты Mail.ru\"]"));
        otpravlevoe.isDisplayed();
        //
        //        //        10.	 Выйти из учётной записи

//        WebElement buttonClicK = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]"));
        buttonClicK.click();
        WebElement buttonExit = driver.findElement(By.xpath(
            "//div[@class=\"ph-sidebar svelte-3hgv3e\"]/*//div[@class=\"ph-item ph-item__hover-active svelte-6ia8p0\"]"));
        buttonExit.click();

        softly.assertAll();
    }
}

//        10.	 Выйти из учётной записи
