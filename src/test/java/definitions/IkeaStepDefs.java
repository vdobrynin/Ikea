package definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import pages.IkeaCartPage;
import pages.IkeaHomePage;
import pages.IkeaProductSofaPage;
import pages.IkeaProductTablePage;

import static org.assertj.core.api.Assertions.assertThat;

public class IkeaStepDefs {
    @Given("I go to Ikea page")
    public void iGoToIkeaPage() {
        new IkeaHomePage()
            .open();
    }

    @Then("I search for {string} in store")
    public void iSearchForInStore(String sofa) {
        new IkeaHomePage()
            .searchBox(sofa);
    }

    @Then("I add item to cart")
    public void iAddItemToCart() throws InterruptedException {
        new IkeaProductSofaPage()
            .getFirstItemToCart();
    }

    @Then("I go to search bar at the top of the page to enter {string}")
    public void iGoToSearchBarAtTheTopOfThePageToEnter(String table) {
        new IkeaProductSofaPage()
            .search(table);
    }

    @Then("I add item to a cart")
    public void iAddItemToACart() throws InterruptedException {
        new IkeaProductTablePage()
            .addThirdItemToACart();
    }

    @Then("I open cart")
    public void iOpenCart() {
        new IkeaProductTablePage()
            .getCartButton();
    }

    @Then("I validate that two items in cart")
    public void iValidateThatTwoItemsInCart() {
        IkeaCartPage cartPage = new IkeaCartPage();
        String actualText1 = cartPage.getCartListResult1();
        assertThat(actualText1)
            .toString()
            .trim()
            .equalsIgnoreCase("table");

        String actualText2 = cartPage.getCartListResult2();
        assertThat(actualText2)
            .toString()
            .trim()
            .equalsIgnoreCase("sofa");
    }

    @When("I enter discount code {string} to apply")
    public void iEnterDiscountCodeToApply(String code) {
        new IkeaCartPage()
            .clickAndEnterDiscountCode(code);
    }

    @Then("I validate that {string} but error message is displayed")
    public void iValidateThatButErrorMessageIsDisplayed(String errorMessage) {
        IkeaCartPage errorDisplay = new IkeaCartPage();
        String actualErrorText = errorDisplay
            .getErrorMessage();
        assertThat(actualErrorText)
            .contains(errorMessage);
    }
}
