package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContest.getDriver;
import static support.TestContest.getExecutor;

public class IkeaProductsPage extends Page {

    @FindBy(xpath = "//*[@id='search-results']/div[1]/div[2]/a/div/div[1]/h3/span[1]")
    public WebElement firstFoundItem;

    public void firstFoundItem(String sofaUppland) {
        firstFoundItem.isSelected();
    }

    public void getFirstItem(String name) {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", firstFoundItem);
        getExecutor().executeScript("arguments[0].click();", firstFoundItem);
    }

    @FindBy(xpath = "//*[@id='content']/div/div/div/div[2]/div[1]/div/div[9]/div/div/button/span/span")
    @CacheLookup
    public WebElement addToCart;

    public void getItemToCart() {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", addToCart);
        getExecutor().executeScript("arguments[0].click();", addToCart);
    }
}
