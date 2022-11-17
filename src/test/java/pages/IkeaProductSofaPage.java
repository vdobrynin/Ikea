package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaProductSofaPage extends Page {

  @FindBy(xpath = "(//*[name()='svg'][@class='svg-icon button__add-to-cart-icon'])[1]")
  private WebElement firstItemSvg;

  @FindBy(xpath = "(//button[@type='button'])[8]")
  private WebElement addFirstItemToCart;

  public void getFirstItemToCart() {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", firstItemSvg);
    getWait().until(ExpectedConditions.visibilityOf(firstItemSvg));
    getExecutor().executeScript("arguments[0].click();", addFirstItemToCart);
    getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='hnf-page-container'])[1]")));
    getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='hnf-btn__inner js-shopping-cart-icon']")));
  }

  @FindBy(xpath = "(//*[@placeholder='What are you looking for?'])[1]")
  private WebElement getSearchBox;

  @FindBy(xpath = "(//button[@id='search-box__searchbutton'])[1]")
  private WebElement searchButton;

  @FindBy(xpath = "//button[@id='clear-input']")
  private WebElement clearInput;

  public void search(String text) {
    getExecutor().executeScript("window.scrollBy(0,-250)");
    getExecutor().executeScript("arguments[0].click();", getSearchBox);
    clearInput.click();
    getSearchBox.sendKeys(text);
    getWait().until(ExpectedConditions.visibilityOf(searchButton));
    searchButton.click();
  }
}
