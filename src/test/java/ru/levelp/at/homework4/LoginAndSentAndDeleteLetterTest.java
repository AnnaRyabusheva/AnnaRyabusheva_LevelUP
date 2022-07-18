package ru.levelp.at.homework4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.page.BasePageForPages;
import ru.levelp.at.page.DraftsPageForTest;
import ru.levelp.at.page.LoginPage;

public class LoginAndSentAndDeleteLetterTest extends BaseAbstractPageObjectClass {

    @Test
    public void loginAndSentAndDeleteTest() throws InterruptedException {

        LoginPage pageForTestSendAndDelete = new LoginPage(driver, wait);
        BasePageForPages basePageForPages = new BasePageForPages(driver, wait);
        DraftsPageForTest draftsPageForTest = new DraftsPageForTest(driver, wait);

        //1.Войти в почту
        pageForTestSendAndDelete.clickLoginBtn();
        driver.switchTo()
              .frame(driver.findElement(By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));
        pageForTestSendAndDelete.inputLogin(ConfProperties.getProperty("login"));
        pageForTestSendAndDelete.inputPasswd(ConfProperties.getProperty("password"));
        Thread.sleep(2000);

        SoftAssert softy = new SoftAssert();

        //2.Assert, что вход выполнен успешно
        pageForTestSendAndDelete.entryMenu();
        String user = basePageForPages.getUserName();
        softy.assertEquals("Ира Иванова", user);

        //3.Создать новое письмо (заполнить адресата, тему письма и тело)

        pageForTestSendAndDelete.createNewLetter();
        pageForTestSendAndDelete.sendColum();
        pageForTestSendAndDelete.sendTem();
        pageForTestSendAndDelete.sendTopic();

        //4.Отправить письмо
        pageForTestSendAndDelete.buttonForSentLetter();

        //5.Verify, что письмо появилось в папке Входящие
        pageForTestSendAndDelete.enterToIncomingLetterFolder();


        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}


        String mail = draftsPageForTest.verifyMailString();
        softy.assertEquals("irushik1981@mail.ru", mail);

        softy.assertTrue(pageForTestSendAndDelete.verifySubject(), "Тестовое письмо");

        String postField = basePageForPages.verifyPostField();
        softy.assertEquals("Первое тестовое письмо для теста. Лети.", postField);

        Thread.sleep(10000);
        //7.Удалить письмо

        //8.Verify что письмо появилось в папке Корзина

        //9. Выйти из учётной записи
        pageForTestSendAndDelete.exitFromMail();
        softy.assertAll();
    }
}
