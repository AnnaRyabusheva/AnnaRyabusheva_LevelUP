package ru.levelp.at.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClassForExercise {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        driver.manage().window().maximize();
    }
    SoftAssertions softly = new SoftAssertions();

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
}
