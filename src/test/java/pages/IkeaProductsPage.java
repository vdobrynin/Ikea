package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

import static support.TestContest.getDriver;
import static support.TestContest.getExecutor;

public class IkeaProductsPage extends Page {

    @FindBy(xpath = "//body/main[@id='content']/div[@class='search']/div[@class='products search__grid-item']" +
            "/section[@class='results']/div[@class='results__list']/div[@id='search-results']" +
            "/div[1]/div[2]/a[1]/div[1]/div[1]/h3[1]/span[1]")
    private WebElement firstFoundItem;

    public void firstFoundItem(String sofaUppland) {
        firstFoundItem.isSelected();
    }

    public void getFirstItem(String name) {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", firstFoundItem);
        getExecutor().executeScript("arguments[0].click();", firstFoundItem);
    }

    @FindBy(xpath = "//*[contains(text(),'Add to bag')]")
    @CacheLookup
    private WebElement addToCart;

    public void getItemToCart() {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", addToCart);
        getExecutor().executeScript("arguments[0].click();", addToCart);
    }

    @FindBy(xpath = "//*[@class='pip-header-section__title--small notranslate'][normalize-space()='JOKKMOKK']")
    @CacheLookup
    private WebElement thirdFoundItem;
//    private List<WebElement> thirdFoundItem;

    public void getThirdFoundItem(String table) { thirdFoundItem.isSelected(); }

    public void getThirdItem(String text) {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", extraItemsSideBar);
        getExecutor().executeScript("arguments[0].click();", extraItemsSideBar);
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", thirdFoundItem);
        getExecutor().executeScript("arguments[0].click();", thirdFoundItem);
    }

    @FindBy(xpath = "//button[@aria-label='Close modal']//span[@class='rec-btn__inner']")
    @CacheLookup
    private WebElement extraItemsSideBar;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        IkeaProductsPage that = (IkeaProductsPage) o;
//        return Objects.equals(firstFoundItem, that.firstFoundItem) && Objects.equals(addToCart, that.addToCart) && Objects.equals(thirdFoundItem, that.thirdFoundItem);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstFoundItem, addToCart, thirdFoundItem);
//    }
}
