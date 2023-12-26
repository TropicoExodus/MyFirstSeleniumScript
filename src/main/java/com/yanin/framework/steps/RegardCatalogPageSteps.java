package com.yanin.framework.steps;

import com.yanin.framework.managers.PageManager;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class RegardCatalogPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("^Выбираем категорию \"(.+)\" в разделе$")
    public void selectCategoryByText (String categoryMenu) {
        pageManager.getRegardCatalogPage().selectCategoryByText(categoryMenu);
    }

    @И("^Вводим значение цены мин От \"(.*)\" рублей$")
    public  void setMinPriceFilter (String priceValue) {
        pageManager.getRegardCatalogPage().setMinPriceFilter(priceValue);
    }

    @И("^выбираем производителя \"(.+)\"$")
    public void setVendorByCheck (String vendorByCheck) {
        pageManager.getRegardCatalogPage().setVendorByCheck(vendorByCheck);
    }

    @Тогда("^происходит ожидание обновления числа товаров, соответствующих фильтру$")
    public void waitForFilterCountToUpdate () {
        pageManager.getRegardCatalogPage().waitForFilterCountToUpdate();
    }

    @И("^проверяется количество товаров на странице$")
    public void checkProductCount () {
        pageManager.getRegardCatalogPage().checkProductCount();
    }

    @Когда("^сохраняем наименование первого товара из списка$")
    public void getFirstProductText () {
        pageManager.getRegardCatalogPage().getFirstProductText();
    }

    @Тогда("^выполняем поиск первого товара из списка$")
    public void searchForProduct() {
        pageManager.getRegardCatalogPage().searchForProduct();
    }
}
