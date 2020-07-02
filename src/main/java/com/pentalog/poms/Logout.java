package com.pentalog.poms;

import com.pentalog.controls.WebButton;
import com.pentalog.controls.WebTextBlock;
import com.pentalog.core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Logout extends AbstractPOM {
    public Logout(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//li[@class='logout last']//a[contains(text(),'Log out')]")
    WebButton logout;
    @FindBy(xpath = "//h2[contains(text(),'User login')]")
    WebTextBlock userLoginTxt;

    public void userLogout(){
        logout.click();
        Assert.assertTrue(userLoginTxt.isDisplayed());
    }


}
