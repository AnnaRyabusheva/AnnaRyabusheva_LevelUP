package ru.levelp.at.homework5.steps.tests;

import org.testng.annotations.Test;

public class Exercise1StepPatternTest extends AbstractSeleniumBaseTest {

    @Test
    public void createAndSaveLetter() {
        steps.openLoginFormAndLoginInMail();
        steps.verifyTitle();
        steps.createNewLetterAndFillTheForms();
        steps.saveLetterAsDraft();
        steps.verifyThatLetterInFolderDraft();
        steps.verifySenderTopicAndBodyOfLetter();
        steps.sentLetter();
        steps.verifyLetterDisappearedFromDraft();
        steps.exitFromEmail();
    }
}
