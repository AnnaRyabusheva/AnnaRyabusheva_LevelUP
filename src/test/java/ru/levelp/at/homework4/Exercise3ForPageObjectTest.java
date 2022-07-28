package ru.levelp.at.homework4;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.homework4.page.CreateAndSentPage;
import ru.levelp.at.homework4.page.LoginPage;

public class Exercise3ForPageObjectTest extends AbstractSeleniumBaseTest {

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
        createAndSentPage.fillSender("irushik1981@mail.ru", "Во входящие", "Третье письмо "
            + "для Page Object");
        //4.Отправить письмо
        createAndSentPage.sentLetter();
        createAndSentPage.closeWindowA();
        //5.Verify, что письмо появилось в папке Входящие
        createAndSentPage.enterToIncoming();
        createAndSentPage.verifyLetterInIncoming();

        //6.Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        createAndSentPage.clickToElementInIncoming();
        softy.assertEquals(createAndSentPage.verifyEmailInIncomingLetter(), "Ира Иванова");
        softy.assertEquals(createAndSentPage.verifyTopicInTestFolder(), "Во входящие");
        softy.assertEquals(createAndSentPage.verifyBodyInIncoming(), "Третье письмо для Page Object");

        //7.Удалить письмо
        createAndSentPage.deleteLetter();


        //8.Verify что письмо появилось в папке Корзина
        createAndSentPage.clickToBasket();
        softy.assertTrue(createAndSentPage.verifyLetterInBasket());
        //9.Выйти из учётной записи: выполнено в базовом классе
        createAndSentPage.exit();
        softy.assertAll();
    }
}
