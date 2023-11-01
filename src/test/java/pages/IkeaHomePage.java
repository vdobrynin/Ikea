package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.fluentWait;
import static support.TestContext.getWait;

public class IkeaHomePage extends Page {

    public IkeaHomePage() {

        setUrl("https://www.ikea.com/us/en/");
    }

    @FindBy(xpath = "(//*[@placeholder='What are you looking for?'])[1]")
    private WebElement getSearchBox;

    @FindBy(xpath = "(//button[@id='search-box__searchbutton'])[1]")
    private WebElement searchButton;

    public void searchBox(String item) {

        getSearchBox
            .sendKeys(item);
        fluentWait
            .until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }
}
