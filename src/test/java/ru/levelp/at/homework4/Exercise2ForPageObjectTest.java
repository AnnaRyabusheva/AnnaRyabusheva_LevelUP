package ru.levelp.at.homework4;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.homework4.page.CreateAndSentPage;
import ru.levelp.at.homework4.page.LoginPage;

public class Exercise2ForPageObjectTest extends AbstractSeleniumBaseTest {

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
        createAndSentPage.fillSender("irushik1981@mail.ru", "Тест", "Второе письмо "
            + "для Page Object");
        //4.Отправить письмо
        createAndSentPage.sentLetter();
        createAndSentPage.closeWindowA();
        //5.Verify, что письмо появилось в папке отправленные
        createAndSentPage.clickToSenderFolder();
        createAndSentPage.verifyLetterInSenderFolder();
        //6.Verify, что письмо появилось в папке «Тест»
        createAndSentPage.clickToFolderTest();

        //7.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)

//        softy.assertEquals(createAndSentPage.sender(), "irushik1981@mail.ru");
//        softy.assertEquals(createAndSentPage.topicVerify(), "Тест");
//        softy.assertEquals(createAndSentPage.bodyToVarify(), "Второе письмо для Page Object");

//        softy.assertTrue(true);
        //8.Выйти из учётной записи
        createAndSentPage.exit();
        softy.assertAll();
    }
}
