package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.IkeaCartPage;
import pages.IkeaHomePage;
import pages.IkeaProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class IkeaStepDefs {

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        new IkeaHomePage().open();
    }

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
        new IkeaProductsPage().getFirstItem(text);
    }

    @Then("I add item {string} to cart")
    public void iAddItemToCart(String text) {
        new IkeaProductsPage().getItemToCart();
    }

    @And("On page I find {string} item")
    public void onPageIFindItem(String text) {
        new IkeaProductsPage().getThirdItem(text);
    }

    @Then("I open cart")
    public void iOpenCart() {
        new IkeaCartPage().getCartButton();
    }

    @And("I validate that two items in cart")
    public void iValidateThatTwoItemsInCart() {
        IkeaCartPage cartPage = new  IkeaCartPage();
        String actualResultText = cartPage.getCartListResult();

        assertThat(actualResultText).containsIgnoringCase(("uppland"));
        assertThat(actualResultText).containsIgnoringCase(("jokkmokk"));
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
