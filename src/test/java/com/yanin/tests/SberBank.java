package com.yanin.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class SberBank {

    @Test
    public void test(){
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

        WebElement regionAcept = driver.findElement(By.xpath("//button[@class='kitt-region__accept']"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        regionAcept.click();

        WebElement baseMenu = driver.findElement(By.xpath("//a[text()='Страхование' and @role]"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        baseMenu.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
