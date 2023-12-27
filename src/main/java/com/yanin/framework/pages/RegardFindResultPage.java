package com.yanin.framework.pages;


import com.yanin.framework.managers.DriverManager;
import com.yanin.framework.managers.PageManager;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegardFindResultPage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait waitTime = new WebDriverWait(driverManager.getDriver(), 10,1000);
    protected PageManager pageManager = PageManager.getInstance();


    @FindBy(xpath = "//div[@class='ListingFilters_filterMeta__nF_BZ']")
    private WebElement findCountElement;

    @FindBy (xpath = "//div/a/div[@title]")
    private  WebElement findedItem;



    public RegardFindResultPage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public RegardFindResultPage waitForFindCountToUpdate() {
        String oldCount = findCountElement.getText();
        waitTime.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(findCountElement, oldCount)));
        return pageManager.getRegardFindResultPage();
    }
    @Step("Проверяем количество товаров в поисковой выдаче")
    public RegardFindResultPage checkItemCount() {
        String filterText = findCountElement.getText();
        Matcher matcher = Pattern.compile("\\d+").matcher(filterText);
        if (matcher.find()) {
            int itemCount = Integer.parseInt(matcher.group());
            Assert.assertTrue("Количество товаров отличается от 1", itemCount <= 1);
        } else {
            Assert.fail("Не удалось найти количество товаров в в поисковой выдаче");
        }
        return pageManager.getRegardFindResultPage();
    }

//    public String getFoundProductName() {
//        waitTime.until(ExpectedConditions.visibilityOf(findedItem));
//        return findedItem.getAttribute("title");
//    }
    @Step("Проверяем соответствие найденного товара ранее сохраненному")
    public RegardFindResultPage checkFoundProductName(String expectedProductName) {
        String actualProductName = findedItem.getAttribute("title");
        Assert.assertEquals("Наименование найденного товара не соответствует ожидаемому", expectedProductName, actualProductName);
        return pageManager.getRegardFindResultPage();
    }



}