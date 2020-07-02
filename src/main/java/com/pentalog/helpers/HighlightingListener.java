package com.pentalog.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.pentalog.helpers.JSUtils.executeJavaScript;

public class HighlightingListener extends AbstractWebDriverEventListener {
        private static WebElement previousElement = null;

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        // TODO 11/02/2020: if element == null and by is empty then we can show HUGE 'not found' text across the page!
        highlightElement(driver, element);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        highlightElement( driver, element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        highlightElement( driver, element);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        highlightElement( driver, element);
    }

        public static void highlightElement(WebDriver driver, WebElement element) {
            if (previousElement != null)
                unhighlightElement(driver, previousElement);
            try {
                if (element != null) {
                    previousElement = element;
                    executeJavaScript(driver, "arguments[0].style.border='3px solid red'", element);
                }
            } catch (StaleElementReferenceException | TimeoutException e) {
                // we don't care if element is already not shown or takes too much time to highlight.
            } catch (Exception e) {
                System.err.printf("Unable to unhighlight an element %s", e);
            }
        }

        public static void unhighlightElement(WebDriver driver, WebElement element) {
            try {
                if (element != null) {
                    executeJavaScript(driver, "arguments[0].style.removeProperty('border');", element);
                }
            } catch (StaleElementReferenceException | TimeoutException e) {
                // we don't care if element is already not shown or takes too much time to unhighlight.
            } catch (Exception e) {
                System.err.printf("Unable to unhighlight an element %s", e);
            }
        }
}

