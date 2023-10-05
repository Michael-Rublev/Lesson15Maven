import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Google {

    @Test
    public void testSearch() {
        WebDriver driver = new ChromeDriver(); //драйвер(интерфейс) через которую управляется браузер
        driver.get("https://www.selenium.dev/selenium/web/web-form.html"); // переход на страницу

        String title = driver.getTitle(); // получение заголовка вкладки
        Assert.assertEquals(title, "Web form"); // мы ожидаем что на странице "будет заголовок"

        // замедление
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // метод файнделемент, и передаём искомый элемент
        WebElement textBox = driver.findElement(By.name("my-text")); //by.name() локатор
        WebElement submitButton = driver.findElement(By.cssSelector("button")); //by.cssSelector() локатор

        textBox.sendKeys("Selenium"); //вводимый текст
        submitButton.click(); // кнопка сабмит на странице

        // переход на страницу
        WebElement message = driver.findElement(By.id("message")); //искомый елемент в html
        String value = message.getText(); // мы берем текст и сохраняем в переменную и ожидаем ->
        Assert.assertEquals(value, "Received!"); //что текст переменной будет Received

        driver.quit(); //закрывает страницу браузера
    }
}