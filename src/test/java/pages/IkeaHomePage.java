package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static support.TestContest.getDriver;
import static support.TestContest.getExecutor;

public class IkeaHomePage extends Page {

    public IkeaHomePage() {
        setUrl("https://www.ikea.com/us/en");
    }

    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getToSearchBox;

    public void searchInput(String findString) {
        getToSearchBox.isSelected();
    }

    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getSearchBox;

    @FindBy(cssSelector = "#search-box__searchbutton")
    @CacheLookup
    private WebElement searchButton;

    public void searchBox(String sofa) throws InterruptedException {
        getSearchBox.sendKeys(sofa);
        Thread.sleep(1000);

        searchButton.findElement(By.cssSelector("#search-box__searchbutton")).sendKeys(Keys.ENTER);
/*
        searchButton.sendKeys(Keys.ENTER);
        Actions act = new Actions(getDriver());
        searchButton.sendKeys((CharSequence) getExecutor().executeScript("arguments[0].click();", searchButton));
        act.click(searchButton).perform();
*/
        Thread.sleep(1000);
    }
}
