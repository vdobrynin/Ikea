package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaProductTablePage extends Page {

  @FindBy(xpath = "(//*[name()='svg'][@class='svg-icon button__add-to-cart-icon'])[3]")
  @CacheLookup
  private WebElement thirdRowIcon;

  public void getThirdItem() {
    thirdRowIcon.isSelected();
  }

  @FindBy(xpath = "(//div[@class='serp-grid__item search-grid__item product-fragment'])[3]")
  @CacheLookup
  private WebElement thirdRowButtonItem;


  @FindBy(xpath = "(//button[@type='button'])[12]")
  @CacheLookup
  private WebElement addThirdItemToCart;

  public void addThirdItemToACart() throws InterruptedException {
    getExecutor().executeScript("window.scrollBy(0,250)");
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", thirdRowButtonItem);
    getExecutor().executeScript("arguments[0].click();", addThirdItemToCart);
    Thread.sleep(10000);
    getWait().until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("(//div[@class='hnf-page-container'])[1]")));
  }

  @FindBy(xpath = "(//div[@class='hnf-page-container'])[1]")
  @CacheLookup
  private WebElement pageHeader;

  @FindBy(xpath = "//*[@class='hnf-btn__inner js-shopping-cart-icon']")
  @CacheLookup
  private WebElement cartButton;

  public void getCartButton() throws InterruptedException {
    getExecutor().executeScript("window.scrollBy(0,-250)");
    getWait().until(ExpectedConditions.visibilityOf(pageHeader));
    getWait().until(ExpectedConditions.visibilityOf(cartButton));
    getExecutor().executeScript("arguments[0].click();", cartButton);
    Thread.sleep(10000);
  }
}
