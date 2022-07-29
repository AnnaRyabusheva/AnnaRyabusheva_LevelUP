package ru.levelp.at.homework4;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.homework4.page.BasePage;
import ru.levelp.at.homework4.page.CreateAndSentPage;
import ru.levelp.at.homework4.page.LoginPage;

public class Exercise2ForPageObjectTest extends AbstractSeleniumBaseTest {

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
        BasePage basePage = new BasePage(driver);
        basePage.tabToNewLetterButton();
        createAndSentPage.fillSender("irushik1981@mail.ru", "Тест", "Второе письмо "
            + "для Page Object");
        //4.Отправить письмо
        createAndSentPage.sentLetter();
        createAndSentPage.closeWindowA();
        //5.Verify, что письмо появилось в папке отправленные
        createAndSentPage.clickToSenderFolder();
        softy.assertEquals(createAndSentPage.verifyLetterInSenderFolder(), "Self: Тест");

        //6.Verify, что письмо появилось в папке «Тест»
        createAndSentPage.clickToFolderTest();
        softy.assertEquals(createAndSentPage.verifyLetterInTestFolder(), "Тест");

        //7.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)

        softy.assertEquals(createAndSentPage.verifyEmailInTestFolder(), "Ира Иванова");
        softy.assertEquals(createAndSentPage.verifyTopicInTestFolder(), "Тест");
        softy.assertEquals(createAndSentPage.verifyBodyInTestFolder(), "Второе письмо для Page Object");

        //8.Выйти из учётной записи
        basePage.exit();
        softy.assertAll();
    }
}
