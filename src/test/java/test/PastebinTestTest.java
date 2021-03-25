package test;
// I Can Win.TASK 1
//        При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
//        Открыть https://pastebin.com или аналогичный сервис в любом браузере
//        Создать New Paste со следующими деталями:
//        * Код: "Hello from WebDriver"
//        * Paste Expiration: "10 Minutes"
//        * Paste Name / Title: "helloweb"
//  Bring it on. TASK 2
//        Открыть https://pastebin.com  или аналогичный сервис в любом браузере
//        Создать New Paste со следующими деталями:
//        * Код:
//        git config --global user.name  "New Sheriff in Town"
//        git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
//        git push origin master --force
//        * Syntax Highlighting: "Bash"
//        * Paste Expiration: "10 Minutes"
//        * Paste Name / Title: "how to gain dominance among developers"
//         Сохранить paste и проверить следующее:
//        * Заголовок страницы браузера соответствует Paste Name / Title
//        * Синтаксис подвечен для bash
//        * Проверить что код соответствует введенному в пункте 2

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.BaseTest;

import java.util.List;


public class PastebinTestTest extends BaseTest {
        @Test
        public void pastebinTest(){
            // получаем доступ к сайту
            driver.get("https://pastebin.com");
            // ищем элемент по айдишнику и вносим запись в строку "Hello from WebDriver"
            driver.findElement(By.id("postform-text")).sendKeys("Hello from WebDriver");
            // кликаем по кнопке 'expiration', выставляем время, через которое сессия закроется
            driver.findElement(By.id("select2-postform-expiration-container")).click();
            //driver.findElement(By.xpath("//span[starts-with(@id,'select2-paste_expire_date')]")).click();
            // создаем список элементов, ищем элементы списка по css селекторам
            List<WebElement> elements = driver.findElements(By.cssSelector(".select2-results li"));
            elements.get(2).click();
            driver.findElement(By.id("postform-name")).sendKeys("helloweb");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
            Assert.assertTrue(driver.getTitle().contains("helloweb"));
            driver.quit();
        }
    }