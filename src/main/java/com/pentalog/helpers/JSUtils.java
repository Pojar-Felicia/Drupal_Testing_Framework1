package com.pentalog.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class JSUtils {
    public static Object executeJavaScript(WebDriver driver, String script, WebElement... elements) {
        return ((JavascriptExecutor) driver).executeScript(script, elements);
    }
}