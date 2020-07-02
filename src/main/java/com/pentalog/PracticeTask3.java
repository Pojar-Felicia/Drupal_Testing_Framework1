//package com.pentalog;
//
//import org.apache.commons.lang3.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class PracticeTask3 {
//
//    @Test
//    public void test() throws InterruptedException {
//        WebDriver driver = new FirefoxDriver();
//
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.get("https://www.google.com");
//
//        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
//        element.sendKeys("Cheetah");
//        element.submit();
//        System.out.println("Page title is: " +driver.getTitle());
//        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver d){
//            return d.getTitle().toLowerCase().startsWith("cheetah");
//        }
//        });
//        List<WebElement> links = driver.findElements(By.xpath("//div[h2[not(contains(text(),'People also ask'))]]//div[@class]='r'//a[contains]"));
//        List<String> nameLinks = new ArrayList<>();
//        for(WebElement el:links){
//            nameLinks.add(el.getText());
//            System.out.println(el.getAttribute("href"));
//        }
//
//        for (int i = 0; i < nameLinks.size(); i++) {
//            WebElement el = driver.findElement(By.linkText(nameLinks.get(i)));
//            el.click();
//            System.out.println("Page title "+ driver.getTitle());
//            System.out.println("Page url "+ driver.getCurrentUrl());
//            System.out.println("Number of cheetahs "+ StringUtils.countMatches(driver.getPageSource().toLowerCase(),"cheetah"));
//            driver.navigate().back();
//            Thread.sleep(30000);
//        }
//
//
//    }
//}
