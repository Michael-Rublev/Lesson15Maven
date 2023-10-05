import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTest2 {

    @Test
    public void testSearch() {
        WebDriver driver = new ChromeDriver(); //драйвер(интерфейс) через которую управляется браузер
        driver.get("https://www.google.com/"); // переход на страницу

        // метод файнделемент, и передаём искомый элемент
        WebElement textBox = driver.findElement(By.className("gLFyf")); //by.name() локатор
        WebElement searchButton = driver.findElement(By.className("button")); //by.cssSelector() локатор

        textBox.sendKeys("Selenium"); //вводимый текст
        searchButton.click(); // кнопка сабмит на странице

        // переход на страницу
        WebElement title = driver.findElement(By.className("SPZz6b")); //искомый елемент в html
        String value = title.getText(); // мы берем текст и сохраняем в переменную и ожидаем ->
        Assert.assertEquals(value, "Selenium"); //что текст переменной будет Received

        driver.quit(); //закрывает страницу браузера
    }
}