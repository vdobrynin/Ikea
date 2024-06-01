package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class IkeaCartPage extends Page {

    @FindBy(xpath = "(//div[@data-testid='product_list_product_group_items'])[1]")
    private WebElement firstItemInCart;

    public String getCartListResult1() {

        fluentWait
            .until(ExpectedConditions.visibilityOf(firstItemInCart));
        return firstItemInCart.getText();
    }

    @FindBy(xpath = "(//div[@data-testid='product_list_product_group_items'])[1]")
    private WebElement secondItemInCart;

    public String getCartListResult2() {

        return secondItemInCart.getText();
    }

    @FindBy(xpath = "(//div[contains(text(),'Have a discount code?')])[1]")
    private WebElement discountHeader;

    @FindBy(xpath = "(//input[contains(@id,'discountCode')])[1]")
    private WebElement discountCode;

    @FindBy(css = "button[type='submit'] span[class='cart-ingka-btn__inner']")
    private WebElement applyButton;

    public void clickAndEnterDiscountCode(String text) throws InterruptedException {

        getExecutor()
            .executeScript("window.scrollBy(0,-400)");
//        fluentWait
//            .until(ExpectedConditions.visibilityOf(discountHeader));
        discountHeader
            .click();
        discountCode
            .sendKeys(text);
//        getExecutor()
//            .executeScript("arguments[0].scrollIntoView(true);", applyButton);
        getExecutor()
            .executeScript("arguments[0].click();", applyButton);
        Thread.sleep(500);
    }

    @FindBy(xpath = "//span[@id='discount-code__error']")
    private WebElement errorMessage;

    public String getErrorMessage() throws InterruptedException {

//        getExecutor()
//            .executeScript("arguments[0].scrollIntoView(true);", errorMessage);
        Thread.sleep(500);
        return errorMessage
            .getText();
    }
}
