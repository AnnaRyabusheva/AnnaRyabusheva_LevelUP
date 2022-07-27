package ru.levelp.at.homework4;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.homework4.page.LoginPage;
import ru.levelp.at.homework4.page.CreateAndSentPage;

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
        CreateAndSentPage createAndSentPage = new CreateAndSentPage(driver);
        createAndSentPage.tabToNewLetterButton();
        createAndSentPage.fillSender("irushik1981@mail.ru", "Тестовое письмо", "Первое письмо "
            + "для Page Object");
        //4.Сохранить его как черновик
        createAndSentPage.saveLetter();
        createAndSentPage.exitLetter();
        //5.Verify, что письмо сохранено в черновиках
        createAndSentPage.draftButtonClick();
        softy.assertTrue(createAndSentPage.verifyLetterInDraft());
        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3
        createAndSentPage.clickToLetterInDraft();
        softy.assertEquals(createAndSentPage.sender(), "irushik1981@mail.ru");
        softy.assertEquals(createAndSentPage.topicVerify(), "Тестовое письмо");
        softy.assertEquals(createAndSentPage.bodyToVarify(), "Первое письмо для Page Object");
        //7.Отправить письмо
        createAndSentPage.sentLetter();
        //8.Verify, что письмо исчезло из черновиков
        softy.assertTrue(createAndSentPage.letterNotVisible(), String.valueOf(true));
        //9. Выйти из учётной записи
        softy.assertAll();
    }
}
