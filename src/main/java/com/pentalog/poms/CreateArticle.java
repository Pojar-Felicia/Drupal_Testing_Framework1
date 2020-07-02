package com.pentalog.poms;

import com.pentalog.controls.*;
import com.pentalog.core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateArticle extends AbstractPOM {

    public CreateArticle(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[@id='overlay-title']")
    WebTextBlock pageTitle;

    @FindBy(xpath = "//input[@id='edit-title']")
    WebTextInput titleInput;
    @FindBy(xpath = "//input[@id='edit-field-tags-und']")
    WebTextInput tagsInput;
    @FindBy(xpath = "//textarea[@id='edit-body-und-0-value']")
    WebTextInput bodyInput;
    @FindBy(xpath = "//select[@id='edit-body-und-0-format--2']")
    WebSelect textFormatSelect;
    @FindBy(xpath = "//input[@id='edit-field-image-und-0-upload']")
    WebTextInput browseInput;
    @FindBy(xpath = "//label[contains(text(),'Provide a menu link')]")
    WebCheckBox provideMenuChBox;
    @FindBy(xpath = "//textarea[@id='edit-menu-description']")
    WebTextInput descriptionInp;
    @FindBy(xpath = "//select[@id='edit-menu-parent']")
    WebSelect parentItemSelect;
    @FindBy(xpath = "//select[@id='edit-menu-weight']")
    WebSelect weightSelect;
    @FindBy(xpath = "//li[@class='vertical-tab-button last']//a")
    WebLink publishingOptionLnk;
    @FindBy(xpath = "//div[@class='form-item form-type-checkbox form-item-sticky']")
    WebCheckBox stickyAtTop;
    @FindBy(xpath = "//input[@id='edit-submit']")
    WebButton saveBtn;
    @FindBy(xpath = "//input[@id='edit-preview']")
    WebButton previewBtn;

    public void setTitle(String titleValue){
        titleInput.sendKeys(titleValue);
    }
    public void setTags(String tagsValue){
        tagsInput.sendKeys(tagsValue);
    }
    public void setBody(String bodyValue){
        bodyInput.sendKeysNoValidation(bodyValue);
    }
    public void setTextFormat(String visibleText){
        textFormatSelect.selectByVisibleText(visibleText);
    }
    public void setBrowseInput(String browseValue){
        browseInput.sendKeysNoValidation(browseValue);
    }
    public void clickOnProvideMenuChBox(){
        provideMenuChBox.click();
    }
    public void setDescription(String description){
        descriptionInp.sendKeysNoValidation(description);
    }
    public void chooseParentItem(String visibleTxt){
        parentItemSelect.selectByVisibleText(visibleTxt);
    }
    public void chooseWeight(String weightValue){
        weightSelect.selectByVisibleText(weightValue);
    }
    public void setPublishingOption(){
        publishingOptionLnk.click();
        stickyAtTop.click();
    }
    public void clickOnSaveBtn(){
        saveBtn.click();
    }
    public void clickOnPreviewBtn(){
        previewBtn.click();
    }
    public void createArticle(String title, String tags, String body, String txtFormatValue, String jpgTitle, String descriptionValue, String parentItemValue, String weightValue){
        setTitle(title);
        setTags(tags);
        setBody(body);
        setTextFormat(txtFormatValue);
        setBrowseInput(jpgTitle);
        clickOnProvideMenuChBox();
        setDescription(descriptionValue);
        chooseParentItem(parentItemValue);
        chooseWeight(weightValue);
        clickOnSaveBtn();
    }
}
