// I Can Win
//        При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
//
//        Открыть https://pastebin.com или аналогичный сервис в любом браузере
//        Создать New Paste со следующими деталями:
//        * Код: "Hello from WebDriver"
//
//        * Paste Expiration: "10 Minutes"
//
//        * Paste Name / Title: "helloweb"

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class PastebinTestTest extends BaseTest{
        @Test
        public void pastebinTest(){
            driver.get("https://pastebin.com");
            driver.findElement(By.id("postform-text")).sendKeys("Hello from WebDriver");
            driver.findElement(By.id("select2-postform-expiration-container")).click();
            driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
            List<WebElement> elements = driver.findElements(By.cssSelector(".select2-results li"));
            elements.get(2).click();
            driver.findElement(By.id("postform-name")).sendKeys("helloweb");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(driver.getTitle().contains("helloweb"));
            driver.quit();
        }
    }