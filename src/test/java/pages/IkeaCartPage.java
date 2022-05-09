package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContest.getExecutor;

public class IkeaCartPage extends Page {

    @FindBy(xpath = "//*[text() = '1']")
    public WebElement cartButton;

    public void getCartButton() {
        getExecutor().executeScript("arguments[0].scrollIntoView();", cartButton);
        getExecutor().executeScript("arguments[0].click();", cartButton);
    }
}
