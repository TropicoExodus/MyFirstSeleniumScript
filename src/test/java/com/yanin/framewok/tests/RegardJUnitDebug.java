package com.yanin.framewok.tests;

import com.yanin.framewok.base.BaseTests;
import com.yanin.framework.pages.RegardCatalogPage;
import com.yanin.framework.pages.RegardFindResultPage;
import com.yanin.framework.pages.RegardStartPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegardJUnitDebug extends BaseTests {





    @Test
    public void test2() {



        // Открываем бургер-меню "Каталог"
        pageManager.getRegardStartPage().openCatalogMenu();

        // Выбираем раздел каталога
        pageManager.getRegardStartPage().selectSubCatalogByText("Периферия");

        // Выбираем категорию товаров
        pageManager.getRegardCatalogPage().selectCategoryByText("Клавиатуры");


        //Задаем фильтр по цене
        pageManager.getRegardCatalogPage().setMinPriceFilter ("2000");

        // Ждем обновления количества товаров после фильтрации
        pageManager.getRegardCatalogPage().waitForFilterCountToUpdate();

        //Задаем фильтр по производителю
        pageManager.getRegardCatalogPage().setVendorByCheck("A4Tech");

        // Ждем обновления количества товаров после фильтрации
        pageManager.getRegardCatalogPage().waitForFilterCountToUpdate();

        //Проверяем, что на странцие 24 записи
        pageManager.getRegardCatalogPage().checkProductCount();

        //Cохраняем наименование первого товара в списке
        pageManager.getRegardCatalogPage().getFirstProductText();
        //System.out.println("Наименование первого товара: " + regardCatalogPage.getFirstProductInList());

        //Ищем по сохраненному наименованию
        pageManager.getRegardCatalogPage().searchForProduct();

        //Проверяем, что результаты поиска загружены
        pageManager.getRegardFindResultPage().waitForFindCountToUpdate();

        //Проверяем количество найденных товаров
        pageManager.getRegardFindResultPage().checkItemCount();

        //Проверяем соответствие найденного наименования искомому
        pageManager.getRegardFindResultPage().checkFoundProductName(pageManager.getRegardCatalogPage().getFirstProductText());



    }



}