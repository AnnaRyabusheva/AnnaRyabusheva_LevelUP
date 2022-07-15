package ru.levelp.at.homework4PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseAbstractPageObjectClass {

    @Test
    public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver, wait);
        BasePageForPages basePageForPages = new BasePageForPages(driver, wait);
        DraftsPageForTest draftsPageForTest = new DraftsPageForTest(driver, wait);

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
        Assert.assertEquals("Ира Иванова", user);

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
        String mail = draftsPageForTest.verifyMailString();
        Assert.assertEquals("irushik1981@mail.ru", mail);

        Thread.sleep(10000);

        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)}
        //7.Отправить письмо
        //8.Verify, что письмо исчезло из черновиков
        //9.Verify, что письмо появилось в папке отправленные
        //10. Выйти из учётной записи
        BasePageForPages.exitFromMail();
    }
}
