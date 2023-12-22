package com.yanin.framewok.tests;

import com.yanin.framewok.base.BaseTests;
import com.yanin.framework.pages.RegardCatalogPage;
import com.yanin.framework.pages.RegardStartPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegardAutomationOneTest extends BaseTests {

    private RegardStartPage regardStartPage;
    private RegardCatalogPage regardCatalogPage;

    @Before
    public void setUp() {
        regardStartPage = new RegardStartPage(driver);
        regardCatalogPage = new RegardCatalogPage(driver);
    }



    @Test
    public void test1() {


        // Открываем бургер-меню "Каталог"
        regardStartPage.openCatalogMenu();

        // Выбираем раздел каталога
        regardStartPage.selectSubCatalogByText("Комплектующие");

        // Выбираем категорию товаров
        regardCatalogPage.selectCategoryByText("Процессоры");

        //Задаем фильтр по цене
        regardCatalogPage.setMinPriceFilter("20000");

        //Задаем фильтр по производителю
        regardCatalogPage.setVendorByCheck("AMD");

        //Проверяем, что на странцие 24 записи
        regardCatalogPage.assertProductCountIs24();

        //Cохраняем наименование первого товара в списке
        regardCatalogPage.getFirstProductInList();
        //System.out.println("Наименование первого товара: " + regardCatalogPage.getFirstProductInList());

        //Ищем по сохраненному наименованию
        regardCatalogPage.searchForProduct(regardCatalogPage.getFirstProductInList());

    }



}