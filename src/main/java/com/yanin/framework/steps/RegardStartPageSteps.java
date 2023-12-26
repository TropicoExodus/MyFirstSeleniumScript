package com.yanin.framework.steps;

import com.yanin.framework.managers.PageManager;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class RegardStartPageSteps {
        PageManager pageManager = PageManager.getInstance();

        @Когда("^Открываем бургер-меню$")
        public void openCatalogMenu() {
            pageManager.getRegardStartPage().openCatalogMenu();
        }

        @Тогда("^Открываем раздел \"(.+)\" в каталоге и показываем ошибку, если он не найден$")
        public void selectSubCatalogByText(String catalogMenu) {
            pageManager.getRegardStartPage().selectSubCatalogByText(catalogMenu);
        }

}
