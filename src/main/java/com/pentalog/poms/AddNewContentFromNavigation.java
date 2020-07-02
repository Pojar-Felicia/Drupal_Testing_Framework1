package com.pentalog.poms;

import com.pentalog.controls.WebLink;
import com.pentalog.core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class AddNewContentFromNavigation extends AbstractPOM {

    public AddNewContentFromNavigation(WebDriver driver){

        super(driver);
    }

    @FindBy(xpath ="//li[@class='first last collapsed']//a[contains(text(),'Add content')]")
    WebLink addNewContentLink;

    @FindBy(xpath = "//a[contains(text(),'Article')]")
    WebLink articleLink;

    public void clickOnAddNewContent(){
        addNewContentLink.click();
    }

    public void clickOnArticleLink(){
        articleLink.click();
    }
}
