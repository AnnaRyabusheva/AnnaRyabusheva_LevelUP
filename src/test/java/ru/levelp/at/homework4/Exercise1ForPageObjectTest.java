package ru.levelp.at.homework4;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.page.LoginPage;
import ru.levelp.at.page.PageToCreateAndSentEmail;

public class Exercise1ForPageObjectTest extends AbstractSeleniumBaseTest {

    //3.Создать новое письмо (заполнить адресата, тему письма и тело)
    @Test
    public void sentAndSaveTest() {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softy = new SoftAssert();
        //1.Войти в почту.
        loginPage.openLoginForm();
        loginPage.loginInEmail(ConfProperties.getProperty("login"));
        loginPage.putPassword(ConfProperties.getProperty("password"));
        //2.Assert, что вход выполнен успешно.
        softy.assertEquals(loginPage.verifyTitle(), "Ира Иванова");
        //3.Создать новое письмо (заполнить адресата, тему письма и тело)
        PageToCreateAndSentEmail pageToCreateAndSentEmail = new PageToCreateAndSentEmail(driver);
        pageToCreateAndSentEmail.tabToNewLetterButton();
        pageToCreateAndSentEmail.fillSender("irushik1981@mail.ru", "Тестовое письмо", "Первое письмо для Page Object");
        //4.Сохранить его как черновик
        pageToCreateAndSentEmail.saveLetter();
        //5.Verify, что письмо сохранено в черновиках
        pageToCreateAndSentEmail.draftButtonClick();



        //9. Выйти из учётной записи
        softy.assertAll();
    }
}
