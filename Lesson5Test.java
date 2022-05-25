package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Lesson5Test {
    static WebDriver driver;
    static WebDriverWait WebDriverWait;
    private Arrays filmList;

    @BeforeAll
    static void registorDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
            WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        }


    @Test
    void likeDressTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_1']")).click();
        driver.findElement(By.xpath("//input[@id='layered_category_4']")).click();
        Thread.sleep(5000);


        Assertions.assertEquals(driver.findElement(By.xpath("//input[@id='layered_category_4']")).isDisplayed(), false);

        }

    @AfterEach
    void tearDown(){
        driver.quit();
        }

    }

