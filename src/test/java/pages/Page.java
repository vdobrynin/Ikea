package pages;

import org.openqa.selenium.support.PageFactory;
import support.TestContext;

public class Page {
  private String url;

  public Page() {
      PageFactory
          .initElements(TestContext.getDriver(), this);
  }

  public String getUrl() {
      return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void open() {
      TestContext
          .getDriver().get(url);
  }
}
