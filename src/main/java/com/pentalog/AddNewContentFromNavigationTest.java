package com.pentalog;

import com.pentalog.poms.AddNewContentFromNavigation;
import com.pentalog.poms.CreateArticle;
import com.pentalog.poms.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


@Test
public class AddNewContentFromNavigationTest extends BaseTest {

    String addContentPath = "//h1[@id='overlay-title' and contains(text(),'Add content')]";
    String createArticlePath = "//h1[@id = 'overlay-title' and contains(text(),'Create Article')]";

    public void testAddNewContent() throws InterruptedException {
        LoginPage loginObj = new LoginPage(driver);
        loginObj.login("Admin", "Lallala_LandAdmin1");
        AddNewContentFromNavigation addNewContent = new AddNewContentFromNavigation(driver);
        addNewContent.clickOnAddNewContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Add content dialog']")));
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOf(
                            driver.findElement(By.xpath(addContentPath))
                            )
                    );
        addNewContent.clickOnArticleLink();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Create Article dialog']")));
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOf(
                            driver.findElement(By.xpath(createArticlePath))
                            )
                    );
        CreateArticle createArticle = new CreateArticle(driver);
        createArticle.createArticle("Fox","#fox, #vixen, #redfox",
                "Foxes are small-to-medium-sized, omnivorous mammals belonging to several genera of the family Canidae. Foxes have a flattened skull, upright triangular ears, a pointed, slightly upturned snout, and a long bushy tail (or brush).\n" +
                        "\n" +
                        "Twelve species belong to the monophyletic \"true foxes\" group of genus Vulpes. Approximately another 25 current or extinct species are always or sometimes called foxes; these foxes are either part of the paraphyletic group of the South American foxes, or of the outlying group, which consists of the bat-eared fox, gray fox, and island fox.[1] Foxes live on every continent except Antarctica. By far the most common and widespread species of fox is the red fox (Vulpes vulpes) with about 47 recognized subspecies.[2] The global distribution of foxes, together with their widespread reputation for cunning, has contributed to their prominence in popular culture and folklore in many societies around the world. The hunting of foxes with packs of hounds, long an established pursuit in Europe, especially in the British Isles, was exported by European settlers to various parts of the New World.","Plain text",
                "//Users/felicia/Desktop/demoproject31/fox.jpg",
                "Interesting facts about foxes", "-- Home",  "1");
    }
}
