package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseClassForExercise {

    @Test
    public void letterPapkaTest() {
        //1.Войти в почту: выполнено в базовом классе
        //2.Assert, что вход выполнен успешно: выполнено в базовом классе
        //3.Создать новое письмо (заполнить адресата (самого себя), тему письма (должно содержать слово Тест)
        // и тело)

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
        tem.sendKeys("Тест");
        WebElement postField = driver.findElement(By.xpath("//div[contains(@class, 'editable-container')]/div/div"));
        postField.sendKeys("Поле тело письма заполнено");

        //4.Отправить письмо

        WebElement buttonSent = driver.findElement(
            By.xpath("//div[contains(@class, 'footer')]/div/div/div[@data-test-id=\"underlay-wrapper\"]"));
        buttonSent.click();

        //5.Verify, что письмо появилось в папке отправленные

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/sent/\"]"))).click();

        String checkOfBodyLetter = driver.findElement(By.xpath(
                                             "//span[contains(@class, \"ll-sp__normal\") and text()=\"Поле тело"
                                                 + " письма заполнено "
                                                 + "-- Ира Иванова Отправлено из Почты Mail.ru\"]"))
                                         .getText();
        softly.assertThat(checkOfBodyLetter).contains("Поле тело письма заполнено -- "
            + "Ира Иванова Отправлено из Почты Mail.ru");

        //6.Verify, что письмо появилось в папке «Тест»

        Actions action = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("//*[@id=\"sideBarContent\"]//div[contains(@class, "
            + "\"nav__folder-name__txt\") and text()=\"Тест\"]"));
        action.doubleClick(link).perform();

        //7.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        String addressLetter = driver.findElement(By.xpath(
                                         "//span[@title=\"Ира Иванова <irushik1981@mail.ru>\"]"))
                                     .getText();
        softly.assertThat(addressLetter)
              .isEqualTo("Ира Иванова");

        String senderLetter = driver.findElement(By.xpath(
                                        "//span[contains(@class, \"ll-sj__normal\") "
                                            + "and text()=\"Тест\"]"))
                                    .getText();
        softly.assertThat(senderLetter)
              .isEqualTo("Тест");

        //8.Выйти из учётной записи

        softly.assertAll();
    }
}
