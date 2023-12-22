package com.yanin.framewok.tests;

import com.yanin.framewok.base.BaseTests;
import com.yanin.framework.pages.RegardStartPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegardAutomationOneTest extends BaseTests {

    RegardStartPage regardStartPage = new RegardStartPage();


    @Test
    public void test1() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Открываем бургер-меню "Каталог"
        regardStartPage.openCatalogMenu();

        // Выбираем раздел каталога
        regardStartPage.selectSubCatalogByText("Комплектующие");

        //Проверяем, выбран ли раздел каталог
        WebElement subCatalogLoad = driver.findElement(By.xpath("//div[@class='div page_title h1']"));
        waitTime.until(ExpectedConditions.attributeContains(subCatalogLoad, "class", "div page_title h1"));

        // Выбираем категорию товаров
        regardStartPage.selectCategoryByText("Процессоры");

        // Задаем фильтр по цене
        String priceFilterXpath = "//div/input[@class='RangeSelector_input__26nqz range-selector-input' and @name='min'][1]";
        WebElement priceFilter = driver.findElement(By.xpath(priceFilterXpath));
        priceFilter.sendKeys("2000");

        // Выбираем производителя
        String setVendorXpath = "//label[contains(text(),'Intel')]";
        WebElement setVendor = driver.findElement(By.xpath(setVendorXpath));
        setVendor.click();


        // Проверяем количество товаров на странице
        String productsOnPage = String.valueOf(driver.findElement(By.xpath("//div/span[@class='PaginationViewChanger_countSetter__count__65Dji' and contains(text(),'24')]")));
        Assert.assertTrue("Количество товаров не соответствует 24", productsOnPage.contains("24"));

        // Сохраняем наименование первого товара
        String findFirstProductNameXpath = "//div[text()[contains(.,'Процессор')]][1]";
        WebElement findFirstProductName = driver.findElement(By.xpath(findFirstProductNameXpath));
        String firstProductName = findFirstProductName.getText();

        System.out.println("Наименование первого товара: " + firstProductName);

        // Ищем по сохраненному наименованию
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.click();
        // Ждем пока строка поиска будет в фокусе
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
        String searchProductNameXpath = "//div[@title and text()[contains(.,'Процессор')]]";
        WebElement searchProductName = driver.findElement(By.xpath(searchProductNameXpath));
        String realProductName = searchProductName.getText();
        Assert.assertEquals("Наименование найденного товара не соответствует ранее сохраненному",firstProductName, realProductName);


    }



}