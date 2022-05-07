package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static support.TestContest.getDriver;

public class IkeaHomePage extends Page {

    public IkeaHomePage() {
        setUrl("https://www.ikea.com/us/en");
    }

    @FindBy(xpath = "//body//header//div[@class='hnf-page-container']" +
            "//div[@class='hnf-header__container hnf-page-container__main']" +
            "//div[@class='hnf-header__search']//div[@data-css-scope='search-box']" +
            "//form[@role='search']//div[@class='search-wrapper']" +
            "//input[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getToSearchBox;

    public void searchInput(String findString) {
        getDriver().findElement(By.xpath("//body//header//div[@class='hnf-page-container']" +
                "//div[@class='hnf-header__container hnf-page-container__main']" +
                "//div[@class='hnf-header__search']//div[@data-css-scope='search-box']" +
                "//form[@role='search']//div[@class='search-wrapper']" +
                "//input[@placeholder='What are you looking for?']")).isSelected();
        getToSearchBox.click();
    }

    @FindBy(xpath = "//body//header//div[@class='hnf-page-container']" +
            "//div[@class='hnf-header__container hnf-page-container__main']//div[@class='hnf-header__search']" +
            "//div[@data-css-scope='search-box']//form[@role='search']//div[@class='search-wrapper']" +
            "//input[@placeholder='What are you looking for?']")
    @CacheLookup
    private WebElement getSearchBox;

    public void searchBox(String sofa) {
        getSearchBox.sendKeys(sofa);
        getSearchBox.click();
    }
}
