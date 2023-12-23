package com.yanin.framework.managers;

import com.yanin.framework.pages.RegardCatalogPage;
import com.yanin.framework.pages.RegardFindResultPage;
import com.yanin.framework.pages.RegardStartPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    private static PageManager pageManager;
    private RegardStartPage regardStartPage;
    private RegardCatalogPage regardCatalogPage;
    private RegardFindResultPage regardFindResultPage;



    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public RegardStartPage getRegardStartPage() {
        if (regardStartPage == null) {
            regardStartPage = new RegardStartPage();
        }
        return regardStartPage;
    }


    public RegardCatalogPage getRegardCatalogPage() {
        if (regardCatalogPage == null) {
            regardCatalogPage = new RegardCatalogPage();
        }
        return regardCatalogPage;
    }


    public RegardFindResultPage getRegardFindResultPage() {
        if (regardFindResultPage == null) {
            regardFindResultPage = new RegardFindResultPage();
        }
        return regardFindResultPage;
    }
}
