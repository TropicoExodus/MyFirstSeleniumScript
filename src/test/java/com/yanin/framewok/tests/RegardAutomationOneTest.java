package com.yanin.framewok.tests;

import com.yanin.framewok.base.BaseTests;
import com.yanin.framework.managers.DriverManager;
import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.Test;

public class RegardAutomationOneTest extends BaseTests {





    @Test
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
    @Step("")
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
    DriverManager.getInstance().getDriver();
}
}
