package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaCartPage extends Page {

    @FindBy(xpath = "(//div[@class='product_informationContainer__3ZLbC'])[1]")
    @CacheLookup
    private WebElement firstItem;

    @FindBy(xpath = "(//div[@class='product_informationContainer__3ZLbC'])[2]")
    @CacheLookup
    private WebElement secondItem;

    public String getCartListResult1() {
        getDriver().navigate().refresh();
        getWait().until(ExpectedConditions.visibilityOf(firstItem));
        firstItem.isSelected();
        return firstItem.getText();
    }

    public String getCartListResult2() {
        getWait().until(ExpectedConditions.visibilityOf(secondItem));
        secondItem.isSelected();
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
