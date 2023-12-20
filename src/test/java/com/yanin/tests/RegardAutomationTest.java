package com.yanin.tests;

import org.junit.After;
import org.junit.Before;
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

    WebDriver driver;
    WebDriverWait waitTime;
    @Before
    public void before() {
        // WebDriver path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("http://regard.ru");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        waitTime = new WebDriverWait(driver, 10, 2000);


    }

    @Test
    public void test() {



        // Открываем бургер-меню "Каталог"
        String baseCatalogXpath = "//div[@class='NavigationBar_burger__j7lZE']";
        WebElement baseCatalog = driver.findElement(By.xpath(baseCatalogXpath));
        baseCatalog.click();

        // Выбираем раздел каталога
        String subCatalogXpath = "//div//a[@data-id='1536']";
        WebElement subCatalog = driver.findElement(By.xpath(subCatalogXpath));
        subCatalog.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //waitTime.until(ExpectedConditions.attributeContains())
        // Проверяем загрузился ли раздел и выбираем категорию товаров
        WebElement subCatalogTitle = driver.findElement(By.xpath("//div[@class='div page_title h1']"));
        String titleClassValue = subCatalogTitle.getAttribute("class");
        String exceptedClassValue = "div page_title h1";
        Assert.assertEquals("Раздел не загрузился", exceptedClassValue, titleClassValue);

        String categoryCatalogXpath = "//p[@class='CardCategory_title__K2CCX' and contains(text(),'Видеокарты')]";
        WebElement categoryCatalog = driver.findElement(By.xpath(categoryCatalogXpath));
        categoryCatalog.click();



        // Задаем фильтр по цене
        String priceFilterXpath = "//div/input[@class='RangeSelector_input__26nqz range-selector-input' and @name='min'][1]";
        WebElement priceFilter = driver.findElement(By.xpath(priceFilterXpath));
        priceFilter.sendKeys("20000");

        // Выбираем производителя Gigabyte
        String setVendorXpath = "//label[contains(text(),'Gigabyte')]";
        WebElement setVendor = driver.findElement(By.xpath(setVendorXpath));
        setVendor.click();


        // Проверяем количество товаров на странице
        String productsOnPage = String.valueOf(driver.findElement(By.xpath("//div/span[@class='PaginationViewChanger_countSetter__count__65Dji' and contains(text(),'24')]")));
        Assert.assertTrue("Количество товаров не соответствует 24", productsOnPage.contains("24"));



        // Сохраняем наименование первого товара
        String findFirstProductNameXpath = "//div[text()[contains(.,'Видеокарта')]][1]";
        WebElement findFirstProductName = driver.findElement(By.xpath(findFirstProductNameXpath));
        String firstProductName = findFirstProductName.getText();

        System.out.println("Наименование первого товара: " + firstProductName);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ищем по сохраненному наименованию
        WebElement searchBox = driver.findElement(By.id("searchInput")); // Укажите правильный id поисковой строки
        searchBox.sendKeys(firstProductName);
        searchBox.click();
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
        String searchProductNameXpath = "//div[@title and text()[contains(.,'Видеокарта')]]";
        WebElement searchProductName = driver.findElement(By.xpath(searchProductNameXpath));
        String realProductName = searchProductName.getText();

        Assert.assertEquals("Наименование найденного товара не соответствует ранее сохраненному",firstProductName, realProductName);


    }


}