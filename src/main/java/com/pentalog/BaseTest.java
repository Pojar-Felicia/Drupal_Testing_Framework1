package com.pentalog;


import com.pentalog.helpers.BrowserFactory;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("geckodriver", "geckodriver");
    }
    @BeforeMethod
    public void beforeMethod(){
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://dev-lallala-land.pantheonsite.io");
        driver = BrowserFactory.openBrowser("--start-maximized", "--disable-notifications");
        driver.get("https://dev-lallala-land.pantheonsite.io");
    }
    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            takeScreenshot();
        }
    }
    @AfterClass
    public void afterClass(){ quitCurrentDriver();
    }
    @SneakyThrows
    public void takeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("D://softwareTestingMaterial.png"));
    }
    protected void quitCurrentDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            System.err.println("Error closing the browser");
        }
    }
}
