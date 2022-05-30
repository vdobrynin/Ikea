package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaProductTablePage extends Page {

    @FindBy(xpath = "//body/main[@role='main']/div[@class='search']/div[@class='products search__grid-item']" +
            "/section[@class='results']/div[@class='results__list']/div[@class='serp-grid search-grid']/div[3]")
    @CacheLookup
    private WebElement thirdFoundItem;

    public void getThirdItem(String table) {
        getDriver().navigate().refresh();
        getWait().until(ExpectedConditions.visibilityOf(thirdFoundItem));
        thirdFoundItem.isSelected();
    }

    @FindBy(xpath = "(//button[@type='button'])[13]")
    @CacheLookup
    private WebElement addThirdItemToCart;

    public void addThirdItemToACart() {
        getExecutor().executeScript("window.scrollBy(0,250)");
        getExecutor().executeScript("arguments[0].click();", addThirdItemToCart);
        getWait().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//div[@class='hnf-page-container'])[1]")));
    }

    @FindBy(xpath = "(//div[@class='hnf-page-container'])[1]")
    @CacheLookup
    private WebElement pageHeader;

    @FindBy(xpath = "//*[@class='hnf-btn__inner js-shopping-cart-icon']")
    @CacheLookup
    private WebElement cartButton;

    public void getCartButton() {
        getExecutor().executeScript("window.scrollBy(0,-250)");
        getWait().until(ExpectedConditions.visibilityOf(pageHeader));
        getWait().until(ExpectedConditions.visibilityOf(cartButton));
        getExecutor().executeScript("arguments[0].click();", cartButton);
    }
}
