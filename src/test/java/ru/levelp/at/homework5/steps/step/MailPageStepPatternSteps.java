package ru.levelp.at.homework5.steps.step;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.homework4.ConfProperties;
import ru.levelp.at.homework5.step.BasePage;
import ru.levelp.at.homework5.step.CreateAndSentPage;
import ru.levelp.at.homework5.step.LoginPage;

public class MailPageStepPatternSteps {
    private WebDriver driver;
    private CreateAndSentPage createAndSentPage;
    private LoginPage loginPage;
    private BasePage basePage;

    public MailPageStepPatternSteps(WebDriver driver) {
        this.driver = driver;
        this.createAndSentPage = new CreateAndSentPage(driver);
        this.loginPage = new LoginPage(driver);
        this.basePage = new BasePage(driver);
    }

    SoftAssert softy = new SoftAssert();

    public void openLoginFormAndLoginInMail() {
        loginPage.openLoginForm();
        loginPage.loginInEmail(ru.levelp.at.homework4.ConfProperties.getProperty("login"));
        loginPage.putPassword(ConfProperties.getProperty("password"));
    }

    public void verifyTitle() {
        softy.assertEquals(loginPage.verifyTitle(), "Ира Иванова");
    }

    public void createNewLetterAndFillTheForms() {
        createAndSentPage.clickToFlyWindow();
        basePage.tabToNewLetterButton();
        createAndSentPage.fillSender("irushik1981@mail.ru", "Тестовое письмо", "Первое письмо "
            + "для Page Object");
    }

    public void saveLetterAsDraft() {
        createAndSentPage.saveLetter();
        createAndSentPage.exitLetter();
    }

    public void verifyThatLetterInFolderDraft() {
        basePage.draftButtonClick();
        softy.assertTrue(createAndSentPage.verifyLetterInDraft());
    }

    public void verifySenderTopicAndBodyOfLetter() {
        createAndSentPage.clickToLetterInDraft();
        softy.assertEquals(createAndSentPage.sender(), "irushik1981@mail.ru");
        softy.assertEquals(createAndSentPage.topicVerify(), "Тестовое письмо");
        softy.assertEquals(createAndSentPage.bodyToVerify(), "Первое письмо для Page Object");
    }

    public void sentLetter() {
        createAndSentPage.sentLetter();
        createAndSentPage.closeWindowA();
    }

    public void verifyLetterDisappearedFromDraft() {
        basePage.draftButtonClick();
        softy.assertTrue(!createAndSentPage.letterNotVisible().isEmpty());
    }

    public void exitFromEmail() {
        basePage.exit();
        softy.assertAll();
    }

    public void verifyLetterInSenderFold() {
        createAndSentPage.clickToSenderFolder();
        softy.assertEquals(createAndSentPage.verifyLetterInSenderFolder(), "Self: Тест");
    }

    public void letterIsDisplayedInTestFolder() {
        createAndSentPage.clickToFolderTest();
        softy.assertEquals(createAndSentPage.verifyLetterInTestFolder(), "Тест");
    }

    public void fillFolderInLetterExercise2() {
        createAndSentPage.clickToFlyWindow();
        basePage.tabToNewLetterButton();
        createAndSentPage.fillSender("irushik1981@mail.ru", "Тест", "Второе письмо "
            + "для Page Object");
    }

    public void checkingEmailFields() {
        softy.assertEquals(createAndSentPage.verifyEmailInTestFolder(), "Ира Иванова");
        softy.assertEquals(createAndSentPage.verifyTopicInTestFolder(), "Тест");
        softy.assertEquals(createAndSentPage.verifyBodyInTestFolder(), "Второе письмо для Page Object");
    }

    public void checkLetterInIncoming() {
        basePage.enterToIncoming();
        createAndSentPage.verifyLetterInIncoming();
    }

    public void fillFolderInLetterExercise3() {
        createAndSentPage.clickToFlyWindow();
        basePage.tabToNewLetterButton();
        createAndSentPage.fillSender("irushik1981@mail.ru", "Во входящие", "Третье письмо "
            + "для Page Object");
    }

    public void checkFillTheFolderInLetter() {
        createAndSentPage.clickToElementInIncoming();
        softy.assertEquals(createAndSentPage.verifyEmailInIncomingLetter(), "Ира Иванова");
        softy.assertEquals(createAndSentPage.verifyTopicInTestFolder(), "Во входящие");
        softy.assertEquals(createAndSentPage.verifyBodyInIncoming(), "Третье письмо для Page Object");
    }

    public void deleteLetter() {
        createAndSentPage.deleteLetter();
    }

    public void letterIsDisplayedInTrashFolder() {
        basePage.clickToBasket();
        softy.assertTrue(!createAndSentPage.verifyLetterInBasket().isEmpty());
    }
}
