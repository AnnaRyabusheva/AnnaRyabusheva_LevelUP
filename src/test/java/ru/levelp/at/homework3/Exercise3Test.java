package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise3Test extends BaseClassForExercise {

    @Test
    public void deleteLetterFromFolderTest() {
        //1.Войти в почту: выполнено в базовом классе
        //2.Assert, что вход выполнен успешно: выполнено в базовом классе

        //3.Создать новое письмо (заполнить адресата (самого себя), тему письма и тело)

        driver.findElement(By.xpath(
            "//span[contains(@class,\"compose-button__txt\") and text()=\"Написать письмо\"]")).click();

        driver.findElement((By.xpath("//div[@class=\"input--3slxg\"]"))).click();

        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("irushik1981@mail.ru");
        WebElement topicOfLetter = driver.findElement(By.xpath(
            "//div[@class=\"container--3QXHv\"]//input[@class=\"container--H9L5q size_s--3_M-_\"]"));
        topicOfLetter.click();
        topicOfLetter.sendKeys("Второе письмо");
        driver.findElement(By.xpath("//div[contains(@class, 'editable-container')]/div/div"))
              .sendKeys("Заполенние тела письма. 3е задание по селениуму");

        //4.Отправить письмо

        driver.findElement(
            By.xpath("//div[contains(@class, 'footer')]/div/div/div[@data-test-id=\"underlay-wrapper\"]")).click();

//        driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);

        //5.Verify, что письмо появилось в папке Входящие

        WebElement buttonToSelfLetter =
            driver.findElement(By.xpath("//div[@class=\"mt-h-c__item mt-h-c__item_title\"]"));
        buttonToSelfLetter.click();

        String checkOfBodyLetter = driver.findElement(By.xpath(
                                             "//span[contains(@class, \"ll-sp__normal\") and text()=\"Заполенние тела "
                                                 + "письма. 3е задание по селениуму -- Ира Иванова "
                                                 + "Отправлено из Почты Mail.ru\"]"))
                                         .getText();
        softly.assertThat(checkOfBodyLetter)
              .contains("Заполенние тела письма. 3е задание по селениуму -- Ира Иванова Отправлено из Почты Mail.ru");

        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)

        String addressLetter = driver.findElement(By.xpath(
                                         "//span[@title=\"Ира Иванова <irushik1981@mail.ru>\"]"))
                                     .getText();
        softly.assertThat(addressLetter)
              .isEqualTo("Ира Иванова");

        String senderOflLetter = driver.findElement(By.xpath(
                                           "//span[contains(@class, \"ll-sj__normal\") "
                                               + "and text()=\"Второе письмо\"]"))
                                       .getText();
        softly.assertThat(senderOflLetter)
              .isEqualTo("Второе письмо");

        //7.Удалить письмо

        driver.findElement(By.xpath("//span[@title=\"Ира Иванова <irushik1981@mail.ru>\"]"))
              .click();
        driver.findElement(By.xpath("//span[contains(@class, \"button2__txt\") and text()=\"Удалить\"]")).click();

        //8.Verify что письмо появилось в папке Корзина
        driver.findElement(By.xpath("//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Корзина\"]"))
              .click();
        String deleteLetter =
            driver.findElement(By.xpath("//span[contains(@class, \"ll-sj__normal\") and text()=\"Второе письмо\"]"))
                  .getText();
        softly.assertThat(deleteLetter).isEqualTo("Второе письмо");

        //9.Выйти из учётной записи: выполнено в базовом классе

        softly.assertAll();
    }
}

