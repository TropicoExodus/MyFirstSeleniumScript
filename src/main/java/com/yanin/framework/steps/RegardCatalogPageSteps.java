package com.yanin.framework.steps;

import com.yanin.framework.managers.PageManager;
import io.cucumber.java.ru.И;

public class RegardCatalogPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Выбираем категорию {'categoryMenu'}")
    public void selectCategoryByText (String categoryMenu) {
        pageManager.getRegardCatalogPage().selectCategoryByText(categoryMenu);
    }

    @И("Вводим значение цены мин {'priceValue'}")
    public  void setMinPriceFilter (String priceValue) {
        pageManager.getRegardCatalogPage().setMinPriceFilter(priceValue);
    }

    @И(" Выбираем производителя {'vendorCheckbox'}")
    public void setVendorByCheck (String vendorByCheck) {
        pageManager.getRegardCatalogPage().setVendorByCheck(vendorByCheck);
    }

    @И("Проверяем загрузку после фильтрации")
    public void waitForFilterCountToUpdate () {
        pageManager.getRegardCatalogPage().waitForFilterCountToUpdate();
    }

    @И("Проверяем количество товаров на странице")
    public void checkProductCount () {
        pageManager.getRegardCatalogPage().checkProductCount();
    }

    @И("Сохраняем наименование первого товара из списка {'getFirstProductText'}")
    public void getFirstProductText () {
        pageManager.getRegardCatalogPage().getFirstProductText();
    }

    @И("Выполняем поиск первого товара из списка")
    public void searchForProduct() {
        pageManager.getRegardCatalogPage().searchForProduct();
    }
}
