package ru.levelp.at.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseClassForExercise {

    @Test
    public void letterPapkaTest() {
        //1.	Войти в почту: выполнено в базовом классе

        //2.	Assert, что вход выполнен успешно
        WebElement buttonClicK = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]"));
        buttonClicK.click();
        String txtUserName = driver.findElement(By.xpath("//*[@aria-label=\"Ира Иванова\"]")).getText();
        softly.assertThat(txtUserName).isEqualTo("Ира Иванова");

        //3.	Создать новое письмо (заполнить адресата (самого себя), тему письма (должно содержать слово Тест)
        // и тело)

        WebElement composBut = driver.findElement(By.xpath(
            "//span[contains(@class,\"compose-button__txt\") and text()=\"Написать письмо\"]"));
        composBut.click();

        WebElement to = driver.findElement((By.xpath("//div[@class=\"input--3slxg\"]")));
        to.click();
        WebElement colum = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        colum.sendKeys("irushik1981@mail.ru");
        WebElement tem = driver.findElement(By.xpath(
            "//div[@class=\"container--3QXHv\"]//input[@class=\"container--H9L5q size_s--3_M-_\"]"));
        tem.click();
        tem.sendKeys("Тестовое письмо");
        softly.assertAll();
    }

    //4.	Отправить письмо
    //5.	Verify, что письмо появилось в папке отправленные
    //6.	Verify, что письмо появилось в папке «Тест»
    //7.	Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
    //8.	Выйти из учётной записи
}
