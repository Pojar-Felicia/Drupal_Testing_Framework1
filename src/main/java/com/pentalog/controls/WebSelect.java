package com.pentalog.controls;

import com.pentalog.core.LoggingAssert;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class WebSelect extends WebTypifiedElement {
    /**
     * Specifies wrapped {@link WebElement}.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public WebSelect(WebElement wrappedElement) {
        super(wrappedElement);
    }


    /**
     * Constructs instance of {@link org.openqa.selenium.support.ui.Select} class.
     *
     * @return {@link org.openqa.selenium.support.ui.Select} class instance.
     */
    private org.openqa.selenium.support.ui.Select getSelect() {
        return new org.openqa.selenium.support.ui.Select(getWrappedElement());
    }

    public String selectRandom(){
        System.out.printf("Select random value for %s%n", getName());
        SecureRandom random = new SecureRandom();
        int index = random.nextInt(getOptions().size());
        String value = getOptions().get(index).getText();
        selectByVisibleText(value);
        return value;
    }

    /**
     * Indicates whether this select element support selecting multiple options at the same time.
     * This is done by checking the value of the "multiple" attribute.
     *
     * @return {@code true} if select element support selecting multiple options and {@code false} otherwise.
     */
    public boolean isMultiple() {
        return getSelect().isMultiple();
    }

    /**
     * Returns all options belonging to this select tag.
     *
     * @return A list of {@code WebElements} representing options.
     */
    public List<WebElement> getOptions() {
        return getSelect().getOptions();
    }

    /**
     * Returns all selected options belonging to this select tag.
     *
     * @return A list of {@code WebElements} representing selected options.
     */
    public List<WebElement> getAllSelectedOptions() {
        return getSelect().getAllSelectedOptions();
    }

    /**
     * The first selected option in this select tag (or the currently selected option in a normal select).
     *
     * @return A {@code WebElement} representing selected option.
     */
    public WebElement getFirstSelectedOption() {
        return getSelect().getFirstSelectedOption();
    }

    /**
     * Indicates if select has at least one selected option.
     *
     * @return {@code true} if select has at least one selected option and {@code false} otherwise.
     */
    public boolean hasSelectedOption() {
        return getOptions().stream().anyMatch(WebElement::isSelected);
    }

    /**
     * Select all options that display text matching the argument. That is, when given "Bar" this
     * would select an option like:
     * <p/>
     * &lt;option value="foo"&gt;Bar&lt;/option&gt;
     *
     * @param text The visible text to match against
     */
    public void selectByVisibleText(String text) {
        System.out.printf("Select '%s' value for %s%n", text, getName());
        getSelect().selectByVisibleText(text);
        LoggingAssert.assertEquals(getFirstSelectedOption().getText(), text);
    }

    /**
     * Select the option at the given index. This is done by examining the "index" attribute of an
     * element, and not merely by counting.
     *
     * @param index The option at this index will be selected
     */
    public void selectByIndex(int index) {
        getSelect().selectByIndex(index);
    }

    /**
     * Select all options that have a value matching the argument. That is, when given "foo" this
     * would select an option like:
     * <p/>
     * &lt;option value="foo"&gt;Bar&lt;/option&gt;
     *
     * @param value The value to match against
     */
    public void selectByValue(String value) {
        getSelect().selectByValue(value);
    }

    /**
     * Clear all selected entries. This is only valid when the SELECT supports multiple selections.
     *
     * @throws UnsupportedOperationException If the SELECT does not support multiple selections
     */
    public void deselectAll() {
        getSelect().deselectAll();
    }

    /**
     * Deselect all options that have a value matching the argument. That is, when given "foo" this
     * would deselect an option like:
     * <p/>
     * &lt;option value="foo"&gt;Bar&lt;/option&gt;
     *
     * @param value The value to match against
     */
    public void deselectByValue(String value) {
        getSelect().deselectByValue(value);
    }

    /**
     * Deselect the option at the given index. This is done by examining the "index" attribute of an
     * element, and not merely by counting.
     *
     * @param index The option at this index will be deselected
     */
    public void deselectByIndex(int index) {
        getSelect().deselectByIndex(index);
    }

    /**
     * Deselect all options that display text matching the argument. That is, when given "Bar" this
     * would deselect an option like:
     * <p/>
     * &lt;option value="foo"&gt;Bar&lt;/option&gt;
     *
     * @param text The visible text to match against
     */
    public void deselectByVisibleText(String text) {
        getSelect().deselectByVisibleText(text);
    }
}
