package com.yanin.framework.utils;

import com.yanin.framework.managers.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class  MyAllureListener extends AllureJunit4 {

    @Override
    public void testFailure(final Failure failure) {
        byte[] byteImage = ((TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
        getLifecycle().addAttachment("Screenshot", "image/png", "png", byteImage);
        super.testFailure(failure);

    }
}
