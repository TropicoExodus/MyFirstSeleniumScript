package com.yanin.framework.pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegardStartPage {

    private WebDriver driver;
    private WebDriverWait waitTime;


    @FindBy(xpath = "//div[@class='NavigationBar_burger__j7lZE']")
    private WebElement baseCatalog;

    @FindBy(xpath = "//div//a/div[@class='Catalog_mainCategoryName__xzGxz']")
    private List<WebElement> subCatalog;

    @FindBy(xpath = "//div[@class='div page_title h1']")
    private WebElement subCatalogLoad;


    @FindBy(xpath = "//p[@class='CardCategory_title__K2CCX']")
    private List<WebElement> categoryCatalog;

    @FindBy(xpath = "//div[@class='ViewChanger_switcher__FpPel']")
    private WebElement categoryCatalogLoad;


    public RegardStartPage(WebDriver driver){
        this.driver = driver;
        waitTime = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public RegardStartPage openCatalogMenu() {
        baseCatalog.click();
        return this;
    }




    public void selectSubCatalogByText(String catalogMenu) {
        for (WebElement itemMenu: subCatalog) {
            if(itemMenu.getText().contains(catalogMenu)) {
                itemMenu.click();
                waitTime.until(ExpectedConditions.attributeContains(subCatalogLoad, "class", "div page_title h1"));
                return;
            }
        }

        Assert.fail("Меню с текстом " + catalogMenu + "не найдено в каталоге");
    }

    public void selectCategoryByText(String categoryMenu) {
        for (WebElement itemMenu: categoryCatalog) {
            if(itemMenu.getText().contains(categoryMenu)) {
                itemMenu.click();
                waitTime.until(ExpectedConditions.attributeContains(categoryCatalogLoad, "class", "ViewChanger_switcher__FpPel"));
                return;
            }
        }

        Assert.fail("Категория с текстом " + categoryMenu + "не найдено в каталоге");
    }

}
