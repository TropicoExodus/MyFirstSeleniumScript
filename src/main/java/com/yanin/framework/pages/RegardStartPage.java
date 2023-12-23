package com.yanin.framework.pages;


import com.yanin.framework.managers.DriverManager;
import com.yanin.framework.managers.PageManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegardStartPage {

    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait waitTime = new  WebDriverWait(driverManager.getDriver(), 10,1000);
    protected PageManager pageManager = PageManager.getInstance();


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


    public RegardStartPage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public RegardStartPage openCatalogMenu() {
        baseCatalog.click();
        return pageManager.getRegardStartPage();
    }




    public RegardCatalogPage selectSubCatalogByText(String catalogMenu) {
        for (WebElement itemMenu: subCatalog) {
            if(itemMenu.getText().contains(catalogMenu)) {
                itemMenu.click();
                waitTime.until(ExpectedConditions.attributeContains(subCatalogLoad, "class", "div page_title h1"));
                return pageManager.getRegardCatalogPage();
            }
        }

        Assert.fail("Меню с текстом " + catalogMenu + " не найдено в каталоге");
        return pageManager.getRegardCatalogPage();
    }



}
