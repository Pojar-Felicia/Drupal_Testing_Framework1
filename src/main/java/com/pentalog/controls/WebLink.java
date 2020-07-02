package com.pentalog.controls;

import org.openqa.selenium.WebElement;

public class WebLink extends WebTypifiedElement {
    /**
     * Specifies wrapped {@link WebElement}.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public WebLink(WebElement wrappedElement) {
        super(wrappedElement);
    }

    /**
     * Retrieves reference from "href" attribute.
     *
     * @return Reference associated with hyperlink.
     */
    public String getReference() {
        return getWrappedElement().getAttribute("href");
    }
}
