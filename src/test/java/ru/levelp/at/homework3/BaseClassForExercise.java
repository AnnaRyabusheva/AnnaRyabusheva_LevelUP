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
        //1.Войти в почту

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
        driver.manage().window().maximize();

        driver.navigate().to("https://mail.ru/");
        driver.findElement(By.xpath("//*[@id=\"mailbox\"]/div[1]/button")).click();

        WebElement frame = driver.findElement((By.xpath("//div/iframe[@class=\"ag-popup__frame__layout__iframe\"]")));
        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("irushik1981" + Keys.ENTER);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("FirstPass159753" + Keys.ENTER);
        driver.switchTo().defaultContent();

        //2.Assert, что вход выполнен успешно

        driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]")).click();

        String txtUserName = driver.findElement(By.xpath("//*[@aria-label=\"Ира Иванова\"]")).getText();
        softly.assertThat(txtUserName).isEqualTo("Ира Иванова");
    }

    SoftAssertions softly = new SoftAssertions();

    @AfterMethod
    public void tearDown() {
        //       9. Выйти из учётной записи
        //        WebElement buttonClicK = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]"));
        //        buttonClicK.click();
        //        WebElement buttonExit = driver.findElement(By.xpath(
        //            "//div[@class=\"ph-sidebar svelte-3hgv3e\"]/*//div[@class=\"ph-item "
        //                + "ph-item__hover-active svelte-6ia8p0\"]"));
        //        buttonExit.click();
        driver.quit();
    }
}
