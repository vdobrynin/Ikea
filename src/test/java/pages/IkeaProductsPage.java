package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static support.TestContest.getExecutor;

public class IkeaProductsPage extends Page {

    @FindBy(xpath = "//*[text() = 'UPPLAND']")
    public WebElement firstFoundItem;

    public void firstFoundItem(String sofaUppland) {
        firstFoundItem.getTagName();
    }

    public void getFirstItem() {
        getExecutor().executeScript("arguments[0].scrollIntoView();", firstFoundItem);
        getExecutor().executeScript("arguments[0].click();", firstFoundItem);
    }

    @FindBy(xpath = "//*[text() = 'Add to bag']")
    @CacheLookup
    public WebElement addToBag;

    public void getItemToBag() {
        getExecutor().executeScript("arguments[0].scrollIntoView();", addToBag);
        getExecutor().executeScript("arguments[0].click();", addToBag);
    }
}
