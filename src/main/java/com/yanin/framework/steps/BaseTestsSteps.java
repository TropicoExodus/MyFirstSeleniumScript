package com.yanin.framework.steps;

import com.yanin.framework.managers.DriverManager;
import com.yanin.framework.managers.PageManager;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import org.junit.After;
import org.junit.Before;

public class BaseTestsSteps {
    private DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    @Before
    @Допустим("Переходим на главную страницу сайта")
    public void before() {

        driverManager.getDriver().get("http://regard.ru");

    }
    @After
    @И("закрываем браузер")
    public  void after() {
        driverManager.quitDriver();
    }

}