package ru.levelp.at.homework5.steps.tests;

import org.testng.annotations.Test;

public class Exercise2StepPatternTest extends AbstractSeleniumBaseTest {

    @Test
    public void createAndSaveLetter() {
        steps.openLoginFormAndLoginInMail();
        steps.verifyTitle();
        steps.fillFolderInLetterExercise2();
        steps.sentLetter();
        steps.verifyLetterInSenderFold();
        steps.letterIsDisplayedInTestFolder();
        steps.checkingEmailFields();
        steps.exitFromEmail();
    }
}
