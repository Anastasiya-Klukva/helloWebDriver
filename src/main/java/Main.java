import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Studies\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // получаем доступ к параметрам, заадали неявное ожидание
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        //неявное ожидание
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
        // получаем доступ к гуглу
        driver.get("https://google.com");
        // создаем переменную, которая будет хранить ссылку на наш объект
        WebElement input = driver.findElement(By.xpath("//form/div/input"));
        // кликаем по нему
        input.click();
    }
}
