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
    public void iGoToPage(String page) { new IkeaHomePage().open(); }

    @When("I go to input box {string}")
    public void iGoToInputBox(String inputBox) {
        new IkeaHomePage().searchInput(inputBox);
    }

    @And("I search for {string} in store")
    public void iSearchForInStore(String text) {
        new IkeaHomePage().searchBox(text);
    }

    @And("On product page I find {string} item")
    public void onProductPageIFindItem(String text) {
        new IkeaProductSofaPage().getFirstItem(text);
    }

    @Then("I add item to cart")
    public void iAddItemToCart() {
        new IkeaProductSofaPage().getFirstItemToCart();
    }

    @Then("I go to search bar at the top of the page to enter {string}")
    public void iGoToSearchBarAtTheTopOfThePageToEnter(String text) {
        new IkeaProductSofaPage().search(text);
    }

    @Then("I search for {string} at store")
    public void iSearchForAtStore(String text) {
        new IkeaProductTablePage().getThirdItem(text);
    }

    @Then("I add item to a cart")
    public void iAddItemToACart() {
        new IkeaProductTablePage().addThirdItemToACart();
    }

    @Then("I open cart")
    public void iOpenCart() {
        new IkeaProductTablePage().getCartButton();
    }

    @And("I validate that two items in cart")
    public void iValidateThatTwoItemsInCart() {
        IkeaCartPage cartPage = new IkeaCartPage();

        String actualText1 = cartPage.getCartListResult1();
        assertThat(actualText1).toString().trim().equalsIgnoreCase("sofa");

        String actualText2 = cartPage.getCartListResult2();
        assertThat(actualText1).toString().trim().equalsIgnoreCase("table");
    }

    @When("I enter discount code {string} to apply")
    public void iEnterDiscountCodeToApply(String code) {
        new IkeaCartPage().clickAndEnterDiscountCode(code);
    }

    @Then("I validate that {string} but error message is displayed")
    public void iValidateThatButErrorMessageIsDisplayed(String text) {
        IkeaCartPage errorDisplay = new IkeaCartPage();
        String actualErrorText = errorDisplay.getErrorMessage(text);

        assertThat(actualErrorText).contains("You've added an invalid coupon code. Please try again.");
    }
}
