package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static support.TestContest.*;

public class IkeaProductTablesPage extends Page {

    @FindBy(xpath = "//body/main[@role='main']/div[@class='search']/div[@class='products search__grid-item']" +
            "/section[@class='results']/div[@class='results__list']/div[@class='serp-grid search-grid']/div[3]")
    @CacheLookup
    private WebElement thirdFoundItem;

    public void getThirdItem(String table) {
        getDriver().navigate().refresh();
        thirdFoundItem.isSelected();
    }

    @FindBy(xpath = "(//button[@type='button'])[13]")
    @CacheLookup
    private WebElement addThirdItemToCart;

    public void addThirdItemToACart() throws InterruptedException {
        getExecutor().executeScript("window.scrollBy(0,250)");
        getExecutor().executeScript("arguments[0].click();", addThirdItemToCart);
        Thread.sleep(5000);
    }
}
