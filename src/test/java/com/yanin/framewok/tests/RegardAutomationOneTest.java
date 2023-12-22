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


        // Открываем бургер-меню "Каталог"
        regardStartPage.openCatalogMenu();

        // Выбираем раздел каталога
        regardStartPage.selectSubCatalogByText("Комплектующие");

        //Проверяем выбран ли раздел каталог
        WebElement subCatalogLoad = driver.findElement(By.xpath("//div[@class='div page_title h1']"));
        waitTime.until(ExpectedConditions.attributeContains(subCatalogLoad, "class", "div page_title h1"));

        // Выбираем категорию товаров
        regardStartPage.selectCategoryByText("Процессоры");

    }



}