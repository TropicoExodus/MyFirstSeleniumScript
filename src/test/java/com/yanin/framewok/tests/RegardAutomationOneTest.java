package com.yanin.framewok.tests;

import com.yanin.framewok.base.BaseTests;
import com.yanin.framework.managers.DriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Test;

public class RegardAutomationOneTest extends BaseTests {





    @Test
    @DisplayName("Сценарий 1 - Видеокарты")
    public void test1() {


        pageManager.getRegardStartPage()
                .openCatalogMenu()
                .selectSubCatalogByText("Комплектующие для ПК")
                .selectCategoryByText("Видеокарты")
                .setMinPriceFilter("20000")
                .waitForFilterCountToUpdate()
                .setVendorByCheck("Gigabyte")
                .waitForFilterCountToUpdate()
                .checkProductCount()
                .searchForProduct()
                .waitForFindCountToUpdate()
                .checkItemCount()
                .checkFoundProductName(pageManager.getRegardCatalogPage().getFirstProductText());




    }

    @Test
    @DisplayName("Сценарий 2 - Клавиатуры")
    public void test2() {
        pageManager.getRegardStartPage()
                .openCatalogMenu()
                .selectSubCatalogByText("Периферия")
                .selectCategoryByText("Клавиатуры")
                .setMinPriceFilter("2000")
                .waitForFilterCountToUpdate()
                .setVendorByCheck("A4Tech")
                .waitForFilterCountToUpdate()
                .checkProductCount()
                .searchForProduct()
                .waitForFindCountToUpdate()
                .checkItemCount()
                .checkFoundProductName(pageManager.getRegardCatalogPage().getFirstProductText());
}


    @Test
    @DisplayName("Сценарий 3 - Ноутбуки")
    public void test3() {
        pageManager.getRegardStartPage()
                .openCatalogMenu()
                .selectSubCatalogByText("Компьютеры и ноутбуки")
                .selectCategoryByText("Ноутбуки")
                .setMinPriceFilter("70000")
                .waitForFilterCountToUpdate()
                .setVendorByCheck("ASUS")
                .waitForFilterCountToUpdate()
                .checkProductCount()
                .searchForProduct()
                .waitForFindCountToUpdate()
                .checkItemCount()
                .checkFoundProductName(pageManager.getRegardCatalogPage().getFirstProductText());
    }

@AfterClass
    public static void TearDown() {
    DriverManager.getInstance().quitDriver();
}
}
