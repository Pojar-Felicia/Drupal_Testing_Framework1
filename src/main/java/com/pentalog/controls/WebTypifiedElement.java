package com.pentalog.controls;

import com.pentalog.core.LoggingAssert;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

public class WebTypifiedElement extends TypifiedElement {

    public WebTypifiedElement(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @SuppressWarnings("squid:S1166")
    // Sonar "Exception handlers should preserve the original exception" rule
    public boolean exists() {
        try {
            getWrappedElement().isDisplayed();
        } catch (NoSuchElementException ignored) {
            return false;
        }
        return true;
    }

    @Override
    public void click() {
        System.out.printf("Click on '%s'%n", getName());
        getWrappedElement().click();
    }

    @Override
    public void submit() {
        getWrappedElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        throw new RuntimeException("Illegable action");
    }

    @Override
    public void clear() {
        throw new RuntimeException("Illegable action");
    }

    @Override
    public String getTagName() {
        return getWrappedElement().getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return getWrappedElement().getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return getWrappedElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getWrappedElement().isEnabled();
    }

    @Override
    public String getText() {
        return getWrappedElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getWrappedElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getWrappedElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return getWrappedElement().isDisplayed();
    }

    public void isDisplayedAssertion(){
        LoggingAssert.assertTrue(isDisplayed(), String.format("'%s' is displayed", getName()));
    }

    @Override
    public Point getLocation() {
        return getWrappedElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return getWrappedElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return getWrappedElement().getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return getWrappedElement().getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) {
        return getWrappedElement().getScreenshotAs(target);
    }

    public String getXpath(){
        try {
            Object proxyOrigin = FieldUtils.readField(getWrappedElement(), "h", true);
            Object locator = FieldUtils.readField(proxyOrigin, "locator", true);
            Object findBy = FieldUtils.readField(locator, "by", true);
            Object xpath = FieldUtils.readField(findBy, "xpathExpression", true);
            if (findBy != null) {
                return xpath.toString();
            }
        } catch (IllegalAccessException ignored) {
        }
        return "[unknown]";
    }

    public WebDriver getDriver(){
        try {
            Object proxyOrigin = FieldUtils.readField(getWrappedElement(), "h", true);
            Object locator = FieldUtils.readField(proxyOrigin, "locator", true);
            Object searchContext = FieldUtils.readField(locator, "searchContext", true);
            Object locationContext = FieldUtils.readField(searchContext, "locationContext", true);
            Object executeMethod = FieldUtils.readField(locationContext, "executeMethod", true);
            Object driver = FieldUtils.readField(executeMethod, "driver", true);
            if (driver != null) {
                return (WebDriver) driver;
            }
        } catch (IllegalAccessException ignored) {
        }
        return null;
    }
}
