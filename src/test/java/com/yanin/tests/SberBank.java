package com.yanin.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SberBank {
    WebDriver driver;
    WebDriverWait waitTime;
    @Before
    public void before(){
        // WebDriver path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();


//        driver.navigate().to("https://www.sberbank.ru/ru/person");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        waitTime = new WebDriverWait(driver, 10, 2000);
        driver.get("https://www.sberbank.ru/ru/person");

//        WebElement baseMenu = driver.findElement(By.linkText("Страхование"));
//        WebElement baseMenu = driver.findElement(By.cssSelector(".kitt-top-menu__icon-img"))

    }

    @Test
    public void test() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//         Подтверждение региона в всплывающем окне
        WebElement regionAcept = driver.findElement(By.xpath("//button[@class='kitt-region__accept']"));


        regionAcept.click();


//      Подтверждение куки
        WebElement subMenu1 = driver.findElement(By.xpath("//*[text()='Принять']"));

        subMenu1.click();


        //     Переход по иконке Страхование
        WebElement baseMenu = driver.findElement(By.xpath("//a[text()='Страхование' and @role]"));



        baseMenu.click();

//        ((JavascriptExecutor) driver).executeAsyncScript("arguments[0].click();",baseMenu);

//      Проверка на основе изменения атрибута
        WebElement parentBaseMenu = baseMenu.findElement(By.xpath("./.."));
//      waitTime.until(ExpectedConditions.attributeContains(baseMenu, "class", "opened"));

        Assert.assertTrue("Клик по пункту меню не выполнен", parentBaseMenu.getAttribute("class").contains("opened"));




//      Переход на экран "Все страховые программы"
        WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(), 'Все страховые программы') and contains (@href, 'bank_inshure')]"));
        subMenu.click();


//      Проверка перехода на страницу с программами страхования
        WebElement inshCheck = driver.findElement(By.xpath("//h1/span[contains(text(),'Страхование')]"));

        Assert.assertTrue("Страница не загрузилась", inshCheck.isDisplayed());
//                inshCheck.getText().contains("Страхование"));


        String errorMessage = "Текст на кнопке не совпал\n" +
                "Ожидали: Страхование\n" +
                "Фактическое: " + inshCheck.getText();
        Assert.assertEquals(errorMessage, "Страхование", inshCheck.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @After
    public void after(){
        driver.quit();
    }
}