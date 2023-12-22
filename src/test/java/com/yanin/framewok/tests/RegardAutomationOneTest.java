package com.yanin.framewok.tests;

import com.yanin.framewok.base.BaseTests;
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
//    private RegardStartPage regardStartPage = new RegardStartPage();

    @Before
    public void setUp() {
        regardStartPage = new RegardStartPage(driver);
    }



    @Test
    public void test1() {


        // Открываем бургер-меню "Каталог"
        regardStartPage.openCatalogMenu();

        // Выбираем раздел каталога
        regardStartPage.selectSubCatalogByText("Комплектующие");


        // Выбираем категорию товаров
        regardStartPage.selectCategoryByText("Процессоры");

    }



}