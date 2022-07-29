package ru.levelp.at.homework4;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.homework4.page.CreateAndSentPage;
import ru.levelp.at.homework4.page.LoginPage;

public class Exercise1ForPageObjectTest extends AbstractSeleniumBaseTest {

    //3.Создать новое письмо (заполнить адресата, тему письма и тело)
    @Test
    public void sentAndSaveTest() {
        LoginPage loginPage = new LoginPage(driver);
        //1.Войти в почту.
        loginPage.openLoginForm();
        loginPage.loginInEmail(ConfProperties.getProperty("login"));
        loginPage.putPassword(ConfProperties.getProperty("password"));
        //2.Assert, что вход выполнен успешно.
        SoftAssert softy = new SoftAssert();
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
        softy.assertEquals(createAndSentPage.bodyToVerify(), "Первое письмо для Page Object");
        //7.Отправить письмо
        createAndSentPage.sentLetter();
        createAndSentPage.closeWindowA();
        //8.Verify, что письмо исчезло из черновиков

        createAndSentPage.draftButtonClick();
        softy.assertTrue(!createAndSentPage.letterNotVisible().isEmpty());

        //9. Выйти из учётной записи
        createAndSentPage.exit();
        softy.assertAll();
    }
}
