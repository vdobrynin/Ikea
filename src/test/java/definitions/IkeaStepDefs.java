package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.IkeaCartPage;
import pages.IkeaHomePage;
import pages.IkeaProductSofaPage;
import pages.IkeaProductTablePage;

import static org.assertj.core.api.Assertions.assertThat;

public class IkeaStepDefs {

  @Given("I go to {string} page")
  public void iGoToPage(String page) {
    new IkeaHomePage().open();
  }

  @When("I go to input box {string}")
  public void iGoToInputBox() {
    new IkeaHomePage().searchInput();
  }

  @And("I search for {string} in store")
  public void iSearchForInStore(String text) throws InterruptedException {
    new IkeaHomePage().searchBox(text);
  }

  @And("On product page I find {string} item")
  public void onProductPageIFindItem() {
    new IkeaProductSofaPage().getFirstItem();
  }

  @Then("I add item to cart")
  public void iAddItemToCart() throws InterruptedException {
    new IkeaProductSofaPage().getFirstItemToCart();
  }

  @Then("I go to search bar at the top of the page to enter {string}")
  public void iGoToSearchBarAtTheTopOfThePageToEnter(String text) throws InterruptedException {
    new IkeaProductSofaPage().search(text);
  }

  @Then("I search for {string} at store")
  public void iSearchForAtStore() {
    new IkeaProductTablePage().getThirdItem();
  }

  @Then("I add item to a cart")
  public void iAddItemToACart() throws InterruptedException {
    new IkeaProductTablePage().addThirdItemToACart();
  }

  @Then("I open cart")
  public void iOpenCart() throws InterruptedException {
    new IkeaProductTablePage().getCartButton();
  }

  @And("I validate that two items in cart")
  public void iValidateThatTwoItemsInCart() throws InterruptedException {
    IkeaCartPage cartPage = new IkeaCartPage();

    String actualText1 = cartPage.getCartListResult1();
    assertThat(actualText1).toString().trim().equalsIgnoreCase("table");

    String actualText2 = cartPage.getCartListResult2();
    assertThat(actualText1).toString().trim().equalsIgnoreCase("sofa");
  }

  @When("I enter discount code {string} to apply")
  public void iEnterDiscountCodeToApply(String code) {
    new IkeaCartPage().clickAndEnterDiscountCode(code);
  }

  @Then("I validate that {string} but error message is displayed")
  public void iValidateThatButErrorMessageIsDisplayed(String text) {
    IkeaCartPage errorDisplay = new IkeaCartPage();
    String actualErrorText = errorDisplay.getErrorMessage();

    assertThat(actualErrorText).contains("You've added an invalid coupon code. Please try again.");
  }
}
