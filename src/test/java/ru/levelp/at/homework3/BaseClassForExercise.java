package ru.levelp.at.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        driver.navigate().to("https://mail.ru/");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/div[1]/button"));
        loginButton.click();
        WebElement frame = driver.findElement((By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));
        driver.switchTo().frame(frame);

        WebElement userName = driver.findElement(
            By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/form/div[2]/div[2]/div[1]/div/div"));
        userName.click();
        WebElement userField = driver.findElement(By.xpath("//input[@name='username']"));

        userField.sendKeys("irushik1981" + Keys.ENTER);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("FirstPass159753" + Keys.ENTER);
        driver.switchTo().defaultContent();
    }
    SoftAssertions softly = new SoftAssertions();

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
}
