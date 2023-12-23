package com.yanin.framewok.base;

import com.yanin.framework.managers.DriverManager;
import com.yanin.framework.managers.PageManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    @Before
    public void before() {

        driverManager.getDriver().get("http://regard.ru");

    }
 @After
public void after(){
     driverManager.getDriver().quit();
   }
}