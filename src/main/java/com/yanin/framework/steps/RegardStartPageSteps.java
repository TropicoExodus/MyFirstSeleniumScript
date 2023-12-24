package com.yanin.framework.steps;

import com.yanin.framework.managers.PageManager;
import io.cucumber.java.ru.И;

public class RegardStartPageSteps {
        PageManager pageManager = PageManager.getInstance();

        @И("Открываем бургер-меню")
        public void openCatalogMenu() {
            pageManager.getRegardStartPage().openCatalogMenu();
        }

        @И("Открываем категорию {String}")
        public void selectSubCatalogByText(String catalogMenu) {
            pageManager.getRegardStartPage().selectSubCatalogByText(catalogMenu);
        }

}
