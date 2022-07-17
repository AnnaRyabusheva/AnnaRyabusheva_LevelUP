package ru.levelp.at.homework4PageObject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginAndSentLetterTest extends BaseAbstractPageObjectClass {

    @Test
    public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver, wait);
        BasePageForPages basePageForPages = new BasePageForPages(driver, wait);
        DraftsPageForTest draftsPageForTest = new DraftsPageForTest(driver, wait);
        SoftAssert softy = new SoftAssert();
        //1.Войти в почту

        loginPage.clickLoginBtn();

        driver.switchTo()
              .frame(driver.findElement(By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        Thread.sleep(2000);

        //2.Assert, что вход выполнен успешно

        BasePageForPages.entryMenu();
        String user = basePageForPages.getUserName();
        softy.assertEquals("Ира Иванова", user);

        //3.Создать новое письмо (заполнить адресата, тему письма и тело)

        BasePageForPages.createNewLetter();
        BasePageForPages.sendColum();
        BasePageForPages.sendTem();
        BasePageForPages.sendTopic();

        //4.Сохранить его как черновик

        BasePageForPages.saveButtonForDraft();
        BasePageForPages.closeButtonOnLetter();

        //5.Verify, что письмо сохранено в черновиках
        BasePageForPages.clickToDraftsButton();
        DraftsPageForTest.verifyLetterInDrafts();
        DraftsPageForTest.enterInLetter();





        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}
        String mail = draftsPageForTest.verifyMailString();
        softy.assertEquals("irushik1981@mail.ru", mail);

        String subject =basePageForPages.verifySubject();
        softy.assertEquals("Тестовое письмо", subject );

        String postField=basePageForPages.verifyPostField();
        softy.assertEquals("Первое тестовое письмо для теста. Лети.", postField);

        Thread.sleep(10000);
        //7.Отправить письмо

        BasePageForPages.buttonForSentLetter();
        //8.Verify, что письмо исчезло из черновиков


        BasePageForPages.buttonOfFolderOfSendLetters();
//        BasePageForPages.ve();
        //9.Verify, что письмо появилось в папке отправленные

        //10. Выйти из учётной записи
        BasePageForPages.exitFromMail();
        softy.assertAll();
    }
}
