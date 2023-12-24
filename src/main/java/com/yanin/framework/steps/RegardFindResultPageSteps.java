package com.yanin.framework.steps;

import com.yanin.framework.managers.PageManager;
import io.cucumber.java.ru.И;

public class RegardFindResultPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Ждем загрузки результатов поиска")
    public void waitForFindCountToUpdate () {
        pageManager.getRegardFindResultPage().waitForFindCountToUpdate();
    }

    @И("Проверяем количество товаров в поисковой выдаче")
    public void checkItemCount () {
        pageManager.getRegardFindResultPage().checkItemCount();
    }

    @И("Проверяем название найденного товара")
    public void checkFoundProductName (String getFirstProductText) {
        pageManager.getRegardCatalogPage().getFirstProductText();
    }

}


