package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContest.*;

public class IkeaCartPage extends Page {

  @FindBy(xpath = "(//div[@class='productList_productlist__2kDY-']//ul[@id='aria_product_description_29420393'])[1]")
  private WebElement firstItemInCart;

  public String getCartListResult1() {
    return firstItemInCart.getText();
  }

  @FindBy(xpath = "(//div[@class='productList_productlist__2kDY-']//ul[@id='aria_product_description_19384116'])[1]")
  private WebElement secondItemInCart;

  public String getCartListResult2() {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", secondItemInCart);
    return secondItemInCart.getText();
  }

  @FindBy(xpath = "//div[@class='cart-ingka-ssr-label'][contains(.,'Have a discount code?')]")
  private WebElement discountHeader;

  @FindBy(xpath = "//input[contains(@id,'discountCode')]")
  private WebElement discountCode;

  @FindBy(xpath = "(//span[contains(@class,'cart-ingka-btn__inner')])[3]")
  private WebElement applyButton;

  public void clickAndEnterDiscountCode(String text) {
    discountHeader.click();
    discountCode.sendKeys(text);
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", applyButton);
    getExecutor().executeScript("arguments[0].click();", applyButton);
  }

  @FindBy(xpath = "//*[@class='cart-ingka-form-field__message']")
  private WebElement errorMessage;

  public String getErrorMessage() {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", errorMessage);
    return errorMessage.getText();
  }
}
