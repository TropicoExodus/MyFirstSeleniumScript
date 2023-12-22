package com.yanin.framewok.tests;

import com.yanin.framewok.base.BaseTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegardAutomationTwoTest extends BaseTests {

    @Test
    //@DisplayName("Тест кейс Клавиатуры")
    public void test2() {

        // Открываем бургер-меню "Каталог"
        String baseCatalogXpath = "//div[@class='NavigationBar_burger__j7lZE']";
        WebElement baseCatalog = driver.findElement(By.xpath(baseCatalogXpath));
        baseCatalog.click();

        // Выбираем раздел каталога
        String subCatalogXpath = "//div//a/div[text()='Периферия']";
        WebElement subCatalog = driver.findElement(By.xpath(subCatalogXpath));
        subCatalog.click();

        //Проверяем, выбран ли раздел каталог
        WebElement subCatalogLoad = driver.findElement(By.xpath("//div[@class='div page_title h1']"));
        waitTime.until(ExpectedConditions.attributeContains(subCatalogLoad, "class", "div page_title h1"));

        // Выбираем категорию товаров
        String categoryCatalogXpath = "//p[@class='CardCategory_title__K2CCX' and contains(text(),'Клавиатуры')]";
        WebElement categoryCatalog = driver.findElement(By.xpath(categoryCatalogXpath));
        categoryCatalog.click();


        // Задаем фильтр по цене
        String priceFilterXpath = "//div/input[@class='RangeSelector_input__26nqz range-selector-input' and @name='min'][1]";
        WebElement priceFilter = driver.findElement(By.xpath(priceFilterXpath));
        priceFilter.sendKeys("2000");

        // Выбираем производителя
        String setVendorXpath = "//label[contains(text(),'A4Tech')]";
        WebElement setVendor = driver.findElement(By.xpath(setVendorXpath));
        setVendor.click();


        // Проверяем количество товаров на странице
        String productsOnPage = String.valueOf(driver.findElement(By.xpath("//div/span[@class='PaginationViewChanger_countSetter__count__65Dji' and contains(text(),'24')]")));
        Assert.assertTrue("Количество товаров не соответствует 24", productsOnPage.contains("24"));

        // Сохраняем наименование первого товара
        String findFirstProductNameXpath = "//div[text()[contains(.,'Клавиатура')]][1]";
        WebElement findFirstProductName = driver.findElement(By.xpath(findFirstProductNameXpath));
        String firstProductName = findFirstProductName.getText();

        System.out.println("Наименование первого товара: " + firstProductName);

        // Ищем по сохраненному наименованию
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.click();
        // Ждем пока строка поиска будет в фокусе, после чего вводим наименование товара
        waitTime.until(ExpectedConditions.attributeContains(searchBox,"class", "Input_focused"));
        searchBox.sendKeys(firstProductName);

        //Проверяем, что строка поиска заполнена
        waitTime.until(ExpectedConditions.attributeContains(searchBox, "value", firstProductName));
        Assert.assertTrue("Строка поиска не заполнена", searchBox.getAttribute("value").contains(firstProductName));

        //Выполняем поиск
        searchBox.sendKeys(Keys.ENTER);


        // Ожидаем результат поиска и проверяем количество товаров
        WebElement oneInResult = driver.findElement(By.xpath("//div[text()='Выбран 1 товар']"));
        Assert.assertTrue("Выбрано больше 1 товара", oneInResult.isDisplayed());

        // Проверяем соответствие наименования найденного товара ранее сохраненному
        String searchProductNameXpath = "//div[@title and text()[contains(.,'Клавиатура')]]";
        WebElement searchProductName = driver.findElement(By.xpath(searchProductNameXpath));
        String realProductName = searchProductName.getText();
        Assert.assertEquals("Наименование найденного товара не соответствует ранее сохраненному",firstProductName, realProductName);


    }


}