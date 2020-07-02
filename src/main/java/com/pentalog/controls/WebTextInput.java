package com.pentalog.controls;

import com.pentalog.core.LoggingAssert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class WebTextInput extends WebTypifiedElement {

    public WebTextInput(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public String sendKeys(String keyToSend) {
        System.out.printf("Introducing '%s' in '%s'%n", keyToSend, getName());
        clear();
        getWrappedElement().sendKeys(keyToSend);
        LoggingAssert.assertEquals(getText(), keyToSend);
        return keyToSend;
    }
    public String sendKeysNoValidation(String keyToSend) {
        System.out.printf("Introducing '%s' in '%s'%n", keyToSend, getName());
        clear();
        getWrappedElement().sendKeys(keyToSend);
        return keyToSend;
    }

    public String populateWithRandomAlphabeticString(int nrOfChars){
        String randomString = RandomStringUtils.randomAlphabetic(nrOfChars);
        sendKeys(randomString);
        return randomString;
    }

    @Override
    public void clear() {
//        getWrappedElement().clear();
    }

    @Override
    public String getText() {
        if ("textarea".equals(getWrappedElement().getTagName())) {
            return getWrappedElement().getText();
        }

        return Optional.ofNullable(getWrappedElement().getAttribute("value")).orElse("");
//    return getWrappedElement().getText();
    }
}
