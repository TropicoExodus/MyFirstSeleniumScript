package com.yanin.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegardAutomationTest {
    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://regard.ru");

        driver.findElement(By.xpath("//div[@class='NavigationBar_burger__j7lZE']")).click(); // Открываем бургер-меню "Каталог"
        driver.findElement(By.xpath("//div//a[@data-id='1536']")).click(); // Выбираем раздел комплектующих

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//p[@class='CardCategory_title__K2CCX' and contains(text(),'Видеокарты')]")).click(); // Выбираем "Видеокарты"

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Задаем фильтр по цене
        WebElement priceFilter = driver.findElement(By.xpath("//div/input[@class='RangeSelector_input__26nqz range-selector-input' and @name='min'][1]"));
        priceFilter.sendKeys("20000");

        // Выбираем производителя Gigabyte
        driver.findElement(By.xpath("//label[contains(text(),'Gigabyte')]")).click();


        // Проверяем количество товаров на странице
        String productsOnPage = String.valueOf(driver.findElement(By.xpath("//div/span[@class='PaginationViewChanger_countSetter__count__65Dji' and contains(text(),'24')]")));
        Assert.assertTrue("Количество товаров не соответствует 24", productsOnPage.contains("24"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Сохраняем наименование первого товара
        WebElement findFirstProductName = driver.findElement(By.xpath("//div[text()[contains(.,'Видеокарта')]][1]"));
        String firstProductName = findFirstProductName.getText();

        System.out.println("Наименование первого товара: " + firstProductName);

        // Ищем по сохраненному наименованию
        WebElement searchBox = driver.findElement(By.id("searchInput")); // Укажите правильный id поисковой строки
        searchBox.sendKeys(firstProductName);
//        searchBox.click();
        searchBox.sendKeys(Keys.ENTER);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Ожидаем результат поиска и проверяем количество товаров
        WebElement oneInResult = driver.findElement(By.xpath("//div[text()='Выбран 1 товар']"));
        Assert.assertTrue("Выбрано больше 1 товара", oneInResult.isDisplayed());

        // Проверяем соответствие наименования найденного товара ранее сохраненному
        WebElement searchProductName = driver.findElement(By.xpath("//div[@title and text()[contains(.,'Видеокарта')]]"));
        String realProductName = searchProductName.getText();

        Assert.assertEquals("Наименование найденного товара не соответствует ранее сохраненному",firstProductName, realProductName);
//        Assert.assertEquals(firstProductName,findFirstProductName.getText());


    }
}