package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContest.getDriver;
import static support.TestContest.getExecutor;

public class IkeaCartPage extends Page {

    @FindBy(xpath = "//span[@class='hnf-btn__inner js-shopping-cart-icon']")
    @CacheLookup
    private WebElement cartButton;

    public void getCartButton() {
        PageFactory.initElements(getDriver(), this);
        getExecutor().executeScript("arguments[0].scrollIntoView();", cartButton);
        getExecutor().executeScript("arguments[0].click();", cartButton);
    }

    @FindBy(xpath = "(//div[@class='productList_productlist__2obpO'])[1]")
    @CacheLookup
    private WebElement listItems;

    public String getCartListResult() {
        return listItems.getText();
    }
}
