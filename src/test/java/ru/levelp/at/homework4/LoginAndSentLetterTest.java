package ru.levelp.at.homework4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.page.BasePageForPages;
import ru.levelp.at.page.DraftsPageForTest;
import ru.levelp.at.page.LoginPage;

public class LoginAndSentLetterTest extends BaseAbstractPageObjectClass {

    @Test
    public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver, wait);
        DraftsPageForTest draftsPageForTest = new DraftsPageForTest(driver, wait);
        //1.Войти в почту
        loginPage.clickLoginBtn();
        driver.switchTo()
              .frame(driver.findElement(By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));



        //2.Assert, что вход выполнен успешно
        BasePageForPages basePageForPages = new BasePageForPages(driver, wait);
        SoftAssert softy = new SoftAssert();
        Thread.sleep(2000);
        loginPage.entryMenu();
        String user = basePageForPages.getUserName();
        softy.assertEquals("Ира Иванова", user);
        //3.Создать новое письмо (заполнить адресата, тему письма и тело)
        loginPage.createNewLetter();
        loginPage.sendColum();
        loginPage.sendTem();
        loginPage.sendTopic();

        //4.Сохранить его как черновик

        loginPage.saveButtonForDraft();
        loginPage.closeButtonOnLetter();

        //5.Verify, что письмо сохранено в черновиках

        loginPage.clickToDraftsButton();

        draftsPageForTest.verifyLetterInDrafts();
        draftsPageForTest.enterInLetter();

        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}
        String mail = draftsPageForTest.verifyMailString();
        softy.assertEquals("irushik1981@mail.ru", mail);

        softy.assertTrue(loginPage.verifySubject(), "Тестовое письмо");

        String postField = loginPage.verifyPostField();
        softy.assertEquals("Первое тестовое письмо для теста. Лети.", postField);

        //7.Отправить письмо

        loginPage.buttonForSentLetter();
        //8.Verify, что письмо исчезло из черновиков

        loginPage.buttonOfFolderOfSendLetters();
        Thread.sleep(8000);
        //9.Verify, что письмо появилось в папке отправленные


        //10. Выйти из учётной записи
        loginPage.exitFromMail();
        softy.assertAll();
    }
}
