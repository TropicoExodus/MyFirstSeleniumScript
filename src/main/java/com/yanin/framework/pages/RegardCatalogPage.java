package com.yanin.framework.pages;


import com.yanin.framework.managers.DriverManager;
import com.yanin.framework.managers.PageManager;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegardCatalogPage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait waitTime = new WebDriverWait(driverManager.getDriver(), 10,1000);
    protected PageManager pageManager = PageManager.getInstance();




    @FindBy(xpath = "//p[@class='CardCategory_title__K2CCX']")
    private List<WebElement> categoryCatalog;

    @FindBy(xpath = "//div[@class='ViewChanger_switcher__FpPel']")
    private WebElement categoryCatalogLoad;

    @FindBy(xpath = "//div/input[@class='RangeSelector_input__26nqz range-selector-input' and @name='min']")
    private WebElement minPriceInput;

    @FindBy(xpath = "//div//span[@class='Checkbox_label__92ZaL Checkbox_checkStart__jjKD1']")
    private List<WebElement> setVendor;

    @FindBy(xpath = "//div//span/input[@class='Checkbox_input__8gO3q Checkbox_checked__LL5S5 Checkbox_checkStart__jjKD1']")
    private WebElement setVendorChecked;

//    @FindBy(xpath = "//div/span[@class='PaginationViewChanger_countSetter__count__65Dji']")
    @FindBy(xpath = "//div/a[@class='CardText_link__C_fPZ link_black']")
    private List<WebElement> productsCountElement;

    @FindBy(xpath = "//div/div/a/div[@class='CardText_title__7bSbO CardText_listing__6mqXC']")
    private WebElement firstProductInList;

    @FindBy(id = "searchInput")
    private WebElement searchString;

    @FindBy(xpath = "//div[@class='ListingFilters_filterMeta__nF_BZ']")
    private WebElement filterCountElement;








    public RegardCatalogPage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }
    @Step("Выбираем категорию {'categoryMenu'}")
    public RegardCatalogPage selectCategoryByText(String categoryMenu) {
        for (WebElement itemMenu : categoryCatalog) {
            if (itemMenu.getText().contains(categoryMenu)) {
                itemMenu.click();
                waitTime.until(ExpectedConditions.attributeContains(categoryCatalogLoad, "class", "ViewChanger_switcher__FpPel"));
                return pageManager.getRegardCatalogPage();

            }
        }
            return pageManager.getRegardCatalogPage();
        }



    @Step("Вводим значение цены мин От {'priceValue'} рублей")
    public RegardCatalogPage setMinPriceFilter(String priceValue) {
        waitTime.until(ExpectedConditions.visibilityOf(minPriceInput));
        minPriceInput.click();
        minPriceInput.clear();
        minPriceInput.sendKeys(priceValue);

        // Проверяем, что значение введено корректно
        waitTime.until(ExpectedConditions.attributeToBe(minPriceInput, "value", priceValue));
        return pageManager.getRegardCatalogPage();
    }
    @Step("Выбираем производителя {'vendorCheckbox'}")
    public RegardCatalogPage setVendorByCheck(String vendorCheckbox) {
        for (WebElement itemMenu: setVendor) {
            if(itemMenu.getText().contains(vendorCheckbox)) {
                itemMenu.click();
                waitTime.until(ExpectedConditions.attributeContains(setVendorChecked, "class", "Checkbox_input__8gO3q Checkbox_checked__LL5S5 Checkbox_checkStart__jjKD1"));
                return pageManager.getRegardCatalogPage();
            }
        }

        return pageManager.getRegardCatalogPage();
    }

    @Step ("Ожмдаем загрузки после применения фильтрации")
    public RegardCatalogPage waitForFilterCountToUpdate() {
        String oldCount = filterCountElement.getText();
        waitTime.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(filterCountElement, oldCount)));
        return pageManager.getRegardCatalogPage();
    }


    public RegardCatalogPage checkProductCount() {
        Assert.assertTrue("Количество продуктов превышает 24.", productsCountElement.size() <= 24);
        return pageManager.getRegardCatalogPage();

    }


    @Step("Сохраняем наименование первого товара в списке {'getFirstProductText'}")
    public String getFirstProductText() {
        waitTime.until(ExpectedConditions.visibilityOf(firstProductInList));
        return firstProductInList.getText();

    }
    @Step("Выполняем поиск товара {'getFirstProductText'}")
    public RegardFindResultPage searchForProduct() {
        String productName = getFirstProductText();
        searchString.click();

        waitTime.until(ExpectedConditions.attributeContains(searchString, "class", "Input_focused"));
        searchString.sendKeys(productName);

        // Проверка, что строка поиска заполнена введенным названием товара
        waitTime.until(ExpectedConditions.attributeToBe(searchString, "value", productName));
        Assert.assertTrue("Строка поиска не заполнена", searchString.getAttribute("value").contains(productName));

        searchString.sendKeys(Keys.ENTER);
        return pageManager.getRegardFindResultPage();
    }
}

