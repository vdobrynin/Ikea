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
  }

  @FindBy(xpath = "(//*[@placeholder='What are you looking for?'])[1]")
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
