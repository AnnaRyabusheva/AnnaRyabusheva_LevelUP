package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            "//div[@class=\"container--3QXHv\"]//input[@name=\"Subject\"]"));
        topicOfLetter.click();
        topicOfLetter.sendKeys("Второе письмо");
        driver.findElement(By.xpath("//div[contains(@class, 'editable-container')]/div/div"))
              .sendKeys("Заполнение тела письма. 3е задание по селениуму");

        //4.Отправить письмо

        driver.findElement(
            By.xpath("//div[contains(@class, 'footer')]/div/div/div[@data-test-id=\"underlay-wrapper\"]")).click();

        //5.Verify, что письмо появилось в папке Входящие
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/inbox/\"]"))).click();
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"mt-h-c__item mt-h-c__item_title\"]"))).click();

//        softly.assertThat(driver.findElement(By.xpath("//span[contains(@class, \"ll-sj__normal\") "
//            + "and text()=\"Второе письмо\"]")).isDisplayed());



        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        driver.findElement(By.xpath("//span[contains(@class, \"ll-sj__normal\") "
            + "and text()=\"Второе письмо\"]")).click();

        String checkOfBodyLetter = driver.findElement(By.xpath("//span[contains(@class, "
            + "\"ll-sj__normal\") and text()=\"Второе письмо\"]")).getText();
        softly.assertThat(checkOfBodyLetter)
              .contains("Второе письмо");
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

        //driver.findElement(By.xpath("//div[contains(@class, \"llc__item \")]/span[@title=\"Ира Иванова
        // <irushik1981@mail.ru>\"]"))//span[@title="Ира Иванова <irushik1981@mail.ru>"]
        //.click();
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

