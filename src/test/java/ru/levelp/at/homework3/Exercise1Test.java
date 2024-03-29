package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseClassForExercise {

    @Test
    public void loginInMail() {

        //1.Войти в почту: выполнено в базовом классе
        //2.Assert, что вход выполнен успешно: выполненно в базовом классе
        //3.Создать новое письмо (заполнить адресата, тему письма и тело)
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(@class, \"compose-button__txt\") and text()=\"Написать письмо\"]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"input--3slxg\"]"))).click();

        WebElement colum = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"text\"]")));
        colum.sendKeys("irushik1981@mail.ru");

        WebElement tem = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@name=\"Subject\"]")));
        tem.click();
        tem.sendKeys("Тестовое письмо");

        WebElement postField = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class, 'editable-container')]/div/div")));

        postField.sendKeys("Поле тело письма заполнено. Первое задание.");

        //4.Сохранить его как черновик
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@data-test-id=\"save\"]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div//button[@title=\"Закрыть\"]"))).click();

        //5.Verify, что письмо сохранено в черновиках

        WebElement basket = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class, \"nav__folder-name__txt\") and text()=\"Черновики\"]")));

        basket.click();

        String verifyBasket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                                      " //*[@id=\"app-canvas\"]/*//span[contains(@class, \"ll-sp__normal\") "
                                          + "and text()=\"Поле тело письма заполнено. Первое задание. -- Ира"
                                          + " Иванова Отправлено из Почты Mail.ru\"]  ")))
                                  .getText();
        softly.assertThat(verifyBasket)
              .contains("Поле тело письма заполнено. Первое задание. -- Ира Иванова Отправлено из Почты Mail.ru");

        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}

        String addressLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                                       "//span[@title=\"irushik1981@mail.ru\"]")))
                                   .getText();
        softly.assertThat(addressLetter)
              .isEqualTo("irushik1981@mail.ru");

        String senderLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                                      "//span[contains(@class, \"ll-sj__normal\") "
                                          + "and text()=\"Тестовое письмо\"]")))
                                  .getText();
        softly.assertThat(senderLetter)
              .isEqualTo("Тестовое письмо");

        //7.Отправить письмо
        WebElement sendLetter = driver.findElement(
            By.xpath(
                "//span[contains(@class,\"ll-sp__normal\") and text()=\"Поле тело письма заполнено. Первое задание. -- "
                    + "Ира Иванова Отправлено из Почты Mail.ru\"]"));
        sendLetter.click();
        WebElement sendButton = driver.findElement(By.xpath("//button[@data-test-id=\"send\"]"));
        sendButton.click();

        driver.findElement(By.xpath("//span[@title=\"Закрыть\"]")).click();
        //8.Verify, что письмо исчезло из черновиков
        String verifyElementInDraft = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class="
            + "\"dataset-letters__empty\"]"))).getText();
        softly.assertThat(!verifyElementInDraft.isEmpty());

        //9.Verify, что письмо появилось в папке отправленные
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/sent/\"]"))).click();

        WebElement sentLetter = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(@class, \"ll-sp__normal\") and text()=\"Поле тело письма заполнено."
                + " Первое задание. -- Ира Иванова Отправлено из Почты Mail.ru\"]")));
        sentLetter.isDisplayed();

        //10. Выйти из учётной записи

        softly.assertAll();
    }
}


