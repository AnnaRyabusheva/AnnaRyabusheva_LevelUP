package ru.levelp.at.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClassForExercise {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        //1.Войти в почту

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.navigate().to("https://mail.ru/");
        driver.findElement(By.xpath("//div[@id=\"mailbox\"]/div/button[@data-testid=\"enter-mail-primary\"]")).click();

        WebElement frame = driver.findElement((By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));
        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("irushik1981" + Keys.ENTER);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("FirstPass159753" + Keys.ENTER);
        driver.switchTo().defaultContent();

        //2.Assert, что вход выполнен успешно

        driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]//div[@aria-label=\"irushik1981@mail.ru\"]")).click();

        String txtUserName = driver.findElement(By.xpath("//*[@aria-label=\"Ира Иванова\"]")).getText();
        softly.assertThat(txtUserName).isEqualTo("Ира Иванова");
    }

    SoftAssertions softly = new SoftAssertions();

    @AfterMethod
    public void tearDown() {
        //9. Выйти из учётной записи
        WebElement buttonClick = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]"
            + "//div[@aria-label=\"irushik1981@mail.ru\"]"));
        buttonClick.click();
        WebElement buttonExit = driver.findElement(By.xpath(
            "//div[contains(@class, \"ph-sidebar\")]//div[contains(@data-testid, \"whiteline-account-exit\")]"));
        buttonExit.click();
        driver.quit();
    }
}
