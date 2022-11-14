package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaProductSofaPage extends Page {

  @FindBy(xpath = "(//div[@class='serp-grid__item search-grid__item product-fragment'])[1]")
  @CacheLookup
  private WebElement firstRowItem;

  public void getFirstItem() {
    getWait().until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("(//div[@class='serp-grid__item search-grid__item product-fragment'])[1]")));
    firstRowItem.isSelected();
  }

  @FindBy(xpath = "(//*[name()='svg'][@class='svg-icon button__add-to-cart-icon'])[1]")
  @CacheLookup
  private WebElement firstItemSvg;

  @FindBy(xpath = "(//button[@type='button'])[8]")
  @CacheLookup
  private WebElement addFirstItemToCart;

  public void getFirstItemToCart() {
    getExecutor().executeScript("window.scrollBy(0,250)");
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", firstRowItem);
    getWait().until(ExpectedConditions.visibilityOf(firstRowItem));
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", firstItemSvg);
    getWait().until(ExpectedConditions.visibilityOf(firstItemSvg));
    getExecutor().executeScript("arguments[0].click();", addFirstItemToCart);
    getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='hnf-page-container'])[1]")));
    getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='hnf-btn__inner js-shopping-cart-icon']")));
  }

  @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
  @CacheLookup
  private WebElement getSearchBox;

  @FindBy(xpath = "//*[@id='search-box__searchbutton']")
  @CacheLookup
  private WebElement searchButton;

  @FindBy(xpath = "//button[@id='clear-input']")
  @CacheLookup
  private WebElement clearInput;

  public void search(String item) {
    getExecutor().executeScript("window.scrollBy(0,-250)");
    getExecutor().executeScript("arguments[0].click();", getSearchBox);
    clearInput.click();
    getSearchBox.sendKeys(item);
    searchButton.click();
  }
}
