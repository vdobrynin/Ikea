package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class IkeaProductSofaPage extends Page {

    @FindBy(xpath = "(//div[@class='plp-button-container'])[1]")
    private WebElement firstItemButton;

    @FindBy(xpath = "(//span[@class='btn__inner'])[1]")
    private WebElement addFirstItemToCart;

    public void getFirstItemToCart() throws InterruptedException {

        getExecutor()
            .executeScript("window.scrollBy(0,200)");
        getExecutor()
            .executeScript("arguments[0].click();", addFirstItemToCart);
        fluentWait
            .until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("(//div[@class='hnf-page-container'])[1]")));
        fluentWait
            .until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@class='hnf-btn__inner js-shopping-cart-icon']")));
    }

    @FindBy(xpath = "(//span[@class='search-box__button-wrapper-item'])[1]")
    private WebElement headerSearch;

    @FindBy(xpath = "(//*[@placeholder='What are you looking for?'])[1]")
    private WebElement getSearchBox;

    @FindBy(xpath = "(//button[@id='clear-input'])[1]")
    private WebElement clearInput;

    @FindBy(xpath = "(//button[@id='search-box__searchbutton'])[1]")
    private WebElement searchButton;

    public void search(String text) {

        getExecutor()
            .executeScript("window.scrollBy(0,-500)");
        getExecutor()
            .executeScript("arguments[0].scrollIntoView(true);", headerSearch);
        fluentWait
            .until(ExpectedConditions.visibilityOf(getSearchBox));
        getExecutor()
            .executeScript("arguments[0].click();", getSearchBox);
        clearInput
            .click();
        getSearchBox
            .sendKeys(text);
        fluentWait
            .until(ExpectedConditions.visibilityOf(searchButton));
        searchButton
            .click();
    }
}
