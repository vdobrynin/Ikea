package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static support.TestContest.getDriver;

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

  @FindBy(xpath = "//*[@placeholder='What are you looking for?']")
  @CacheLookup
  private WebElement getSearchBox;

  @FindBy(xpath = "//*[@id='search-box__searchbutton']")
  @CacheLookup
  private WebElement searchButton;

  public void searchBox(String item) throws InterruptedException {
    getSearchBox.sendKeys(item);
    searchButton.click();
    Thread.sleep(10);
  }
}
