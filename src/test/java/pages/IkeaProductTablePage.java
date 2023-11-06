package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class IkeaProductTablePage extends Page {

    @FindBy(xpath = "(//div[contains(@class,'plp-button-container')])[3]")
    private WebElement thirdRowIcon;

    public void getThirdItemIcon() {

        fluentWait
            .until(ExpectedConditions.visibilityOf(thirdRowIcon));
        thirdRowIcon
            .isDisplayed();
    }

    @FindBy(xpath = "(//span[contains(@class,'btn__inner')])[19]")
    private WebElement addThirdItemToCart;

    public void addThirdItemToACart() throws InterruptedException {

        getExecutor()
            .executeScript("window.scrollBy(0,200)");
        fluentWait
            .until(ExpectedConditions.visibilityOf(thirdRowIcon));
        getExecutor()
            .executeScript("arguments[0].click();", addThirdItemToCart);
        fluentWait
            .until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("(//div[@class='hnf-page-container'])[1]")));
    }

    @FindBy(xpath = "(//div[@class='hnf-page-container'])[1]")
    private WebElement pageHeader;

    @FindBy(xpath = "//*[@class='hnf-btn__inner js-shopping-cart-icon']")
    private WebElement cartButton;

    public void getCartButton() {

        getExecutor()
            .executeScript("window.scrollBy(0,-500)");
        fluentWait
            .until(ExpectedConditions.visibilityOf(pageHeader));
        fluentWait
            .until(ExpectedConditions.visibilityOf(cartButton));
        getExecutor()
            .executeScript("arguments[0].click();", cartButton);
    }
}
