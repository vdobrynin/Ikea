package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import static support.TestContest.getDriver;

public class IkeaProductsPage extends Page {

    @FindBy(xpath = "//*[text() = 'UPPLAND']")
    public WebElement firstFoundItem;

    public void firstFoundItem(String sofaUppland) {
        firstFoundItem.getTagName();
    }

    public void getFirstItem() {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView();", firstFoundItem);
        js.executeScript("arguments[0].click();", firstFoundItem);
    }

    @FindBy(xpath = "//*[text() = 'Add to bag']")
    @CacheLookup
    public WebElement addToBag;

    public void getItemToBag() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView();", addToBag);
        js.executeScript("arguments[0].click();", addToBag);
        Thread.sleep(3000);
    }
}
