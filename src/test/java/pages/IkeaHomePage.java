package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.getDriver;
import static support.TestContest.getWait;

public class IkeaHomePage extends Page {

  public IkeaHomePage() {
    setUrl("https://www.ikea.com/us/en/");
    getDriver().navigate().refresh();
  }

  @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
  @CacheLookup
  private WebElement getToSearchBox;

  public void searchInput() {
    getWait().until(ExpectedConditions.visibilityOf(getToSearchBox));
    getToSearchBox.isSelected();
  }

  @FindBy(xpath = "//*[@placeholder='What are you looking for?']")
  @CacheLookup
  private WebElement getSearchBox;

  @FindBy(xpath = "//*[@id='search-box__searchbutton']")
  @CacheLookup
  private WebElement searchButton;

  public void searchBox(String item) throws InterruptedException {
    getWait().until(ExpectedConditions.visibilityOf(getSearchBox));
    getSearchBox.sendKeys(item);
    searchButton.click();
    Thread.sleep(10000);
  }
}
