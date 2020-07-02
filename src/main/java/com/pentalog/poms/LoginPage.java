package com.pentalog.poms;

import com.pentalog.controls.WebButton;
import com.pentalog.controls.WebTextBlock;
import com.pentalog.controls.WebTextInput;
import com.pentalog.core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends AbstractPOM {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Lallala Land')]")
    WebTextBlock pageTitle;

    @FindBy(xpath = "//input[@id='edit-name']")
    WebTextInput usernameInput;

    @FindBy(xpath = "//input[@id='edit-pass']")
    WebTextInput passwordInput;

    @FindBy(xpath = "//input[@id='edit-submit']")
    WebButton submitButton;

    @FindBy(xpath = "//a[contains(text(),'Hello')]")
    WebTextBlock helloUser;


    public void checkPageTitle(){
        Assert.assertTrue(pageTitle.isDisplayed(), "Page header is displayed");
    }

    protected void setUsername(String usernameValue){
        usernameInput.sendKeys(usernameValue);
    }
    protected void setPassword(String passwordValue){
        passwordInput.sendKeys(passwordValue);
    }
    protected void clickLogin(){
        submitButton.click();
    }

    public void login(String username, String password){
        checkPageTitle();
        setUsername(username);
        setPassword(password);
        clickLogin();
        Assert.assertEquals(helloUser.getText(), "Hello " + username);
    }
}
