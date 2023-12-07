package com.yanin.practie;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;
public class PrecticeCase1 {
    WebDriver chromeDriver;
    WebDriverWait wait;

    @Before
    public void before() {
        // WebDriver path
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chromeDriver = new ChromeDriver();

        wait = new WebDriverWait(chromeDriver, 10, 2000);
        chromeDriver.get("https://training.appline.ru/user/login");
    }

    @Test
    public void practice1() {
    }
}
