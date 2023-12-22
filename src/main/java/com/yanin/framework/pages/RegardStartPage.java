package com.yanin.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegardStartPage {


    @FindBy(xpath = "//div[@class='NavigationBar_burger__j7lZE']")
    private WebElement baseCatalog;

    @FindBy(xpath = "//div//a/div[@class='Catalog_mainCategoryName__xzGxz']")
    private List<WebElement> subCatalog;


    @FindBy(xpath = "//p[@class='CardCategory_title__K2CCX']")
    private List<WebElement> categoryCatalog;



    public RegardStartPage openCatalogMenu() {
        baseCatalog.click();
        return this;
    }




    public void selectSubCatalogByText(String catalogMenu) {

        for (WebElement itemMenu: subCatalog) {
            if(itemMenu.getText().contains(catalogMenu)) {
                itemMenu.click();
                return;
            }
        }

        Assert.fail("Меню с текстом " + catalogMenu + "не найдено в каталоге");
    }

    public void selectCategoryByText(String categoryMenu) {

        for (WebElement itemMenu: categoryCatalog) {
            if(itemMenu.getText().contains(categoryMenu)) {
                itemMenu.click();
                return;
            }
        }

        Assert.fail("Категория с текстом " + categoryMenu + "не найдено в каталоге");
    }



}
