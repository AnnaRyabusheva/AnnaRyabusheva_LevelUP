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

        WebElement composBut = driver.findElement(By.xpath(
            "//span[contains(@class,\"compose-button__txt\") and text()=\"Написать письмо\"]"));
        composBut.click();

        WebElement to = driver.findElement((By.xpath("//div[@class=\"input--3slxg\"]")));
        to.click();
        WebElement colum = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        colum.sendKeys("irushik1981@mail.ru");
        WebElement tem = driver.findElement(By.xpath(
            "//div[@class=\"container--3QXHv\"]//input[@name=\"Subject\"]"));
        tem.click();
        tem.sendKeys("3е задание по Selenium");
        WebElement postField = driver.findElement(By.xpath("//div[contains(@class, 'editable-container')]/div/div"));
        postField.sendKeys("Поле тело письма заполнено");

        //4.Отправить письмо

        WebElement buttonSent = driver.findElement(
            By.xpath("//div[contains(@class, 'footer')]/div/div/div[@data-test-id=\"underlay-wrapper\"]"));
        buttonSent.click();

        driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[1]")).click();

        //5.Verify, что письмо появилось в папке Входящие
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/inbox/\"]"))).click();
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"mt-h-c__item mt-h-c__item_title\"]")))
            .click();

        driver.findElement(By.xpath("//span[contains(@class, \"ll-sj__normal\") "
            + "and text()=\"3е задание по Selenium\"]")).click();
        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)

        //        String checkOfBodyLetter =
        //            driver.findElement(By.xpath("//*[@id=\"style_16583176301231982780_BODY\"]/div/div[1]"))
        //                  .getText();
        //        softly.assertThat(checkOfBodyLetter)
        //              .contains("Поле тело письма заполнено");

        String addressLetter = driver.findElement(By.xpath(
                                         "//div[@class=\"letter__author\"]/span[@title=\"irushik1981@mail.ru\"]"))
                                     .getText();
        softly.assertThat(addressLetter)
              .isEqualTo("Ира Иванова");

        String topicOflLetter = driver.findElement(By.xpath(
                                          "//div[@class=\"thread__subject-line\"]/h2[contains(@class,"
                                              + " \"thread-subject\" ) and text()=\"3е задание по Selenium\"]"))
                                      .getText();
        System.out.println(topicOflLetter);
        softly.assertThat(topicOflLetter)
              .contains("3е задание по Selenium");

        //7.Удалить письмо

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class=\"layout__main-frame\"]//span[@data-title-shortcut]/span"))).click();

        //8.Verify что письмо появилось в папке Корзина
        driver.findElement(By.xpath("//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Корзина\"]"))
              .click();
        String deleteLetter =
            driver.findElement(By.xpath(
                      "//div[@class=\"llc__item llc__item_title\"]//span[contains(@class, "
                          + "\"ll-sj__normal\" ) and text()=\"3е задание по Selenium\"]"))
                  .getText();
        softly.assertThat(deleteLetter).isEqualTo("3е задание по Selenium");

        //9.Выйти из учётной записи: выполнено в базовом классе

        softly.assertAll();
    }
}

