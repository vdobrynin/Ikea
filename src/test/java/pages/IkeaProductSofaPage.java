package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaProductSofaPage extends Page {

  @FindBy(xpath = "//body/main[@id='content']/div[@class='search']/div[@class='products search__grid-item']" +
      "/section[@class='results']/div[@class='results__list']/div[@id='search-results']/div[1]")
  @CacheLookup
  private WebElement firstFoundItem;

  public void getFirstItem(String name) {
    getWait().until(ExpectedConditions.visibilityOf(firstFoundItem));
    firstFoundItem.isSelected();
  }

  @FindBy(xpath = "(//button[@type='button'])[8]")
  @CacheLookup
  private WebElement addFirstItemToCart;

  public void getFirstItemToCart() throws InterruptedException {
    getExecutor().executeScript("window.scrollBy(0,250)");
    getExecutor().executeScript("arguments[0].click();", addFirstItemToCart);
    Thread.sleep(10);
    getWait().until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("(//div[@class='hnf-page-container'])[1]")));
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

  public void search(String item) throws InterruptedException {
    getExecutor().executeScript("window.scrollBy(0,-250)");
    getExecutor().executeScript("arguments[0].click();", getSearchBox);
    clearInput.click();
    getSearchBox.sendKeys(item);
    searchButton.click();
    Thread.sleep(10);
  }
}
