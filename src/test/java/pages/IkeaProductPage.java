package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class IkeaProductPage extends Page {

    @FindBy(xpath="//a[@aria-label='UPPLAND - Sofa']//span[2]//img[1]")
    @CacheLookup
    private WebElement firstFoundItem;

    public WebElement getFirstFoundItem() {
        return firstFoundItem;
    }
}
