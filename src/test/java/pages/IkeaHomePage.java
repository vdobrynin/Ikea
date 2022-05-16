package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import support.TestContest;

import static support.TestContest.getDriver;

public class IkeaHomePage extends Page {

    public IkeaHomePage() {
        setUrl("https://www.ikea.com/us/en");
    }

    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getToSearchBox;

//    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
//    @CacheLookup
//    private WebElement okCookieButton;

    public void searchInput(String findString) {
//        TestContest.getExecutor().executeScript("arguments[0].click();", okCookieButton);
        getToSearchBox.isSelected();
    }

    @FindBy(xpath = "//*[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getSearchBox;

    @FindBy(xpath = "//*[@id='search-box__searchbutton']")
    @CacheLookup
    private WebElement searchButton;

    public void searchBox(String item) {
        getSearchBox.sendKeys(item);
        searchButton.click();
    }
}
