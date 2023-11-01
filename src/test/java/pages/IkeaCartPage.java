package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class IkeaCartPage extends Page {

    @FindBy(xpath = "(//div[contains(@class,'product_contents__ha7uc')])[1]")
    private WebElement firstItemInCart;

    public String getCartListResult1() {
        return firstItemInCart.getText();
    }

    @FindBy(xpath = "(//div[contains(@class,'product_contents__ha7uc')])[2]")
    private WebElement secondItemInCart;

    public String getCartListResult2() {

        getExecutor()
            .executeScript("arguments[0].scrollIntoView(true);", secondItemInCart);
        return secondItemInCart.getText();
    }

    @FindBy(xpath = "(//span[@class='cart-ingka-accordion-item-header__title'])[1]")
    private WebElement discountHeader;

    @FindBy(xpath = "(//input[contains(@id,'discountCode')])[1]")
    private WebElement discountCode;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement applyButton;

    public void clickAndEnterDiscountCode(String text) {

        getExecutor()
            .executeScript("window.scrollBy(0,-300)");
        fluentWait
            .until(ExpectedConditions.visibilityOf(discountHeader));
        discountHeader
            .click();
        discountCode
            .sendKeys(text);
        getExecutor()
            .executeScript("arguments[0].scrollIntoView(true);", applyButton);
        getExecutor()
            .executeScript("arguments[0].click();", applyButton);
    }

    @FindBy(xpath = "//span[@id='discount-code__error']")
    private WebElement errorMessage;

    public String getErrorMessage() {

        getExecutor()
            .executeScript("arguments[0].scrollIntoView(true);", errorMessage);
        return errorMessage
            .getText();
    }
}
