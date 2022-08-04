package ru.levelp.at.homework5.steps.tests;

import org.testng.annotations.Test;

public class Exercise3StepPatternTest extends AbstractSeleniumBaseTest {

    @Test
    public void createAndSaveLetter() {
        steps.openLoginFormAndLoginInMail();
        steps.verifyTitle();
        steps.fillFolderInLetterExercise3();
        steps.sentLetter();
        steps.checkLetterInIncoming();
        steps.checkFillTheFolderInLetter();
        steps.deleteLetter();
        steps.letterIsDisplayedInTrashFolder();
        steps.exitFromEmail();
    }
}
