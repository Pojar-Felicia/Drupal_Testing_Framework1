package com.pentalog.poms;

import com.pentalog.controls.WebButton;
import com.pentalog.controls.WebLink;
import com.pentalog.controls.WebTextBlock;
import com.pentalog.controls.WebTextInput;
import com.pentalog.core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NewAccount extends AbstractPOM {
    public NewAccount(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[contains(text(),'User login')]")
    WebTextBlock userLoginTxt;
    @FindBy(xpath = "//a[contains(text(),'Create new account')]")
    WebLink newAccountLink;
    @FindBy(xpath = "//h1[@id='page-title']")
    WebTextBlock pageTitle;
    @FindBy(xpath = "//input[@id='edit-name']")
    WebTextInput usernameInput;
    @FindBy(xpath = "//input[@id='edit-mail']")
    WebTextInput passwordInput;
    @FindBy(xpath = "//input[@id='edit-submit']")
    WebButton createNewAccountBtn;
    @FindBy(xpath = "//h1[@id='page-title']")
    WebTextBlock pageUserAcountTitle;
    @FindBy(xpath = "//div[@class='messages status']")
    WebTextBlock messageStatus;

    public void clickOnCreateNewAccount(){
    newAccountLink.click();
}
    public void setUsername(String usernameValue){
        usernameInput.sendKeys(usernameValue);
    }
    public void setPassword(String passwordValue){
        passwordInput.sendKeys(passwordValue);
    }
    public void clickLogin(){
        createNewAccountBtn.click();
    }

    public void setNewAccount(String userName, String password){
        Assert.assertTrue(userLoginTxt.isDisplayed());
        clickOnCreateNewAccount();
        Assert.assertTrue(pageUserAcountTitle.isDisplayed());
        setUsername(userName);
        setPassword(password);
        clickLogin();
        Assert.assertTrue(messageStatus.isDisplayed());
    }


}