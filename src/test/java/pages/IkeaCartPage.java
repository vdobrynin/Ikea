package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaCartPage extends Page {

  @FindBy(xpath = "//*[@id='aria_product_description_20011408']/li[2]/span[1]")
  @CacheLookup
  private WebElement firstItem;

  @FindBy(xpath = "//*[@id='aria_product_description_19384116']/li[2]/span[1]")
  @CacheLookup
  private WebElement secondItem;

  public String getCartListResult1() throws InterruptedException {
    getWait().until(ExpectedConditions
        .visibilityOfElementLocated(By
            .xpath("//*[@id='aria_product_description_20011408']/li[2]/span[1]")));

    getExecutor().executeScript("arguments[0].scrollIntoView(true);", firstItem);
    getWait().until(ExpectedConditions.visibilityOf(firstItem));
    firstItem.click();
    return firstItem.getText();
  }

  public String getCartListResult2() throws InterruptedException {
    getWait().until(ExpectedConditions
        .visibilityOfElementLocated(By
            .xpath("//*[@id='aria_product_description_19384116']/li[2]/span[1]")));
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", secondItem);
    getWait().until(ExpectedConditions.visibilityOf(secondItem));
    secondItem.click();
    return secondItem.getText();
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

  public String getErrorMessage(String text) {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", errorMessage);
    return errorMessage.getText();
  }

  @FindBy(xpath = "//*[@type='submit']//*[@class='cart-ingka-btn__inner']")
  @CacheLookup
  private WebElement applyButton;
}
