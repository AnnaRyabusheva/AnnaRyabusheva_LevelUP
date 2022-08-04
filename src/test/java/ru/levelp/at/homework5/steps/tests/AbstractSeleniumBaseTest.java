package ru.levelp.at.homework5.steps.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.homework5.steps.step.MailPageStepPatternSteps;

public abstract class AbstractSeleniumBaseTest {
    protected static final String MAIL_URL = "https://mail.ru/";

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected MailPageStepPatternSteps steps;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        steps = new MailPageStepPatternSteps(driver);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
