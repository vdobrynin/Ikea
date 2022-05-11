package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContest.getDriver;
import static support.TestContest.getExecutor;

public class IkeaCartPage {

    @FindBy(xpath = "//*[text() = '1']")
    public WebElement cartButton;

    public void getCartButton() {
        PageFactory.initElements(getDriver(), this);
        getExecutor().executeScript("arguments[0].scrollIntoView();", cartButton);
        getExecutor().executeScript("arguments[0].click();", cartButton);
    }
}
