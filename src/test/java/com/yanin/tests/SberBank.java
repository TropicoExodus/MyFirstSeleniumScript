package com.yanin.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class SberBank {

    @Test
    public void test() {
        // WebDriver path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.sberbank.ru/ru/person");
//        driver.navigate().to("https://www.sberbank.ru/ru/person");
        driver.manage().window().maximize();

//        WebElement baseMenu = driver.findElement(By.linkText("Страхование"));
//        WebElement baseMenu = driver.findElement(By.cssSelector(".kitt-top-menu__icon-img"))

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//         Подтверждение региона в всплывающем окне
        WebElement regionAcept = driver.findElement(By.xpath("//button[@class='kitt-region__accept']"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        regionAcept.click();

//      Подтверждение куки
        WebElement subMenu1 = driver.findElement(By.xpath("//*[text()='Принять']"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subMenu1.click();


        //     Переход по иконке Страхование
        WebElement baseMenu = driver.findElement(By.xpath("//a[text()='Страхование' and @role]"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        baseMenu.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      Переход на экран "Все страховые программы"
        WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(), 'Все страховые программы') and contains (@href, 'bank_inshure')]"));
        subMenu.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      Проверка перехода на страницу с программами страхования
        WebElement inshCheck = driver.findElement(By.xpath("//span[@class='dk-sbol-button__text dk-sbol-button__text_size_md']"));

        Assert.assertTrue("Страница не загрузилась",inshCheck.isDisplayed() &&
                inshCheck.getText().contains("Оформить онлайн"));


        String errorMessage = "Текст на кнопке не совпал\n" +
                "Ожидали: Оформить онлайн\n" +
                "Фактическое: " + inshCheck.getText();
        Assert.assertEquals(errorMessage, "Оформить онлайн", inshCheck.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.quit();
    }
}
