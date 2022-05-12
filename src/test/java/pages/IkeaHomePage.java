package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.TestContest;

import static support.TestContest.getDriver;
import static support.TestContest.getExecutor;

public class IkeaHomePage extends Page {

    public IkeaHomePage() {
        setUrl("https://www.ikea.com/us/en");
    }

    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getToSearchBox;


    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    @CacheLookup
    private WebElement okButton;


    public void searchInput(String findString) {
        TestContest.getExecutor().executeScript("arguments[0].click();", okButton);
        getToSearchBox.isSelected();
    }

    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getSearchBox;


    @FindBy(xpath = "//*[@id='search-box__searchbutton']")
    @CacheLookup
    private WebElement searchButton;

    public IkeaHomePage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    public void searchBox(String sofa) {
        PageFactory.initElements(getDriver(), this);
        getSearchBox.sendKeys(sofa);
        searchButton.submit();
    }
}
