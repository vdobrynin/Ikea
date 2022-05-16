package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaCartPage extends Page {

    @FindBy(xpath = "//*[@class='hnf-btn__inner js-shopping-cart-icon']")
    @CacheLookup
    private WebElement cartButton;

    public void getCartButton() {
        getExecutor().executeScript("window.scrollBy(0,-250)");
        getExecutor().executeScript("arguments[0].click();", cartButton);
    }

    @FindBy(xpath = "(//div[@class='productList_productlist__2obpO'])[1]")
    @CacheLookup
    private WebElement listItems;

    public String getCartListResult() { return listItems.getText(); }

    @FindBy(xpath = "//*[@class='cart-ingka-accordion-item-header__title']")
    @CacheLookup
    private WebElement discountField;

    @FindBy(xpath = "//*[@id='discountCode']")
    @CacheLookup
    private WebElement discountCode;

    public void clickAndEnterDiscountCode(String text) {
        discountField.click();
        discountCode.sendKeys(text);

        getExecutor().executeScript("window.scrollBy(0,250)");
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
