package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaCartPage extends Page {

  @FindBy(xpath = "(//div[@class='productList_productlist__2kDY-']//ul[@id='aria_product_description_29420393'])[1]")
  @CacheLookup
  private WebElement firstItemInCart;

  @FindBy(xpath = "(//div[@class='productList_productlist__2kDY-']//ul[@id='aria_product_description_19384116'])[1]")
  @CacheLookup
  private WebElement secondItemInCart;

  public String getCartListResult1() {
    getWait().until(ExpectedConditions.visibilityOf(firstItemInCart));
    firstItemInCart.click();
    return firstItemInCart.getText();
  }

  public String getCartListResult2() {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", secondItemInCart);
    secondItemInCart.click();
    return secondItemInCart.getText();
  }

  @FindBy(xpath = "//*[@class='cart-ingka-accordion-item-header__title']")
  @CacheLookup
  private WebElement discountField;

  @FindBy(xpath = "//*[@id='discountCode']")
  @CacheLookup
  private WebElement discountCode;

  public void clickAndEnterDiscountCode(String text) {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", discountField);
    discountField.click();
    discountCode.sendKeys(text);

    getExecutor().executeScript("arguments[0].scrollIntoView(true);", applyButton);
    getExecutor().executeScript("arguments[0].click();", applyButton);
  }

  @FindBy(xpath = "//*[@class='cart-ingka-form-field__message']")
  @CacheLookup
  private WebElement errorMessage;

  public String getErrorMessage() {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", errorMessage);
    return errorMessage.getText();
  }

  @FindBy(xpath = "//*[@type='submit']//*[@class='cart-ingka-btn__inner']")
  @CacheLookup
  private WebElement applyButton;
}
