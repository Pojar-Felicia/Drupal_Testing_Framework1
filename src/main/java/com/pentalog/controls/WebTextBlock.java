package com.pentalog.controls;

import org.openqa.selenium.WebElement;

public class WebTextBlock extends WebTypifiedElement {
    /**
     * Specifies wrapped {@link WebElement}.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public WebTextBlock(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
