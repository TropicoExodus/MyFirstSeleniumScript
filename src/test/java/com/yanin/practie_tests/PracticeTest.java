package com.yanin.practie_tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeTest {
    WebDriver chromeDriver;
    WebDriverWait waitTime;

    @Before
    public void before() {
        // WebDriver path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chromeDriver = new ChromeDriver();

        waitTime = new WebDriverWait(chromeDriver, 5, 1000);
        chromeDriver.get("https://training.appline.ru/user/login");
    }

    @Test
    public void practiceOne() {

//Авторизация

        //ввод логина
        String EnterLoginOnSite = "//input[@id='prependedInput' and @name='_username']";
        WebElement inputLogin = chromeDriver.findElement(By.xpath(EnterLoginOnSite));
        inputLogin.click();
        inputLogin.sendKeys("Секретарь");

        //ввод пароля
        String EnterPassOnSite = "//input[@id='prependedInput2' and @name='_password']";
        WebElement inputPass = chromeDriver.findElement(By.xpath(EnterPassOnSite));
        inputPass.click();
        inputPass.sendKeys("testing");

        //вход
        String LoginOnSite = "//button[@type='submit']";
        WebElement login = chromeDriver.findElement(By.xpath(LoginOnSite));
        login.click();
    }
}
