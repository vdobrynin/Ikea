package pages;

import org.openqa.selenium.support.PageFactory;
import support.TestContest;

public class Page {

    private String url;

    public Page() {
        PageFactory.initElements(TestContest.getDriver(), this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void open() {
        TestContest.getDriver().get(url);
    }
}
